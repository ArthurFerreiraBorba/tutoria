package br.com.arthur.tutoria.entity;

import br.com.arthur.tutoria.dto.AlunoDto;
import br.com.arthur.tutoria.dto.MaterialDto;
import jakarta.persistence.*;
import lombok.Data;

@Data
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

    public MaterialEntity() {};

    public MaterialEntity(MaterialDto materialDto, AgendaEntity agenda) {
        this.agenda = agenda;
        this.arquivos = materialDto.arquivos();
    };
}
