package com.PlayEvent.PlayEvent.Repository;

import com.PlayEvent.PlayEvent.Model.Utilisateur;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UtilisateurRepository extends MongoRepository<Utilisateur, String> {

    void deleteById(ObjectId objectId);

    Utilisateur findUtilisateurById(ObjectId objectId);

    @Aggregation(pipeline = {"{ '$match': { 'mail': ?0, 'pwd': ?1 } }", "{ '$project': { 'mail': 1, 'nom': 1, 'prenom': 1, '_id': 0, } }" })
    Utilisateur getByMailAndPassword(String mail, String password);
}
