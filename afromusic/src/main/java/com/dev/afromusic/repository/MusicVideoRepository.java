package com.dev.afromusic.repository;

import com.dev.afromusic.models.MusicVideo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MusicVideoRepository extends JpaRepository<MusicVideo, Long> {
    @Query("SELECT a from MusicVideo a WHERE a.name LIKE CONCAT('%', :query,'%' )")
    List<MusicVideo> searchMusicVideos(String query);
}
