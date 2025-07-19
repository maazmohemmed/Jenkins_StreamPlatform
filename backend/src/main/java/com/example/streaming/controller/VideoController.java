package com.example.streaming.controller;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api/video")
public class VideoController {

  @GetMapping("/{filename:.+}")
  public ResponseEntity<Resource> streamVideo(@PathVariable String filename) {
    try {
      Path videoPath = Paths.get("videos").resolve(filename).normalize();
      Resource video = new UrlResource(videoPath.toUri());

      return ResponseEntity.ok()
          .header(HttpHeaders.CONTENT_TYPE, "video/mp4")
          .body(video);
    } catch (Exception e) {
      return ResponseEntity.notFound().build();
    }
  }
}
