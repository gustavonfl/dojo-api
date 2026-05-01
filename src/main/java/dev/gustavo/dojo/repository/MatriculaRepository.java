package dev.gustavo.dojo.repository;

import dev.gustavo.dojo.model.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
}
