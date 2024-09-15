package com.PlayEvent.PlayEvent.Repository;

import com.PlayEvent.PlayEvent.Model.Evenement;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvenementRepository extends MongoRepository<Evenement, String> {

    Evenement findEvenementById(String evenementId);

}
