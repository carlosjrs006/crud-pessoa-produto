package com.crud.model.entity;

import javax.persistence.*;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column
    private Double valor;

    @Column
    private String lugar;

    @Column(nullable = false, length = 150)
    private String nome;
}
