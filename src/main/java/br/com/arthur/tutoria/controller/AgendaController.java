package br.com.arthur.tutoria.controller;

import br.com.arthur.tutoria.dto.AgendaDto;
import br.com.arthur.tutoria.service.AgendaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/agendas")
public class AgendaController {

    private final AgendaService service;

    public AgendaController(AgendaService service) {
        this.service = service;
    }

    @GetMapping ("{id}")
    public ResponseEntity<AgendaDto> buscarId(@PathVariable Long id) {
        return ResponseEntity.status(200).body(service.buscarUm(id));
    }

    @GetMapping
    public ResponseEntity<List<AgendaDto>> buscarTodos() {
        return ResponseEntity.status(200).body(service.buscarTodos());
    }

    @PostMapping
    public ResponseEntity<AgendaDto> criar(@RequestBody AgendaDto agenda) {
        return ResponseEntity.status(201).body(service.criar(agenda));
    }

    @DeleteMapping ("{id}")
    public ResponseEntity<Object> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.status(204).build();
    }

    @PutMapping
    public ResponseEntity<Object> atualizar(@RequestBody AgendaDto agenda) {
        service.atualizar(agenda);
        return ResponseEntity.status(204).build();
    }
}
