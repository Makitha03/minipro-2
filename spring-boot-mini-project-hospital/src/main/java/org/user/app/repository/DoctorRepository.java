package org.user.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.user.app.model.Doctor;
@Repository
public interface DoctorRepository extends MongoRepository<Doctor, String>{

}
