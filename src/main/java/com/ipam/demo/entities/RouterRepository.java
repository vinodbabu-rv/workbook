package com.ipam.demo.entities;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RouterRepository extends Neo4jRepository<Router, Long> {

    Optional<Router> findByTitle(String title);

    @Query("MATCH (m:Router {title: $title}) RETURN m")
    Optional<Router> customFindByTitle(String title);
}