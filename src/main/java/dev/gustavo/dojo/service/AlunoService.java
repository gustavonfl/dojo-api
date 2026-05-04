package dev.gustavo.dojo.service;

import dev.gustavo.dojo.dto.AlunoFiltroRequest;
import dev.gustavo.dojo.dto.AlunoRequest;
import dev.gustavo.dojo.dto.AlunoResponse;
import dev.gustavo.dojo.exceptions.RegraNegocioException;
import dev.gustavo.dojo.model.Aluno;
import dev.gustavo.dojo.repository.AlunoRepository;
import dev.gustavo.dojo.specification.AlunoSpecification;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class AlunoService {
     private final AlunoRepository alunoRepository;

     public AlunoService(AlunoRepository alunoRepository){
         this.alunoRepository = alunoRepository;
     }

     public AlunoResponse cadastrar(AlunoRequest request){
         if (request.email() != null && alunoRepository.existsByEmail(request.email())){
            throw new RegraNegocioException("Email já cadastrado");
         }

         Aluno aluno = request.toEntity();
         Aluno alunoSalvo = alunoRepository.save(aluno);
         return AlunoResponse.fromEntity(alunoSalvo);
     }

     public Page<AlunoResponse> listar(AlunoFiltroRequest filtro, Pageable pageable){
            return alunoRepository.findAll(AlunoSpecification.comFiltros(filtro), pageable).map(AlunoResponse::fromEntity);
     }

     public AlunoResponse buscarPorId(Long id){
        Aluno aluno = buscarEntidadePorid(id);
        return AlunoResponse.fromEntity(aluno);
     }

     public AlunoResponse atualizar(Long id, AlunoRequest request){
         Aluno aluno = buscarEntidadePorid(id);
         request.preencher(aluno);
         Aluno alunoAtualizado = alunoRepository.save(aluno);
         return AlunoResponse.fromEntity(alunoAtualizado);
     }

     public void excluir(Long id){
         Aluno aluno = buscarEntidadePorid(id);
         alunoRepository.delete(aluno);
     }

     private Aluno buscarEntidadePorid(Long id){
         return alunoRepository.findById(id).orElseThrow(() -> new RegraNegocioException("Aluno não encontrado"));
     }
}
