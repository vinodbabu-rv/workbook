package com.ipam.demo.service.impl;

import com.ipam.demo.entities.Router;
import com.ipam.demo.entities.RouterRepository;
import com.ipam.demo.exceptions.ResourceNotFoundException;
import com.ipam.demo.service.RouterService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RouterServiceImpl implements RouterService {

    @Autowired
    RouterRepository routerRepository;

    @Autowired
    private final KafkaTemplate<String, com.demo.avro.Router> kafkaTemplate;

    @Override
    public Router create(Router r) {
        r.setId(UUID.randomUUID());
        Router persistedRouter = routerRepository.save(r);
        com.demo.avro.Router rAvro = new com.demo.avro.Router(persistedRouter.getId().toString(), persistedRouter.getName(), persistedRouter.getSerial());
        kafkaTemplate.send(
                "router-topic",
                rAvro
        );
        return persistedRouter;
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
