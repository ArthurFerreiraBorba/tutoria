package br.com.arthur.tutoria.service;

import br.com.arthur.tutoria.dto.TutorDto;
import br.com.arthur.tutoria.entity.TutorEntity;
import br.com.arthur.tutoria.exception.Error.NotFoundExceptionEntity;
import br.com.arthur.tutoria.repository.TutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorServiceImpl implements TutorService {

    private final TutorRepository repository;

    public TutorServiceImpl(TutorRepository repository) {
        this.repository = repository;
    }

    @Override
    public TutorDto buscarUm(Long id) {
        TutorEntity tutor = buscarId(id);
        return toDto(tutor);
    }

    @Override
    public List<TutorDto> buscarTodos() {
        List<TutorEntity> tutores = repository.findAll();
        return tutores.stream()
                .map(this::toDto)
                .toList();
    }

    @Override
    public TutorDto criar(TutorDto tutorDto) {
        TutorEntity tutor = new TutorEntity(tutorDto);
        repository.save(tutor);
        return tutorDto;
    }

    @Override
    public void deletar(Long id) {
        TutorEntity tutor = buscarId(id);
        repository.delete(tutor);
    }

    @Override
    public void atualizar(TutorDto tutor) {
        repository.atualizar(tutor.id(), tutor.nome(), tutor.especialidade());
    }

    public TutorDto toDto (TutorEntity tutor) {
        return new TutorDto(tutor.getId(), tutor.getNome(), tutor.getEspecialidade());
    }

    public TutorEntity buscarId(Long id) {
        return repository.findById(id).orElseThrow( () -> new NotFoundExceptionEntity("Tutor com id " + id + " não encontrado"));
    }
}
