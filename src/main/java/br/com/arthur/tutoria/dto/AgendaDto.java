package br.com.arthur.tutoria.dto;

import br.com.arthur.tutoria.entity.AlunoEntity;
import br.com.arthur.tutoria.entity.TutorEntity;

import java.time.LocalDate;

public record AgendaDto(long id, AlunoEntity aluno, TutorEntity tutor, LocalDate data, String status, String tema, String descricao) {
}
