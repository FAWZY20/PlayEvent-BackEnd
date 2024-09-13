package com.PlayEvent.PlayEvent.Service;

import com.PlayEvent.PlayEvent.Controler.AuthenticationControler;
import com.PlayEvent.PlayEvent.Model.Utilisateur;
import com.PlayEvent.PlayEvent.Repository.UtilisateurRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class AuthenticationService implements AuthenticationControler {

    private static final long EXPIRATION_TIME = 864_000_000;
    private static final String SECRET_KEY;
    private final UtilisateurRepository utilisateurRepository;

    @Autowired
    public AuthenticationService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    static {
        byte[] secretKeyBytes = new byte[64];
        new SecureRandom().nextBytes(secretKeyBytes);
        SECRET_KEY = Base64.getEncoder().encodeToString(secretKeyBytes);
    }

    @Override
    public ResponseEntity<?> login(Utilisateur utilisateur) {
        Utilisateur uti = utilisateurRepository.getByMailAndPassword(utilisateur.getMail(), utilisateur.getPwd());
        try{
            String token = generateToken(utilisateur.getMail());
            Map<String, Object> response = new HashMap<>();
            response.put("token", token);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("l'utilisateur n'ai pas trouver", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public String generateToken(String mail) {
        return Jwts.builder()
                .setSubject(mail)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }
}
