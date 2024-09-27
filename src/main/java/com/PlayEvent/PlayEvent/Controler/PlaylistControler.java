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

    @PostMapping("/playlist")
    ResponseEntity<?> addPlaylist(@RequestBody Playlist playlist);

    @DeleteMapping("/playlist/{playlistId}")
    ResponseEntity<?> deletePlaylist(@PathVariable("playlistId") String playlistId);

}
