package br.com.arthur.tutoria.service;

import br.com.arthur.tutoria.dto.TutorDto;

import java.util.List;

public interface TutorService {

    TutorDto buscarUm(Long id);

    List<TutorDto> buscarTodos();

    TutorDto criar(TutorDto aluno);

    void deletar(Long id);

    void atualizar(TutorDto tutor);
}
