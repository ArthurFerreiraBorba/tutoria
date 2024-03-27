package br.com.arthur.tutoria.repository;

import br.com.arthur.tutoria.entity.TutorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TutorRepository extends JpaRepository<TutorEntity, Long> {

    @Transactional
    @Modifying
    @Query ("update TutorEntity tutor set" +
            " tutor.nome = :nome," +
            " tutor.especialidade = :especialidade" +
            " where tutor.id = :id")
    void atualizar(long id, String nome, String especialidade);
}
