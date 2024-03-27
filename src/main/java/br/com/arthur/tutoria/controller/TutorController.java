package br.com.arthur.tutoria.controller;

import br.com.arthur.tutoria.dto.TutorDto;
import br.com.arthur.tutoria.service.TutorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/tutores")
public class TutorController {

    private final TutorService service;

    public TutorController(TutorService service) {
        this.service = service;
    }

    @GetMapping ("{id}")
    public ResponseEntity<TutorDto> buscarId(@PathVariable Long id) {
        return ResponseEntity.status(200).body(service.buscarUm(id));
    }

    @GetMapping
    public ResponseEntity<List<TutorDto>> buscarTodos() {
        return ResponseEntity.status(200).body(service.buscarTodos());
    }

    @PostMapping
    public ResponseEntity<TutorDto> criar(@RequestBody TutorDto tutor) {
        return ResponseEntity.status(201).body(service.criar(tutor));
    }

    @DeleteMapping ("{id}")
    public ResponseEntity<Object> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.status(204).build();
    }

    @PutMapping
    public ResponseEntity<Object> atualizar(@RequestBody TutorDto tutor) {
        service.atualizar(tutor);
        return ResponseEntity.status(204).build();
    }
}
