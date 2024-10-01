package com.PlayEvent.PlayEvent.Controler;

import com.PlayEvent.PlayEvent.Model.Playlist;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public interface PlaylistControler {

    @GetMapping("/playlist")
    ResponseEntity<?> getAllPlaylist();

    @GetMapping("/playlist/{playlistId}")
    ResponseEntity<?> getPlaylist(@PathVariable("playlistId") String playlistId);

    @GetMapping("/playlist/nom/{playlistNom}")
    ResponseEntity<?> getPlaylistByName(@PathVariable("playlistNom") String playlistNom);


    @PostMapping("/playlist")
    ResponseEntity<?> addPlaylist(@RequestBody Playlist playlist);

    @PutMapping("/playlist/{playlistId}")
    ResponseEntity<?> updatePlaylist(@PathVariable("playlistId") String playlistId,@RequestBody Playlist playlist);

    @DeleteMapping("/playlist/{playlistNom}")
    ResponseEntity<?> deletePlaylist(@PathVariable("playlistNom") String playlistNom);

}
