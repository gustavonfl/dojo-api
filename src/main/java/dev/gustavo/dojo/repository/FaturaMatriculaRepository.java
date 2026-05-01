package dev.gustavo.dojo.repository;

import dev.gustavo.dojo.model.FaturaMatricula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FaturaMatriculaRepository extends JpaRepository<FaturaMatricula, Long> {
}
