package com.PlayEvent.PlayEvent.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Document(collection ="evenement")
public class Evenement {

    @Id
    private final String id;

    private String nom;

    private LocalDate date;

    private LocalTime heureDébut;

    private LocalTime  heureFin;

    private String lieu;

    private String description;

    private Playlist playlist;

    private List<String> utilisateurID;

    private String animateurID;

    private String status;

    public Evenement(String id, String nom,
                     LocalDate date,
                     LocalTime heureDébut,
                     LocalTime heureFin,
                     String lieu,
                     String description,
                     Playlist musique,
                     List<String> utilisateurID,
                     String animateurID,
                     String status) {
        this.id = id;
        this.nom = nom;
        this.date = date;
        this.heureDébut = heureDébut;
        this.heureFin = heureFin;
        this.lieu = lieu;
        this.description = description;
        this.playlist = musique;
        this.utilisateurID = utilisateurID;
        this.animateurID = animateurID;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getHeureDébut() {
        return heureDébut;
    }

    public void setHeureDébut(LocalTime heureDébut) {
        this.heureDébut = heureDébut;
    }

    public LocalTime getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(LocalTime heureFin) {
        this.heureFin = heureFin;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getUtilisateurID() {
        return utilisateurID;
    }

    public void setUtilisateurID(List<String> utilisateurID) {
        this.utilisateurID = utilisateurID;
    }

    public String getAnimateurID() {
        return animateurID;
    }

    public void setAnimateurID(String animateurID) {
        this.animateurID = animateurID;
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
