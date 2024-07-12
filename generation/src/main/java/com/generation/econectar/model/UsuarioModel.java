package com.generation.econectar.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "tb_usuarios")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O atributo nome do usuário é obrigatório!")
    @Size(max = 255, message = "O atributo nome do usuário deve conter no mínimo 05 e no máximo 255 caracteres!")
    private String nomeusuario;

    @NotBlank(message = "O atributo email é obrigatório!")
    @Size(min = 5, max = 255, message = "O atributo email deve conter no mínimo 05 e no máximo 255 caracteres!")
    private String email;

    @NotBlank(message = "O atributo cpf é obrigatório!")
    @Size(max = 15, message = "O atributo cpf deve conter no máximo 15 caracteres")
    private String cpf;

    @NotBlank(message = "O atributo data de nascimento é obrigatório!")
    private LocalDate datanascimento;

    @Size(max = 1000, message = "O atributo endereço deve conter no máximo 1000 caracteres")
    private String endereco;

    @NotBlank
    @Size(min = 7, max = 32, message = "O atributo senha deve ter no mínimo 7 e no máximo 255 caracteres")
    private String senha;

    @Size(max = 1000, message = "O atributo foto deve ter no máximo 1000 caracteres.")
    private String foto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeusuario() {
        return nomeusuario;
    }

    public void setNomeusuario(String nomeusuario) {
        this.nomeusuario = nomeusuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(LocalDate datanascimento) {
        this.datanascimento = datanascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}