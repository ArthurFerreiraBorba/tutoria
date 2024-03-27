package br.com.arthur.tutoria.entity;

import br.com.arthur.tutoria.dto.AlunoDto;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "alunos")
public class AlunoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    @Column(nullable = false, length = 150)
    private String nome;
    private int idade;

    public AlunoEntity() {};

    public AlunoEntity(AlunoDto alunoDto) {
        this.nome = alunoDto.nome();
        this.idade = alunoDto.idade();
    };
}
