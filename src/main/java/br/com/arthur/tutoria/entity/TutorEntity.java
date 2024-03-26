package br.com.arthur.tutoria.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tutores")
public class TutorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 150)
    private String especialidade;

}
