package dev.gustavo.dojo.repository;

import dev.gustavo.dojo.model.Assiduidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssiduidadeRepository extends JpaRepository<Assiduidade, Long> {
}
