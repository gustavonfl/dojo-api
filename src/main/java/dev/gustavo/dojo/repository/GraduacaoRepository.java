package dev.gustavo.dojo.repository;

import dev.gustavo.dojo.model.Graduacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GraduacaoRepository extends JpaRepository<Graduacao, Long> {
}
