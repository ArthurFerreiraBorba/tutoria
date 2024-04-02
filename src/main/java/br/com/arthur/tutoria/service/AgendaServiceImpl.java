package br.com.arthur.tutoria.service;

import br.com.arthur.tutoria.dto.AgendaDto;
import br.com.arthur.tutoria.entity.AgendaEntity;
import br.com.arthur.tutoria.entity.AlunoEntity;
import br.com.arthur.tutoria.entity.TutorEntity;
import br.com.arthur.tutoria.exception.Error.NotFoundExceptionEntity;
import br.com.arthur.tutoria.repository.AgendaRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class AgendaServiceImpl implements AgendaService {

    private final AgendaRepository repository;

    public AgendaServiceImpl(AgendaRepository repository, TutorService tutorService, AlunoService alunoService) {
        this.repository = repository;
    }

    @Override
    public List<AgendaDto> buscarPorAluno(Long alunoId) {
        List<AgendaEntity> agendas = repository.buscarAgendaPorAluno(new AlunoEntity(alunoId));
        agendas = agendas.stream().sorted(Comparator.comparing(AgendaEntity::getData)).toList();
        return toListDto(agendas);
    }

    @Override
    public List<AgendaDto> buscarPorTutor(Long tutorId) {
        List<AgendaEntity> agendas = repository.buscarAgendaPorTutor(new TutorEntity(tutorId));
        agendas = agendas.stream().sorted(Comparator.comparing(AgendaEntity::getData)).toList();
        return toListDto(agendas);
    }

    @Override
    public AgendaDto buscarUm(Long id) {
        AgendaEntity agenda = buscarId(id);
        return toDto(agenda);
    }

    @Override
    public List<AgendaDto> buscarTodos() {
        List<AgendaEntity> agendas = repository.findAll();
        return toListDto(agendas);
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

    public List<AgendaDto> toListDto (List<AgendaEntity> agendas) {
        return agendas.stream()
                .map(this::toDto)
                .toList();
    }

    public AgendaEntity buscarId(Long id) {
        return repository.findById(id).orElseThrow( () -> new NotFoundExceptionEntity("Agenda com id " + id + " não encontrado"));
    }
}
