package br.com.uniftec.gestor_universitario.dto;

import jakarta.validation.constraints.NotBlank;

public class LoginDTO {

    @NotBlank(message = "O e-mail é obrigatório para realizar o login")
    private String email;

    @NotBlank(message = "A senha é obrigatória para realizar o login")
    private String senha;

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
}