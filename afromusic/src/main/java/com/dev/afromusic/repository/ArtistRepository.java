package com.dev.afromusic.repository;

import com.dev.afromusic.models.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArtistRepository extends JpaRepository<Artist,Long> {

    @Query("SELECT a from Artist a WHERE a.name LIKE CONCAT('%', :query,'%' )")
    List<Artist> searchArtists(String query);

}
