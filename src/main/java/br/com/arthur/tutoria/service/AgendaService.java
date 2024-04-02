package br.com.arthur.tutoria.service;

import br.com.arthur.tutoria.dto.AgendaDto;

import java.util.List;

public interface AgendaService {

    List<AgendaDto> buscarPorAluno(Long AlunoId);

    List<AgendaDto> buscarPorTutor(Long AlunoId);

    AgendaDto buscarUm(Long id);

    List<AgendaDto> buscarTodos();

    AgendaDto criar(AgendaDto agenda);

    void deletar(Long id);

    void atualizar(AgendaDto agenda);
}
