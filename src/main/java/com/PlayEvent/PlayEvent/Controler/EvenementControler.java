package com.PlayEvent.PlayEvent.Controler;

import com.PlayEvent.PlayEvent.Model.Evenement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public interface EvenementControler {

    @PostMapping("/evenement")
    ResponseEntity<?> addEvent(@RequestBody Evenement evenement);

    @GetMapping("/evenement")
    ResponseEntity<List<Evenement>> getAllEvent();

    @GetMapping("/evenement/{eventId}")
    ResponseEntity<Evenement> getEvent(@PathVariable("eventId") String eventId);

    @PatchMapping("/evenement")
    ResponseEntity<String> updateDateEvent(@RequestBody Evenement evenement);

    @DeleteMapping("/evenement/{eventId}")
    ResponseEntity<String> deleteEvent(@PathVariable("eventId") String eventId);

}
