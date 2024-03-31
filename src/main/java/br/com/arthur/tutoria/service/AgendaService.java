package br.com.arthur.tutoria.service;

import br.com.arthur.tutoria.dto.AgendaDto;

import java.util.List;

public interface AgendaService {

    AgendaDto buscarUm(Long id);

    List<AgendaDto> buscarTodos();

    AgendaDto criar(AgendaDto aluno);

    void deletar(Long id);

    void atualizar(AgendaDto aluno);
}
