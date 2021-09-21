package com.crud.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity// copia do banco de dados
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
