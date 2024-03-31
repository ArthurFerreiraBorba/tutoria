package br.com.arthur.tutoria.entity;

import br.com.arthur.tutoria.dto.AgendaDto;
import br.com.arthur.tutoria.dto.AlunoDto;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "agendas")
public class AgendaEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    @ManyToOne
    @JoinColumn(nullable = false, name = "aluno_id")
    private AlunoEntity aluno;
    @ManyToOne
    @JoinColumn(nullable = false, name = "tutor_id")
    private TutorEntity tutor;
    @OneToMany (mappedBy = "agenda")
    private List<MaterialEntity> materiais;
    private LocalDate data;
    @Column(length = 50)
    private String status;
    @Column(nullable = false, length = 100)
    private String tema;
    @Column(length = 300)
    private String descricao;

    public AgendaEntity() {};

    public AgendaEntity(AgendaDto agendaDto) {
        this.aluno = agendaDto.aluno();
        this.tutor = agendaDto.tutor();
        this.data = agendaDto.data();
        this.status = agendaDto.status();
        this.tema = agendaDto.tema();
        this.descricao = agendaDto.descricao();
    };
}
