package com.dev.afromusic.service.impl;

import com.dev.afromusic.models.Artist;
import com.dev.afromusic.repository.ArtistRepository;
import com.dev.afromusic.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistServiceImpl implements ArtistService {
    private ArtistRepository artistRepository;

    @Autowired
    public ArtistServiceImpl(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    public List<Artist> findAllArtists() {
        return artistRepository.findAll();
    }

    @Override
    public void saveArtist(Artist artist) {
        artistRepository.save(artist);
    }

    @Override
    public Artist findArtistById(Long artistId) {
        return artistRepository.findById(artistId).get();
    }

    @Override
    public void updateArtistProfile(Artist artist) {
        artistRepository.save(artist);
    }

    @Override
    public void deleteArtist(Long artistId) {
        artistRepository.deleteById(artistId);
    }

    @Override
    public List<Artist> searchForArtist(String query) {
        return artistRepository.searchArtists(query);
    }
}
