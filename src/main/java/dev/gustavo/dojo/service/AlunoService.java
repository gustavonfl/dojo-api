package dev.gustavo.dojo.service;

import dev.gustavo.dojo.dto.AlunoRequest;
import dev.gustavo.dojo.dto.AlunoResponse;
import dev.gustavo.dojo.model.Aluno;
import dev.gustavo.dojo.repository.AlunoRepository;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {
     private final AlunoRepository alunoRepository;

     public AlunoService(AlunoRepository alunoRepository){
         this.alunoRepository = alunoRepository;
     }

     public AlunoResponse cadastrar(AlunoRequest request){
         if (request.email() != null && alunoRepository.existsByEmail(request.email())){
            throw new RuntimeException("Email já cadastrado");
         }

         Aluno aluno = request.toEntity();
         Aluno alunoSalvo = alunoRepository.save(aluno);
         return AlunoResponse.fromEntity(alunoSalvo);
     }
}
