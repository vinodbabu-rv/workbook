package com.ipam.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node("ports")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Ports {

    @Id @GeneratedValue
    private String id;

    private String number;
}
