package com.PlayEvent.PlayEvent.Controler;


import com.PlayEvent.PlayEvent.Model.Utilisateur;
import jdk.jshell.execution.Util;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public interface UtilisateurControler {

    @PostMapping("/user")
     ResponseEntity<?> postUser(@RequestBody Utilisateur utilisateur);

    @GetMapping("/user/{userId}")
     ResponseEntity<Utilisateur> getUser(@PathVariable("userId") String userId);

    @GetMapping("/user")
    ResponseEntity<List<Utilisateur>> getAllUser();

    @GetMapping("/user/role/{userRole}")
    ResponseEntity<?> getUserByRole(@PathVariable("userRole") String userRole);

    @GetMapping("/user/mail/{userMail}")
    ResponseEntity<?> getUserByMail(@PathVariable("userMail") String userMail);

    @PatchMapping("/user/{userId}")
     ResponseEntity<?> updatePassword(@PathVariable("userId") String userid, @RequestBody String pwd);

    @PatchMapping("/user/role/{userId}")
    ResponseEntity<?> updateRole(@PathVariable("userId") String userid, @RequestBody String role);

    @PutMapping("/user/{userId}")
    ResponseEntity<?> updateUtilisateur(@PathVariable("userId") String userid, @RequestBody Utilisateur utilisateur);

    @DeleteMapping("/user/{userId}")
    ResponseEntity<String> deleteUser(@PathVariable("userId") String userId);
}
