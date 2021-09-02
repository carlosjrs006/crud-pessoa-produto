package com.crud.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity//copia do banco de dados
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 150)
    private String nome;

    @Column(nullable = false, length = 11)
    private String cpf;

    @Column
    private Date dataNascimento;

    @Column
    private String endereco;




}
