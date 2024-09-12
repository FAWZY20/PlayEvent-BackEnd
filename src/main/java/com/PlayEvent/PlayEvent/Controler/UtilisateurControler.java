package com.PlayEvent.PlayEvent.Controler;


import com.PlayEvent.PlayEvent.Model.Utilisateur;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public interface UtilisateurControler {

    @PostMapping("/postUser")
     ResponseEntity<String> postUser(@RequestBody Utilisateur utilisateur);

    @GetMapping("/getUser/{userId}")
     ResponseEntity<Utilisateur> getUser(@PathVariable("userId") String userId);

    @PatchMapping("/updateUser/{userId}")
     ResponseEntity<String> updatePassword(@PathVariable("userId") String userId,
                                           @RequestParam("pwd") String pwd);

    @DeleteMapping("/deleteUser/{userId}")
     ResponseEntity<String> deleteUser(@PathVariable("userId") String userId);
}
