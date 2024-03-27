package br.com.arthur.tutoria.service;

import br.com.arthur.tutoria.dto.AlunoDto;

import java.util.List;

public interface AlunoService {

    AlunoDto buscarUm(Long id);

    List<AlunoDto> buscarTodos();

    AlunoDto criar(AlunoDto aluno);

    void deletar(Long id);

    void atualizar(AlunoDto aluno);
}
