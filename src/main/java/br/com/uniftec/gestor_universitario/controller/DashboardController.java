package br.com.uniftec.gestor_universitario.controller;

import br.com.uniftec.gestor_universitario.model.Despesa;
import br.com.uniftec.gestor_universitario.service.DespesaService;
import br.com.uniftec.gestor_universitario.repository.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/dashboard")
@CrossOrigin(origins = "*")
public class DashboardController {

    private final DespesaService despesaService;
    private final UsuarioRepository usuarioRepository;

    public DashboardController(DespesaService despesaService, UsuarioRepository usuarioRepository) {
        this.despesaService = despesaService;
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("/resumo")
    public ResponseEntity<Map<String, Object>> obterResumoFinanceiro() {
        List<Despesa> todasDespesas = despesaService.listarTodas();
        
        long totalUsuarios = usuarioRepository.count();
        
        double receitaPaga = todasDespesas.stream()
                .filter(d -> "PAGO".equalsIgnoreCase(d.getStatus()))
                .mapToDouble(d -> d.getValor().doubleValue())
                .sum();
                
        double receitaPendente = todasDespesas.stream()
                .filter(d -> "PENDENTE".equalsIgnoreCase(d.getStatus()))
                .mapToDouble(d -> d.getValor().doubleValue())
                .sum();

        Map<String, Object> relatorio = new HashMap<>();
        relatorio.put("totalAlunosAtivos", totalUsuarios);
        relatorio.put("receitaJaArrecadada", receitaPaga);
        relatorio.put("receitaPendente", receitaPendente);
        relatorio.put("totalDeMensalidadesRegistradas", todasDespesas.size()); 

        return ResponseEntity.ok(relatorio);
    }
}