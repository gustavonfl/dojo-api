package dev.gustavo.dojo.repository;

import dev.gustavo.dojo.model.Plano;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanoRepository extends JpaRepository<Plano, Long> {
}
