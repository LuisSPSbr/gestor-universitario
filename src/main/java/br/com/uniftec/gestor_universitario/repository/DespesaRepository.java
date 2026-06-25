package br.com.uniftec.gestor_universitario.repository;

import br.com.uniftec.gestor_universitario.model.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DespesaRepository extends JpaRepository<Despesa, Long> {
    long countByAlunoId(Long alunoId);
}