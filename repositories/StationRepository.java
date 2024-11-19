package com.example.mongo_project.repositories;

import com.example.mongo_project.model.Station;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StationRepository extends MongoRepository<Station, String> {
}
