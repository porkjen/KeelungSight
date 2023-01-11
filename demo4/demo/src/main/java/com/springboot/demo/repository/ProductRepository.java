package com.springboot.demo.repository;

import com.springboot.demo.entity.Sight;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Sight, String> {

    List<Sight> findByZone(String zone);
}
