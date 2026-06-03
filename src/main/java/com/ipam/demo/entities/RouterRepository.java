package com.ipam.demo.entities;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RouterRepository extends JpaRepository<Router, UUID> {
}
