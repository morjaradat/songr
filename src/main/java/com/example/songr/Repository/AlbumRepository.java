package com.example.songr.Repository;

import com.example.songr.Models.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album,Long> {
 Album findAlbumById(Long id);
}
