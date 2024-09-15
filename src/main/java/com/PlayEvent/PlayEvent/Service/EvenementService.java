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
    public ResponseEntity<String> addEvent(Evenement evenement) {
        try {
            evenementRepository.save(evenement);
            return new ResponseEntity<>("evenement ajoutee", HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("evenement n'a pas pu etre ajoutee", HttpStatus.INTERNAL_SERVER_ERROR);
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
    public ResponseEntity<String> updateDateEvent(Evenement evenement) {
        Evenement evt = evenementRepository.findEvenementById(evenement.getId());
        evt.setDate(evenement.getDate());
        evenementRepository.save(evt);
        return null;
    }

    @Override
    public ResponseEntity<String> deleteEvent(String eventId) {
        evenementRepository.deleteById(eventId);
        return new ResponseEntity<>("l'evenement a bien etait supprimee", HttpStatus.OK);
    }

}
