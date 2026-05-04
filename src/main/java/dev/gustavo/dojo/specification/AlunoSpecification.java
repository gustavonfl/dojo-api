package dev.gustavo.dojo.specification;

import dev.gustavo.dojo.dto.AlunoFiltroRequest;
import dev.gustavo.dojo.model.Aluno;
import org.springframework.data.jpa.domain.Specification;

public class AlunoSpecification {
    public static Specification<Aluno> comFiltros(AlunoFiltroRequest filtro){
        return Specification
                .where(nomeContem(filtro.nome()))
                .and(emailContem(filtro.email()))
                .and(celularContem(filtro.celular()))
                .and(cidadeContem(filtro.cidade()))
                .and(estadoIgual(filtro.estado()));
    }

    private static Specification<Aluno> nomeContem(String nome) {
        return (root, query, cb) -> {
            if (nome == null || nome.isBlank()) {
                return null;
            }

            return cb.like(cb.lower(root.get("name")), "%" + nome.toLowerCase() + "%");
        };
    }

    private static Specification<Aluno> emailContem(String email) {
        return (root, query, cb) -> {
            if (email == null || email.isBlank()) {
                return null;
            }

            return cb.like(cb.lower(root.get("name")), "%" + email.toLowerCase() + "%");
        };
    }

    private static Specification<Aluno> celularContem(String celular) {
        return (root, query, cb) -> {
            if (celular == null || celular.isBlank()) {
                return null;
            }

            return cb.like(cb.lower(root.get("name")), "%" + celular.toLowerCase() + "%");
        };
    }

    private static Specification<Aluno> cidadeContem(String cidade) {
        return (root, query, cb) -> {
            if (cidade == null || cidade.isBlank()) {
                return null;
            }

            return cb.like(cb.lower(root.get("name")), "%" + cidade.toLowerCase() + "%");
        };
    }

    private static Specification<Aluno> estadoIgual(String estado) {
        return (root, query, cb) -> {
            if (estado == null || estado.isBlank()) {
                return null;
            }

            return cb.equal(cb.upper(root.get("name")), estado.toUpperCase());
        };
    }
}
