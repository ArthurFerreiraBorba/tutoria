package br.com.arthur.tutoria.repository;

import br.com.arthur.tutoria.entity.AgendaEntity;
import br.com.arthur.tutoria.entity.AlunoEntity;
import br.com.arthur.tutoria.entity.TutorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AgendaRepository extends JpaRepository<AgendaEntity, Long> {

    @Transactional
    @Modifying
    @Query("update AgendaEntity agenda set" +
            " agenda.aluno = :aluno," +
            " agenda.tutor = :tutor," +
            " agenda.data = :data," +
            " agenda.status = :status," +
            " agenda.tema = :tema," +
            " agenda.descricao = :descricao" +
            " where agenda.id = :id")
    void atualizar(long id, AlunoEntity aluno, TutorEntity tutor, LocalDate data, String status, String tema, String descricao);

    @Query("Select agenda" +
            " from AgendaEntity agenda" +
            " where agenda.aluno = :alunoId")
    List<AgendaEntity> buscarAgendaPorAluno(AlunoEntity alunoId);

    @Query("Select agenda" +
            " from AgendaEntity agenda" +
            " where agenda.aluno = :alunoId and agenda.data >= CURRENT_DATE()")
    List<AgendaEntity> buscarProximosAgendamentosPorAluno(AlunoEntity alunoId);

    @Query("Select agenda" +
            " from AgendaEntity agenda" +
            " where agenda.tutor = :tutorId")
    List<AgendaEntity> buscarAgendaPorTutor(TutorEntity tutorId);

    @Query("Select agenda" +
            " from AgendaEntity agenda" +
            " where agenda.tutor = :tutorId and agenda.data >= CURRENT_DATE()")
    List<AgendaEntity> buscarProximosAgendamentosPorTutor(TutorEntity tutorId);
}
