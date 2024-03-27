package br.com.arthur.tutoria.repository;

import br.com.arthur.tutoria.entity.AlunoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AlunoRepository extends JpaRepository<AlunoEntity, Long> {

    @Transactional
    @Modifying
    @Query ("update AlunoEntity aluno set" +
            " aluno.nome = :nome," +
            " aluno.idade = :idade" +
            " where aluno.id = :id")
    void atualizar(long id, String nome, int idade);
}
