package org.user.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import org.user.app.model.AppointmentSlots;

@Repository
public interface AppointmentSlotsRepository extends MongoRepository<AppointmentSlots, String>{

}
