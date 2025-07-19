pipeline {
  agent any
    tools {
        jdk 'jdk17'
    }

  environment {
    DOCKERHUB_CREDENTIALS = credentials('ae798623-fda7-4c12-9b30-89db69efe0e7')
    DOCKER_REGISTRY = 'maazmohemmed'
  }

  stages {
    stage('Clone Repository') {
      steps {
        git branch: 'main', credentialsId: '9a318c7f-5810-483f-90e9-5332b135bdce', url: 'https://github.com/maazmohemmed/Jenkins_StreamPlatform'
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
          sh 'mvn clean package -DskipTests'
          sh 'cp target/streaming-1.0.0.war target/streaming.war'
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
        sh '/usr/bin/docker compose down'
        sh '/usr/bin/docker compose up -d'
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
