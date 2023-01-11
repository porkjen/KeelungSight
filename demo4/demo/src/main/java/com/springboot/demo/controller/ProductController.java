package com.springboot.demo.controller;


import com.springboot.demo.ProductService;
import com.springboot.demo.entity.Sight;
import com.springboot.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController //this is a controller
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)//set return data to be JSON
public class ProductController {
    private List<Sight> sights = new ArrayList<>();
    @Autowired
    private ProductRepository repository;
    @Autowired
    private ProductService service;

    /*@PostConstruct//execute when controller start
    private void initDB(){
        KeelungSightsCrawler crawler = new KeelungSightsCrawler();
        sights = crawler.getItems();
        for(Sight s: sights) {
            this.service.createSight(s);
        }
    }*/

    @GetMapping("/sights")//configure a GET API
    public List<Sight> getSight() {
        return service.getAllSight();
    }

    @GetMapping("/sights/{zone}")
    public ResponseEntity<List<Sight>> getProduct(@PathVariable("zone") String zone) {
        return ResponseEntity.ok(service.getSightsbyZone(zone));
    }


    @PostMapping("/sights")
    public ResponseEntity < Sight > createProduct(@RequestBody Sight sight) {
        return ResponseEntity.ok().body(this.service.createSight(sight));
    }
}
