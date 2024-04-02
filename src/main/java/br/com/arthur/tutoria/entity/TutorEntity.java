package br.com.arthur.tutoria.entity;

import br.com.arthur.tutoria.dto.TutorDto;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tutores")
public class TutorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, length = 150)
    private String nome;
    @Column(nullable = false, length = 150)
    private String especialidade;

    public TutorEntity() {};

    public TutorEntity(long id) {
        this.id = id;
    };


    public TutorEntity(TutorDto tutorDto) {
        this.nome = tutorDto.nome();
        this.especialidade = tutorDto.especialidade();
    };
}
