package com.dev.afromusic.repository;

import com.dev.afromusic.models.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist,Long> {
}
