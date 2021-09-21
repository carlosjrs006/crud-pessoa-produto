package com.crud.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity// copia do banco de dados
@Data //anotacoes para poder buascar as informacoes aqui dentro.
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Pessoa {
    @Id // falando para o banco de dados que vai ser o id.
    @GeneratedValue(strategy = GenerationType.IDENTITY)// vai ser gerado automaticamente o id.
    private int id;

    //column indica que vai ser uma coluna no banco de dados.
    @Column(nullable = false, length = 150)
    private String nome;

    @Column(nullable = false, length = 11)
    private String cpf;

    @Column
    private Date dataNascimento;

    @Column
    private String endereco;


}
