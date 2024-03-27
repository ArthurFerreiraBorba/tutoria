package br.com.arthur.tutoria.service;

import br.com.arthur.tutoria.dto.AlunoDto;
import br.com.arthur.tutoria.entity.AlunoEntity;
import br.com.arthur.tutoria.exception.Error.NotFoundExceptionEntity;
import br.com.arthur.tutoria.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoServiceImpl implements AlunoService {

    private final AlunoRepository repository;

    public AlunoServiceImpl(AlunoRepository repository) {
        this.repository = repository;
    }

    @Override
    public AlunoDto buscarUm(Long id) {
        AlunoEntity aluno = buscarId(id);
        return toDto(aluno);
    }

    @Override
    public List<AlunoDto> buscarTodos() {
        List<AlunoEntity> alunos = repository.findAll();
        return alunos.stream()
                .map(this::toDto)
                .toList();
    }

    @Override
    public AlunoDto criar(AlunoDto alunoDto) {
        AlunoEntity aluno = new AlunoEntity(alunoDto);
        repository.save(aluno);
        return alunoDto;
    }

    @Override
    public void deletar(Long id) {
        AlunoEntity aluno = buscarId(id);
        repository.delete(aluno);
    }

    @Override
    public void atualizar(AlunoDto aluno) {
        repository.atualizar(aluno.id(), aluno.nome(), aluno.idade());
    }

    public AlunoDto toDto (AlunoEntity aluno) {
        return new AlunoDto(aluno.getId(), aluno.getNome(), aluno.getIdade());
    }

    public AlunoEntity buscarId(Long id) {
        return repository.findById(id).orElseThrow( () -> new NotFoundExceptionEntity("Aluno com id " + id + " não encontrado"));
    }
}
