package com.ipam.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.HashSet;


@Node("Router")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Router {

    @Id @GeneratedValue
    private Long id;

    private String title;

    private String serial;

    @Relationship(type = "having", direction = Relationship.Direction.INCOMING)
    private HashSet<Ports> ports = new HashSet<>();

}
