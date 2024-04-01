package br.com.arthur.tutoria.service;

import br.com.arthur.tutoria.dto.MaterialDto;
import br.com.arthur.tutoria.entity.AgendaEntity;
import br.com.arthur.tutoria.entity.MaterialEntity;
import br.com.arthur.tutoria.exception.Error.NotFoundExceptionEntity;
import br.com.arthur.tutoria.repository.MaterialRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService {

    private final MaterialRepository repository;
    private final AgendaServiceImpl agendaService;

    public MaterialServiceImpl(MaterialRepository repository, AgendaServiceImpl agendaService1) {
        this.repository = repository;
        this.agendaService = agendaService1;
    }

    @Override
    public MaterialDto buscarUm(Long id) {
        MaterialEntity material = buscarId(id);
        return toDto(material);
    }

    @Override
    public List<MaterialDto> buscarTodos() {
        List<MaterialEntity> materiais = repository.findAll();
        return materiais.stream()
                .map(this::toDto)
                .toList();
    }

    @Override
    public MaterialDto criar(MaterialDto materialDto) {
        AgendaEntity agenda = agendaService.buscarId(materialDto.agenda());
        MaterialEntity material = new MaterialEntity(materialDto, agenda);
        repository.save(material);
        return materialDto;
    }

    @Override
    public void deletar(Long id) {
        MaterialEntity material = buscarId(id);
        repository.delete(material);
    }

    @Override
    public void atualizar(MaterialDto material) {
        AgendaEntity agenda = agendaService.buscarId(material.agenda());
        repository.atualizar(material.id(), agenda, material.arquivos());
    }

    public MaterialDto toDto (MaterialEntity material) {
        return new MaterialDto(material.getId(), material.getAgenda().getId(), material.getArquivos());
    }

    public MaterialEntity buscarId(Long id) {
        return repository.findById(id).orElseThrow( () -> new NotFoundExceptionEntity("Material com id " + id + " não encontrado"));
    }
}
