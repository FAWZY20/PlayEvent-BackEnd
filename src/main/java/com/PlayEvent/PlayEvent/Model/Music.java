package com.PlayEvent.PlayEvent.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

public class Music {

    private String titre;

    private String artiste;

    private String album;

    private String cover;

    private String duree;

    public Music(String titre, String artiste, String album, String cover, String duree) {
        this.titre = titre;
        this.artiste = artiste;
        this.album = album;
        this.cover = cover;
        this.duree = duree;
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

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

}
