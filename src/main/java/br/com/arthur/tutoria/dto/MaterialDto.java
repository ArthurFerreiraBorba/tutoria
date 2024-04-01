package br.com.arthur.tutoria.dto;

import br.com.arthur.tutoria.entity.AgendaEntity;
import br.com.arthur.tutoria.entity.AlunoEntity;
import br.com.arthur.tutoria.entity.TutorEntity;

import java.time.LocalDate;

public record MaterialDto(long id, long agenda, String arquivos) {
}
