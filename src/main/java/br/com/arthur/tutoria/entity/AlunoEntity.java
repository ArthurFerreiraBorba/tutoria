package br.com.arthur.tutoria.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "alunos")
public class AlunoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    @Column(nullable = false, length = 150)
    private String nome;
    private int idade;
}
