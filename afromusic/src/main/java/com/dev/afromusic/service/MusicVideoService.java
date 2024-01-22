package com.dev.afromusic.service;

import com.dev.afromusic.models.MusicVideo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MusicVideoService {
    List<MusicVideo> findAllMusicVideos();

    void createVideo(Long artistId, MusicVideo musicVideo);

    void deleteVideo(Long videoId);

    List<MusicVideo> searchMusicVideos(String query);
}
