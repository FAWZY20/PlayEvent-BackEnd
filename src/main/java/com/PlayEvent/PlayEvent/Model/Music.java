package com.PlayEvent.PlayEvent.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

public class Music {

    private String titre;

    private String artiste;

    private String album;

    private String duree;

    private String genre;

    public Music(String titre, String artiste, String album, String duree, String genre, String fichier) {
        this.titre = titre;
        this.artiste = artiste;
        this.album = album;
        this.duree = duree;
        this.genre = genre;
    }

    public Music(){

    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getArtiste() {
        return artiste;
    }

    public void setArtiste(String artiste) {
        this.artiste = artiste;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

}
