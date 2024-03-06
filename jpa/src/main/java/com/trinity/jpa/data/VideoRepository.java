package com.trinity.jpa.data;
import org.springframework.data.jpa.repository.JpaRepository;
import com.trinity.jpa.models.Video;

public interface VideoRepository extends JpaRepository<Video, Integer>{

}
