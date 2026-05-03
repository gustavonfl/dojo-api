package dev.gustavo.dojo.dto;

import dev.gustavo.dojo.model.Aluno;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record AlunoRequest(
        @NotBlank(message = "O nome é oprbigatorio")
        @Size(max = 150)
        String nome,

        @Past(message = "A data de nasciemnto deve estar no passado")
        LocalDate dataNascimento,

        @Size(max = 1, message = "O sexo deve ter no maximo 1 caractere")
        String sexo,

        @Size(max = 30, message = "O telefone deve ter no maximo 30 caracteres")
        String telefone,

        @Size(max = 30, message = "O celular deve ter no maximo 30 caracteres")
        String celular,

        @Email(message = "Email invalido")
        @Size(message = "Email deve ter no maximo 150 caracteres", max = 150)
        String email,

        String observacao,

        @Size(max = 150, message = "O endereco deve ter no maximo 150 caracteres")
        String endereco,

        @Size(max = 20, message = "O numero deve ter no maximo 20 caracteres")
        String numero,

        @Size(max = 100, message = "O complemento deve ter no maximo 100 caracteres")
        String complemento,

        @Size(max = 100, message = "O bairro deve ter no maximo 100 caracteres")
        String bairro,

        @Size(max = 100, message = "O cidade deve ter no maximo 100 caracteres")
        String cidade,

        @Size(max = 2, message = "O estado deve ter no maximo 2 caracteres")
        String estado,

        @Size(max = 20, message = "O cep deve ter no maximo 100 caracteres")
        String cep
) {

    public Aluno toEntity(){
        Aluno aluno = new Aluno();
        preencher(aluno);
        return aluno;
    }

    public void preencher(Aluno aluno){
        aluno.setNome(nome);
        aluno.setDataNascimento(dataNascimento);
        aluno.setSexo(sexo);
        aluno.setTelefone(telefone);
        aluno.setCelular(celular);
        aluno.setEmail(email);
        aluno.setObservacao(observacao);
        aluno.setEndereco(endereco);
        aluno.setNumero(numero);
        aluno.setComplemento(complemento);
        aluno.setBairro(bairro);
        aluno.setCidade(cidade);
        aluno.setEstado(estado);
        aluno.setCep(cep);
    }
}
