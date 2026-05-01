package dev.gustavo.dojo.repository;

import dev.gustavo.dojo.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
