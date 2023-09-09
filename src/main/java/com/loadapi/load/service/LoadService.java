package com.loadapi.load.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.loadapi.load.entity.Load;

@Service
public interface LoadService {

    public Load createLoad(Load load);

    public List<Load> getLoadList();

    public Load getLoadById(Long shipperId);

    public Load updateLoad(Long shipperId, Load updatedLoad); 

    public void deleteLoad(Long shipperId);
}
