package com.dev.afromusic.service.impl;

import com.dev.afromusic.models.Artist;
import com.dev.afromusic.models.MusicVideo;
import com.dev.afromusic.repository.ArtistRepository;
import com.dev.afromusic.repository.MusicVideoRepository;
import com.dev.afromusic.service.MusicVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicVideoServiceImpl implements MusicVideoService {
    private  MusicVideoRepository musicVideoRepository;
    private ArtistRepository artistRepository;

    @Autowired
    public MusicVideoServiceImpl(MusicVideoRepository musicVideoRepository, ArtistRepository artistRepository) {
        this.musicVideoRepository = musicVideoRepository;
        this.artistRepository = artistRepository;
    }




    @Override
    public List<MusicVideo> findAllMusicVideos() {
        return musicVideoRepository.findAll();
    }

    @Override
    public void createVideo(Long artistId, MusicVideo musicVideo) {
        Artist artist = artistRepository.findById(artistId).get();
        musicVideo.setArtist(artist);
        musicVideoRepository.save(musicVideo);
    }

    @Override
    public void deleteVideo(Long videoId) {
        musicVideoRepository.deleteById(videoId);
    }

    @Override
    public List<MusicVideo> searchMusicVideos(String query) {
        return musicVideoRepository.searchMusicVideos(query);
    }
}


