package com.PlayEvent.PlayEvent.Controler;


import com.PlayEvent.PlayEvent.Model.Utilisateur;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public interface UtilisateurControler {

    @PostMapping("/user")
     ResponseEntity<String> postUser(@RequestBody Utilisateur utilisateur);

    @GetMapping("/user/{userId}")
     ResponseEntity<Utilisateur> getUser(@PathVariable("userId") String userId);

    @GetMapping("/user/role/{userRole}")
    ResponseEntity<?> getUserByRole(@PathVariable("userRole") String userRole);

    @PatchMapping("/user/{userId}")
     ResponseEntity<String> updatePassword(@PathVariable("userId") String userid, @RequestBody String pwd);

    @DeleteMapping("/user/{userId}")
     ResponseEntity<String> deleteUser(@PathVariable("userId") String userId);
}
