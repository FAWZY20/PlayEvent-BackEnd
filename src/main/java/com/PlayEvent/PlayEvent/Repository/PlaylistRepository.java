package com.PlayEvent.PlayEvent.Repository;

import com.PlayEvent.PlayEvent.Model.Playlist;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaylistRepository extends MongoRepository<Playlist, String> {
    Playlist findPlaylistById(String playlistId);
    Playlist findPlaylistByNom(String playlistId);
    void deleteByNom(String nom);

}
