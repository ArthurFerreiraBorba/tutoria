package br.com.arthur.tutoria.service;

import br.com.arthur.tutoria.dto.AgendaDto;

import java.util.List;

public interface AgendaService {

    List<AgendaDto> buscarPorAluno(Long AlunoId);

    List<AgendaDto> buscarProximosAgendamentosPorAluno(long alunoId);

    List<AgendaDto> buscarPorTutor(Long TutorId);

    List<AgendaDto> buscarProximosAgendamentosPorTutor(long tutorId);

    AgendaDto buscarUm(Long id);

    List<AgendaDto> buscarTodos();

    AgendaDto criar(AgendaDto agenda);

    void deletar(Long id);

    void atualizar(AgendaDto agenda);
}
