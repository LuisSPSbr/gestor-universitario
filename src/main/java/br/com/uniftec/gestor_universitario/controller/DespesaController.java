package br.com.uniftec.gestor_universitario.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import br.com.uniftec.gestor_universitario.model.Despesa;
import br.com.uniftec.gestor_universitario.dto.DespesaDTO;
import br.com.uniftec.gestor_universitario.service.DespesaService;

import java.util.List;

@RestController
@RequestMapping("/despesas")
@CrossOrigin(origins = "*")
public class DespesaController {

    private final DespesaService service;

    public DespesaController(DespesaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Despesa>> listarTodas() {
        return ResponseEntity.ok(service.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Despesa> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Despesa> salvar(@Valid @RequestBody DespesaDTO dto) {
        Despesa despesa = new Despesa();
        copiarDtoParaEntidade(dto, despesa);
        return ResponseEntity.ok(service.salvar(despesa));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Despesa> atualizar(@PathVariable Long id, @Valid @RequestBody DespesaDTO dto) {
        Despesa despesa = new Despesa();
        copiarDtoParaEntidade(dto, despesa);
        return ResponseEntity.ok(service.atualizar(id, despesa));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    private void copiarDtoParaEntidade(DespesaDTO dto, Despesa d) {
        d.setAlunoId(dto.getAlunoId());
        d.setCategoria(dto.getCategoria());
        d.setValor(dto.getValor());
        d.setDataVencimento(dto.getDataVencimento());
        d.setStatus(dto.getStatus());
    }
}