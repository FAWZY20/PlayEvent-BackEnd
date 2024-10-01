package com.PlayEvent.PlayEvent.Service;

import com.PlayEvent.PlayEvent.Controler.PlaylistControler;
import com.PlayEvent.PlayEvent.Model.Playlist;
import com.PlayEvent.PlayEvent.Repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistService implements PlaylistControler {

   private final PlaylistRepository playlistRepository;

   @Autowired
    public PlaylistService(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    @Override
    public ResponseEntity<?> addPlaylist(Playlist playlist) {
        try {
            playlistRepository.save(playlist);
            return new ResponseEntity<>(playlist, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("playlist n'a reussi a etre ajouter", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> updatePlaylist(String playlistId, Playlist playlist) {
       try {
           Playlist playlist1 = playlistRepository.findPlaylistById(playlistId);

           playlist1.setNom(playlist.getNom());
           playlist1.setDescription(playlist.getDescription());
           playlist1.setMusique(playlist.getMusique());

           playlistRepository.save(playlist1);
           return new ResponseEntity<>(HttpStatus.OK);
       }catch (Exception e){
           e.printStackTrace();
           return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
       }
   }

    @Override
    public ResponseEntity<?> getAllPlaylist() {
        List<Playlist> playlists = playlistRepository.findAll();
        return new ResponseEntity<>(playlists, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getPlaylist(String playlistId) {
       try{
           Playlist playlist = playlistRepository.findPlaylistById(playlistId);
           return new ResponseEntity<>(playlist, HttpStatus.OK);
       }catch (Exception e){
           e.printStackTrace();
           return new ResponseEntity<>("playlist n'ai pas trouver", HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }


    @Override
    public ResponseEntity<?> getPlaylistByName(String playlistNom) {
        try{
            Playlist playlist = playlistRepository.findPlaylistByNom(playlistNom);
            return new ResponseEntity<>(playlist, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("playlist n'ai pas trouver", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @Override
    public ResponseEntity<?> deletePlaylist(String playlistNom) {
        try {
            playlistRepository.deleteByNom(playlistNom);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
