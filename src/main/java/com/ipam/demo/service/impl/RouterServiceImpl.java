package com.ipam.demo.service.impl;

import com.ipam.demo.entities.Router;
import com.ipam.demo.entities.RouterRepository;
import com.ipam.demo.exceptions.ResourceNotFoundException;
import com.ipam.demo.service.RouterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RouterServiceImpl implements RouterService {

    @Autowired
    RouterRepository routerRepository;

    @Override
    public Router create(Router r) {
        r.setId(UUID.randomUUID());
        return routerRepository.save(r);
    }

    @Override
    public Router get(UUID id) {
        return routerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Override
    public List<Router> getAll() {
        return routerRepository.findAll();
    }
}
