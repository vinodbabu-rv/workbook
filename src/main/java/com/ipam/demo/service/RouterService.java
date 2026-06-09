package com.ipam.demo.service;

import com.ipam.demo.entities.Router;

import java.util.List;
import java.util.UUID;

public interface RouterService {

    public Router create(Router r);

    public Router get(String title);

    public List<Router> getAll();
}
