package com.springboot.demo;

import com.springboot.demo.entity.Sight;
import com.springboot.demo.repository.ProductRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public List<Sight> getAllSight(){
        return repository.findAll();
    }
    public List<Sight> getSightsbyZone(String zone){
        return repository.findByZone(zone);
    }

    public Sight createSight(Sight request) {
        Sight sight = new Sight();
        sight.setSightName(request.getSightName());
        sight.setZone(request.getZone());
        sight.setAddress(request.getAddress());
        sight.setCategory(request.getCategory());
        sight.setPhotoURL(request.getPhotoURL());
        sight.setDescription(request.getDescription());
        return repository.insert(sight);
    }
}
