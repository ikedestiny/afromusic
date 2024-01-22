package com.dev.afromusic.service;

import com.dev.afromusic.models.Artist;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ArtistService {
    List<Artist> findAllArtists();

    void saveArtist(Artist artist);

    Artist findArtistById(Long artistId);

    void updateArtistProfile(Artist artist);

    void deleteArtist(Long artistId);

    List<Artist> searchForArtist(String query);
}
