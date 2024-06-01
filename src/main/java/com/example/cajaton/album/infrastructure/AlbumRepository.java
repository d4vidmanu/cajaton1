package com.example.cajaton.album.infrastructure;

import com.example.cajaton.album.domain.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Integer> {
}
