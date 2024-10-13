package com.PlayEvent.PlayEvent.Service;

import com.PlayEvent.PlayEvent.Controler.UtilisateurControler;
import com.PlayEvent.PlayEvent.Model.Utilisateur;
import com.PlayEvent.PlayEvent.Repository.UtilisateurRepository;
import jdk.jshell.execution.Util;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UtilisateurService implements UtilisateurControler {

    private final UtilisateurRepository utilisateurRepository;

    @Autowired
    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public ResponseEntity<?> postUser(Utilisateur utilisateur) {
        utilisateurRepository.save(utilisateur);
        return new ResponseEntity<>(utilisateur, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Utilisateur> getUser(String userId) {
        ObjectId objectId = new ObjectId(userId);
        Utilisateur utilisateur = utilisateurRepository.findUtilisateurById(objectId);
        return new ResponseEntity<>(utilisateur, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Utilisateur>> getAllUser() {
     List<Utilisateur> utilisateurs = utilisateurRepository.findAll();
     return  new ResponseEntity<>(utilisateurs, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getUserByRole(String userRole) {
        try{
            List<Utilisateur> utilisateur =  utilisateurRepository.findUtilisateurByRole(userRole);
            return new ResponseEntity<>(utilisateur, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("il y'a un eu un probleme durant la recherche des animateur", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> getUserByMail(String userMail) {
        try{
            Utilisateur utilisateur =  utilisateurRepository.findUtilisateurByMail(userMail);
            return new ResponseEntity<>(utilisateur, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("il y'a un eu un probleme durant la recherche des utilisateur", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<String> updatePassword( String userid, String pwd) {
        ObjectId objectId = new ObjectId(userid);

        Utilisateur utilisateur = utilisateurRepository.findUtilisateurById(objectId);
        utilisateur.setPwd(pwd);
        utilisateurRepository.save(utilisateur);
        return new ResponseEntity<>("l'utilisateur a etait mise a jour", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> updateRole(String userid, String role) {
        ObjectId objectId = new ObjectId(userid);
        Utilisateur utilisateur = utilisateurRepository.findUtilisateurById(objectId);
        utilisateur.setRole(Utilisateur.Role.valueOf(role));
        utilisateurRepository.save(utilisateur);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> updateUtilisateur(String userid, Utilisateur utilisateur) {
        ObjectId objectId = new ObjectId(userid);
        Utilisateur uti = utilisateurRepository.findUtilisateurById(objectId);

        uti.setMail(utilisateur.getMail());
        uti.setPrenom(utilisateur.getPrenom());
        uti.setNom(utilisateur.getNom());
        uti.setPwd(utilisateur.getPwd());
        uti.setRole(utilisateur.getRole());

        utilisateurRepository.save(utilisateur);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteUser(String userId) {
        try{
            ObjectId objectId = new ObjectId(userId);
            utilisateurRepository.deleteById(objectId);
            return new ResponseEntity<>( HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
