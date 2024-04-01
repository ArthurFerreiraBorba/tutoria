package br.com.arthur.tutoria.service;

import br.com.arthur.tutoria.dto.MaterialDto;

import java.util.List;

public interface MaterialService {

    MaterialDto buscarUm(Long id);

    List<MaterialDto> buscarTodos();

    MaterialDto criar(MaterialDto Material);

    void deletar(Long id);

    void atualizar(MaterialDto Material);
}
