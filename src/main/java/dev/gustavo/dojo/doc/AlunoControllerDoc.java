package dev.gustavo.dojo.doc;

import dev.gustavo.dojo.dto.AlunoRequest;
import dev.gustavo.dojo.dto.AlunoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(
        name = "Alunos",
        description = "Endpoints para gerenciamento de alunos, incluindo cadastro, listagem, busca por ID, atualização e exclusão."
)

public interface AlunoControllerDoc {

    @Operation(
            summary = "Cadastrar aluno",
            description = "Endpoint para cadastrar um novo aluno. Recebe os dados do aluno no corpo da requisição e retorna os detalhes do aluno cadastrado.",
            responses = {
                    @ApiResponse(
                       responseCode = "201", description = "Aluno cadastrado com sucesso"
                    ),
                    @ApiResponse(
                        responseCode = "400", description = "Erro de validação",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class))
                    )
    }
    )

    AlunoResponse cadastrar(
            @RequestBody
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Dados necessarios para cadastrar um aluno",
                    required = true,
                    content = @Content(schema = @Schema(implementation = AlunoRequest.class),
                    examples = @ExampleObject(
                            name = "Aluno valido",
                            value = """
                                    {
                                        "nome": "Lucas",
                                        "dataNascimento": "1999-01-20",
                                        "sexo": "M",
                                        "telefone": "990876541",
                                        "celular": "990876541",
                                        "email": "lucas@gmail.com",
                                        "observacao": "Aluno iniciante",
                                        "endereco": "Rua das Flores",
                                        "numero": "123",
                                        "complemento": "Apartamento 202",
                                        "bairro": "Centro",
                                        "cidade": "Criciuma",
                                        "estado": "SC",
                                        "cep": "4534333"
                                    }
                                    """
                    ))
            )
            AlunoRequest alunoRequest);
}