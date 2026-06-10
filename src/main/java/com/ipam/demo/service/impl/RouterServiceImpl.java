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

@Service
@RequiredArgsConstructor
public class RouterServiceImpl implements RouterService {

    @Autowired
    private final RouterRepository routerRepository;

    @Autowired
    private final KafkaTemplate<String, com.demo.avro.Router> kafkaTemplate;

    @Override
    public Router create(Router r) {
        Router persistedRouter = routerRepository.save(r);
        com.demo.avro.Router rAvro = new com.demo.avro.Router(persistedRouter.getId(), persistedRouter.getTitle(), persistedRouter.getSerial());
        kafkaTemplate.send(
                "router-topic",
                rAvro
        );
        return persistedRouter;
    }

    @Override
    public Router get(String title) {
        return routerRepository.findByTitle(title).orElseThrow(() -> new ResourceNotFoundException(title));
    }

    @Override
    public List<Router> getAll() {
        return routerRepository.findAll();
    }
}
