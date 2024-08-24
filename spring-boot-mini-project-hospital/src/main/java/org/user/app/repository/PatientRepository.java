package org.user.app.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import org.user.app.model.Patient;

@Repository
public interface PatientRepository extends MongoRepository<Patient, String> {
	


    
}
