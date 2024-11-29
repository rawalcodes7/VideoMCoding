package com.video.demo.Controller;

import com.video.demo.entity.Video;
import com.video.demo.service.VideoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController(value = "/")

public class Controller {
    private final VideoService videoService;

    public Controller(VideoService videoService) {
        this.videoService = videoService;
    }

    @PostMapping("/video")
    public ResponseEntity<String> addVideo(@RequestBody Video video) {
        System.out.printf(video.toString());
        videoService.save(video);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/videos")
    public List<Video> getVideosWithSuggestions(@RequestParam List<String> tags,
                                                @RequestParam(defaultValue = "0") int page,
                                                @RequestParam(defaultValue = "10") int size) {
        return videoService.getSuggestions(tags);
    }
}
