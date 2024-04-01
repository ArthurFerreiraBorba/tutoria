package br.com.arthur.tutoria.controller;

import br.com.arthur.tutoria.dto.MaterialDto;
import br.com.arthur.tutoria.service.MaterialService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/material")
public class MaterialController {

    private final MaterialService service;

    public MaterialController(MaterialService service) {
        this.service = service;
    }

    @GetMapping ("{id}")
    public ResponseEntity<MaterialDto> buscarId(@PathVariable Long id) {
        return ResponseEntity.status(200).body(service.buscarUm(id));
    }

    @GetMapping
    public ResponseEntity<List<MaterialDto>> buscarTodos() {
        return ResponseEntity.status(200).body(service.buscarTodos());
    }

    @PostMapping
    public ResponseEntity<MaterialDto> criar(@RequestBody MaterialDto aluno) {
        return ResponseEntity.status(201).body(service.criar(aluno));
    }

    @DeleteMapping ("{id}")
    public ResponseEntity<Object> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.status(204).build();
    }

    @PutMapping
    public ResponseEntity<Object> atualizar(@RequestBody MaterialDto aluno) {
        service.atualizar(aluno);
        return ResponseEntity.status(204).build();
    }
}
