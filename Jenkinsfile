pipeline {
  agent any

  environment {
    DOCKERHUB_CREDENTIALS = credentials('dae798623-fda7-4c12-9b30-89db69efe0e7')
    DOCKER_REGISTRY = 'maazmohemmed'
  }

  stages {
    stage('Clone Repository') {
      steps {
        git 'https://github.com/your-username/streaming-app.git'
      }
    }

    stage('Build Frontend Image') {
      steps {
        dir('frontend') {
          script {
            sh 'docker build -t $DOCKER_REGISTRY/frontend:latest .'
          }
        }
      }
    }

    stage('Build Backend') {
      steps {
        dir('backend') {
          sh 'mvn clean install'
        }
      }
    }

    stage('Build Backend Image') {
      steps {
        dir('backend') {
          script {
            sh 'docker build -t $DOCKER_REGISTRY/backend:latest .'
          }
        }
      }
    }

    stage('Push Docker Images') {
      steps {
        script {
          sh 'docker login -u $DOCKER_REGISTRY -p $DOCKERHUB_CREDENTIALS_PSW'
          sh 'docker push $DOCKER_REGISTRY/frontend:latest'
          sh 'docker push $DOCKER_REGISTRY/backend:latest'
        }
      }
    }

    stage('Deploy Containers') {
      steps {
        sh 'docker-compose down || true'
        sh 'docker-compose up -d'
      }
    }

    stage('Test Placeholder') {
      steps {
        echo 'Running unit and integration tests (placeholder)'
      }
    }

    stage('Security Scan Placeholder') {
      steps {
        echo 'Security scanning (placeholder)'
      }
    }
  }
}
