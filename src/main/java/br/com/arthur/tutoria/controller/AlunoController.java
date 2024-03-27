package br.com.arthur.tutoria.controller;

import br.com.arthur.tutoria.dto.AlunoDto;
import br.com.arthur.tutoria.service.AlunoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/alunos")
public class AlunoController {

    private final AlunoService service;

    public AlunoController(AlunoService service) {
        this.service = service;
    }

    @GetMapping ("{id}")
    public ResponseEntity<AlunoDto> buscarId(@PathVariable Long id) {
        return ResponseEntity.status(200).body(service.buscarUm(id));
    }

    @GetMapping
    public ResponseEntity<List<AlunoDto>> buscarTodos() {
        return ResponseEntity.status(200).body(service.buscarTodos());
    }

    @PostMapping
    public ResponseEntity<AlunoDto> criar(@RequestBody AlunoDto aluno) {
        return ResponseEntity.status(201).body(service.criar(aluno));
    }

    @DeleteMapping ("{id}")
    public ResponseEntity<Object> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.status(204).build();
    }

    @PutMapping
    public ResponseEntity<Object> atualizar(@RequestBody AlunoDto aluno) {
        service.atualizar(aluno);
        return ResponseEntity.status(204).build();
    }
}
