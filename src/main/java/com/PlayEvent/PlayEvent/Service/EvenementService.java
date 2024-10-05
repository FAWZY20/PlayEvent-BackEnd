package com.PlayEvent.PlayEvent.Service;

import com.PlayEvent.PlayEvent.Controler.EvenementControler;
import com.PlayEvent.PlayEvent.Model.Evenement;
import com.PlayEvent.PlayEvent.Repository.EvenementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EvenementService implements EvenementControler {

    private final EvenementRepository evenementRepository;

    @Autowired
    public EvenementService(EvenementRepository evenementRepository) {
        this.evenementRepository = evenementRepository;
    }

    @Override
    public ResponseEntity<?> addEvent(Evenement evenement) {
        try {
            evenementRepository.save(evenement);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<Evenement>> getAllEvent() {
        List<Evenement> evenements =  evenementRepository.findAll();
        return new ResponseEntity<>(evenements, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Evenement> getEvent(String eventId) {
        Evenement evenement = evenementRepository.findEvenementById(eventId);
        return new ResponseEntity<>(evenement, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> updateEvent(Evenement evenement) {
        Evenement evt = evenementRepository.findEvenementById(evenement.getId());

        evt.setNom(evenement.getNom());
        evt.setDate(evenement.getDate());
        evt.setHeureDebut(evenement.getHeureDebut());
        evt.setHeureFin(evenement.getHeureFin());
        evt.setLieu(evenement.getLieu());
        evt.setPlaylist(evenement.getPlaylist());
        evt.setAnimateurID(evenement.getAnimateurID());
        evt.setDescription(evenement.getDescription());
        evt.setInviteeEmail(evenement.getInviteeEmail());

        evenementRepository.save(evt);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> deleteEvent(String eventId) {
        try {
            evenementRepository.deleteById(eventId);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
