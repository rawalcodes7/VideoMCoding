package com.video.demo.repository;

import com.video.demo.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VideoRepository extends JpaRepository<Video,Long> {
    List<Video> findByTagsIn(List<String> tags);
}
