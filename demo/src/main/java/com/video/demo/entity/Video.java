package com.video.demo.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @JsonAlias("modified_time")
    private String modifiedTime;
    @JsonAlias("published_time")
    private String publishedTime;
    @JsonAlias("thumbnail_id")
    private String thumbnailId;
    @ElementCollection
    private List<String> tags;

}
