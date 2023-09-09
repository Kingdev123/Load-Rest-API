package com.loadapi.load.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loadapi.load.entity.Load;
import com.loadapi.load.repository.LoadRepository;

@Service
public class LoadServiceimpl implements LoadService{
     
    @Autowired
    private LoadRepository loadRepository;

    @Override
    public Load createLoad(Load load) {
        return loadRepository.save(load);
    }

    @Override
    public List<Load> getLoadList() {
        return loadRepository.findAll();
    }
    
    @Override
    public Load getLoadById(Long shipperId) {
        Load load = loadRepository.findById(shipperId).orElse(null);
        return load;
    }

    @Override
    public Load updateLoad(Long loadId, Load updatedLoad) {
        Load existingLoad = loadRepository.findById(loadId).orElse(null);
        if (existingLoad == null) {
            return null; 
        }

        existingLoad.setLoadingPoint(updatedLoad.getLoadingPoint());

        existingLoad.setUnloadingPoint(updatedLoad.getUnloadingPoint());

        existingLoad.setProductType(updatedLoad.getProductType());

        existingLoad.setTruckType(updatedLoad.getTruckType());

        existingLoad.setNoOfTrucks(updatedLoad.getNoOfTrucks());

        existingLoad.setWeight(updatedLoad.getWeight());

        existingLoad.setComment(updatedLoad.getComment());

        existingLoad.setDate(updatedLoad.getDate());

      
        Load newLoad = loadRepository.save(existingLoad);
        return newLoad;
    }

    @Override
    public void deleteLoad(Long shipperId) {
        loadRepository.deleteById(shipperId);
    }




}
