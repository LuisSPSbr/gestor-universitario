package br.com.uniftec.gestor_universitario.service;

import br.com.uniftec.gestor_universitario.model.Despesa;
import br.com.uniftec.gestor_universitario.repository.DespesaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DespesaService {

    private final DespesaRepository repository;
    private static final int LIMITE_FREEMIUM = 5;

    public DespesaService(DespesaRepository repository) {
        this.repository = repository;
    }

    public List<Despesa> listarTodas() {
        return repository.findAll();
    }

    public Optional<Despesa> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Despesa salvar(Despesa despesa) {
        // Regra do Freemium aplicada às Despesas
        if (despesa.getId() == null) { 
            long totalCadastradas = repository.countByAlunoId(despesa.getAlunoId());
            if (totalCadastradas >= LIMITE_FREEMIUM) {
                throw new RuntimeException("Limite do plano Básico atingido! Faça upgrade.");
            }
        }
        return repository.save(despesa);
    }

    public Despesa atualizar(Long id, Despesa despesaAtualizada) {
        Despesa despesa = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Despesa não encontrada"));

        despesa.setAlunoId(despesaAtualizada.getAlunoId());
        despesa.setCategoria(despesaAtualizada.getCategoria());
        despesa.setValor(despesaAtualizada.getValor());
        despesa.setDataVencimento(despesaAtualizada.getDataVencimento());
        despesa.setStatus(despesaAtualizada.getStatus());

        return repository.save(despesa);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}