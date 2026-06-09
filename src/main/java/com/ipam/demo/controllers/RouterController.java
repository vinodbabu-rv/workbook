package com.ipam.demo.controllers;

import com.ipam.demo.entities.Router;
import com.ipam.demo.service.RouterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/router")
public class RouterController {

    @Autowired
    private RouterService routerService;

    @PostMapping
    public ResponseEntity<Router> create(@RequestBody Router r) {
        return ResponseEntity.status(HttpStatus.CREATED).body(routerService
                .create(r));
    }

    @GetMapping
    public ResponseEntity<Router> getRouter(@RequestParam("id") String title) {
        return ResponseEntity.status(HttpStatus.OK).body(routerService
                .get(title));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Router>> getRouters() {
        return ResponseEntity.ok(routerService
                .getAll());
    }
}
