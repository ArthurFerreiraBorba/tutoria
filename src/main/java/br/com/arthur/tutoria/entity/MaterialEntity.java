package br.com.arthur.tutoria.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "materiais")
public class MaterialEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    @ManyToOne
    @JoinColumn (nullable = false, name = "agenda_id")
    private AgendaEntity agenda;
    @Column(length = 1000)
    private String arquivos;
}
