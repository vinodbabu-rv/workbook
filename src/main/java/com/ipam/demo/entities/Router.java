package com.ipam.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.apache.avro.specific.SpecificRecordBase;

import java.util.UUID;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Router")
public class Router {

    @Id
    private UUID id;

    private String name;

    private String serial;

}
