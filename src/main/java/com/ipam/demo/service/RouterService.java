package com.ipam.demo.service;

import com.ipam.demo.entities.Router;

import java.util.List;
import java.util.UUID;

public interface RouterService {

    public Router create(Router r);

    public Router get(UUID id);

    public List<Router> getAll();
}
