package br.com.arthur.tutoria.service;

import br.com.arthur.tutoria.dto.AgendaDto;
import br.com.arthur.tutoria.entity.AgendaEntity;
import br.com.arthur.tutoria.exception.Error.NotFoundExceptionEntity;
import br.com.arthur.tutoria.repository.AgendaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaServiceImpl implements AgendaService {

    private final AgendaRepository repository;
    private final TutorService tutorService;
    private final AlunoService alunoService;

    public AgendaServiceImpl(AgendaRepository repository, TutorService tutorService, AlunoService alunoService) {
        this.repository = repository;
        this.tutorService = tutorService;
        this.alunoService = alunoService;
    }

    @Override
    public AgendaDto buscarUm(Long id) {
        AgendaEntity agenda = buscarId(id);
        return toDto(agenda);
    }

    @Override
    public List<AgendaDto> buscarTodos() {
        List<AgendaEntity> agendas = repository.findAll();
        return agendas.stream()
                .map(this::toDto)
                .toList();
    }

    @Override
    public AgendaDto criar(AgendaDto agendaDto) {
        AgendaEntity agenda = new AgendaEntity(agendaDto);
        repository.save(agenda);
        return agendaDto;
    }

    @Override
    public void deletar(Long id) {
        AgendaEntity agenda = buscarId(id);
        repository.delete(agenda);
    }

    @Override
    public void atualizar(AgendaDto agenda) {
        repository.atualizar(agenda.id(), agenda.aluno(), agenda.tutor(), agenda.data(), agenda.status(), agenda.tema(), agenda.descricao());
    }

    public AgendaDto toDto (AgendaEntity agenda) {
        return new AgendaDto(agenda.getId(), agenda.getAluno(), agenda.getTutor(), agenda.getData(), agenda.getStatus(), agenda.getTema(), agenda.getDescricao());
    }

    public AgendaEntity buscarId(Long id) {
        return repository.findById(id).orElseThrow( () -> new NotFoundExceptionEntity("Agenda com id " + id + " não encontrado"));
    }
}
