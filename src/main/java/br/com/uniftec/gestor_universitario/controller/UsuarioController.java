package br.com.uniftec.gestor_universitario.controller;

import br.com.uniftec.gestor_universitario.model.Usuario;
import br.com.uniftec.gestor_universitario.repository.UsuarioRepository;
import br.com.uniftec.gestor_universitario.dto.LoginDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    private final UsuarioRepository repository;

    public UsuarioController(UsuarioRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Usuario> cadastrar(@Valid @RequestBody Usuario usuario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(usuario));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody LoginDTO loginDto) {
        Optional<Usuario> usuarioLogado = repository.findByEmailAndSenha(loginDto.getEmail(), loginDto.getSenha());
        
        if (usuarioLogado.isPresent()) {
            return ResponseEntity.ok("Login realizado com sucesso! Bem-vindo(a), " + usuarioLogado.get().getNome());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Acesso negado: E-mail ou senha inválidos.");
        }
    }
}