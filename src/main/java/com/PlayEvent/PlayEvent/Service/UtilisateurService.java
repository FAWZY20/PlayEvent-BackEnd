package com.PlayEvent.PlayEvent.Service;

import com.PlayEvent.PlayEvent.Controler.UtilisateurControler;
import com.PlayEvent.PlayEvent.Model.Utilisateur;
import com.PlayEvent.PlayEvent.Repository.UtilisateurRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UtilisateurService implements UtilisateurControler {

    private final UtilisateurRepository utilisateurRepository;

    @Autowired
    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public ResponseEntity<String> postUser(Utilisateur utilisateur) {
        utilisateurRepository.save(utilisateur);
        return new ResponseEntity<>("l'utilisateur a bien etait ajouter", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Utilisateur> getUser(String userId) {
        ObjectId objectId = new ObjectId(userId);
        Utilisateur utilisateur = utilisateurRepository.findUtilisateurById(objectId);
        return new ResponseEntity<>(utilisateur, HttpStatus.OK);
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
    public ResponseEntity<String> deleteUser(String userId) {
        try{
            ObjectId objectId = new ObjectId(userId);
            utilisateurRepository.deleteById(objectId);
            return new ResponseEntity<>("l'utilisateur à etait supprimer", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("l'utilisateur n'existe pas" , HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
