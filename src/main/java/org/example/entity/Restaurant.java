package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@Entity
@Accessors(chain = true)
@Table(name = "restaurant")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String city;
    private String name;
    private Integer price;
    private String rating;
    private Integer votes;

}
