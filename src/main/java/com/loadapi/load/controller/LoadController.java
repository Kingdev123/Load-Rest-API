package com.loadapi.load.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.loadapi.load.entity.Load;
import com.loadapi.load.service.LoadService;

@RestController
public class LoadController {

    @Autowired
    private LoadService loadService;

    // Creating Load method
    @PostMapping("/load")
    public ResponseEntity<Map<String, Object>> createLoad(@RequestBody Load load) {
        Load createdLoad = loadService.createLoad(load);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Load details added successfully");
        response.put("load", createdLoad);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // getting all load lists
    @GetMapping("/loads")
    public ResponseEntity<List<Load>> getLoadList() {
        List<Load> loadList = loadService.getLoadList();
        return ResponseEntity.status(HttpStatus.OK).body(loadList);
    }
    

    //  getting load by id
    @GetMapping("/load/{loadId}")
    public ResponseEntity<Load> getLoadById(@PathVariable("loadId") Long shipperId) {
        Load load = loadService.getLoadById(shipperId);
        return ResponseEntity.ok(load);
    }

    // updating load
    @PutMapping("/load/{loadId}")
    public ResponseEntity<Load> updateLoad(@PathVariable("loadId") Long shipperId, @RequestBody Load Load) {
        Load updatedload = loadService.updateLoad(shipperId, Load);
            return ResponseEntity.ok(updatedload);
    }

    // deleting Load
    @DeleteMapping("/load/{loadId}")
    public void deleteLoad(@PathVariable("loadId") Long shipperId) {
        loadService.deleteLoad(shipperId);
    }
}

