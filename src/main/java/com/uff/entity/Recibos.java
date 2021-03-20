package com.uff.entity;

import lombok.NonNull;

import javax.persistence.*;

@Entity
public class Recibos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @NonNull
    private String name;

    @ManyToOne
    private Locatario locatario;

}
