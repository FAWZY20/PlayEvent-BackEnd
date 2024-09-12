package com.PlayEvent.PlayEvent.Repository;

import com.PlayEvent.PlayEvent.Model.Utilisateur;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UtilisateurRepository extends MongoRepository<Utilisateur, UUID> {

    void deleteById(ObjectId objectId);

    Utilisateur findUtilisateurById(ObjectId objectId);
}
