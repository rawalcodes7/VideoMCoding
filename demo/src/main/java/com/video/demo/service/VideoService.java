package com.video.demo.service;

import com.video.demo.entity.Video;
import com.video.demo.repository.VideoRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoService {
    private final VideoRepository videoRepository;
    public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }
    public Video save(Video video) {
        return videoRepository.save(video);
    }
//
//    public List<Video> getVideosByTags(Long id, List<String> tags, int page, int size) {
//       System.out.println("Inside getVideosByTags");
//       Map<Video,Long> videoLongMap = new HashMap<>();
//       for(String tag : tags) {
//           List<Video> similarVideos = videoRepository.findVideosByTags(tag);
//           for(Video video : similarVideos) {
//               videoLongMap.put(video, videoLongMap.getOrDefault(video, 0L) + 1);
//           }
//       }
//       System.out.println(videoLongMap);
//       return videoLongMap.entrySet().stream().sorted((
//               a,b)->b.getValue().compareTo(a.getValue()))
//               .map(Map.Entry::getKey)
//               .skip((long)page*size)
//               .limit(size)
//               .collect(Collectors.toUnmodifiableList());
//    }
    @Cacheable(value = "videoSuggestions", key = "#tags")
    public List<Video> getSuggestions(List<String> tags) {
        return videoRepository.findByTagsIn(tags);
    }
}
