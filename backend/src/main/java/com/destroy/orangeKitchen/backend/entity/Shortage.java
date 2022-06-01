package com.destroy.orangeKitchen.backend.entity;

import javax.persistence.*;

@Entity
@Table(name = "shortages")
public class Shortage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String item;
    private String urgency;

}
