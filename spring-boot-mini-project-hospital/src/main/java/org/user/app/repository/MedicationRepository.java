package org.user.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.user.app.model.Medication;

@Repository
public interface MedicationRepository extends MongoRepository <Medication, String>{

}
