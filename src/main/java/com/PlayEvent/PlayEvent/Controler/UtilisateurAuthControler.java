package com.PlayEvent.PlayEvent.Controler;

import com.PlayEvent.PlayEvent.Model.Utilisateur;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface UtilisateurAuthControler {

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Utilisateur utilisateur);

}
