package br.com.arthur.tutoria.repository;

import br.com.arthur.tutoria.entity.AgendaEntity;
import br.com.arthur.tutoria.entity.MaterialEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface MaterialRepository extends JpaRepository<MaterialEntity, Long> {

    @Transactional
    @Modifying
    @Query("update MaterialEntity material set" +
            " material.agenda = :agenda," +
            " material.arquivos = :arquivos" +
            " where material.id = :id")
    void atualizar(long id, AgendaEntity agenda, String arquivos);
}
