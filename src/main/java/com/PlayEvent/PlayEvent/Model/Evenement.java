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

    private LocalTime heureDebut;

    private LocalTime  heureFin;

    private String lieu;

    private String description;

    private Playlist playlist;

    private List<String> inviteeEmail;

    private String animateurID;

    private Statut status;

    public enum Statut{
        EN_ATTENTE ,EN_COUR, FINI
    }

    public Evenement(String id, String nom,
                     LocalDate date,
                     LocalTime heureDebut,
                     LocalTime heureFin,
                     String lieu,
                     String description,
                     Playlist playlist,
                     List<String> inviteeEmail,
                     String animateurID,
                     Statut status) {
        this.id = id;
        this.nom = nom;
        this.date = date;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.lieu = lieu;
        this.description = description;
        this.playlist = playlist;
        this.inviteeEmail = inviteeEmail;
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

    public LocalTime getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(LocalTime heureDebut) {
        this.heureDebut = heureDebut;
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

    public List<String> getInviteeEmail() {
        return inviteeEmail;
    }

    public void setInviteeEmail(List<String> inviteeEmail) {
        this.inviteeEmail = inviteeEmail;
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
    public Statut getStatus() {
        return status;
    }

    public void setStatus(Statut status) {
        this.status = status;
    }

}
