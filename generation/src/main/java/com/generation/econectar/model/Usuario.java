package com.generation.econectar.model;

import java.time.LocalDate;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O nome do usuário é obrigatório!")
	@Size(min = 1, max = 255, message = "O nome do usuário deve conter no mínimo 1 e no máximo 255 caracteres")
	private String nomeUsuario;
	
	@NotNull(message = "O email é obrigatório!")
	@Email(message = "O atributo email é obrigatório")
	private String email;
	
	@NotBlank(message = "A senha é obrigatória!")
	@Size(min = 7, max = 64, message = "A senha deve conter no mínimo 7 e no máximo 64 caracteres")
	private String senha;
	
	@NotBlank(message = "O endereço é obrigatório!")
	@Size(min = 1, max = 255, message = "O endereço deve conter no mínimo 1 e no máximo 255 caracteres")
	private String endereco;
	
	@NotBlank(message = "O CPF é obrigatório!")
	@Size(min = 11, max = 11, message = "O CPF deve conter 11 caracteres")
	private String cpf;
	
	@NotBlank(message = "a data de nascimento é obrigatório!")
	@Size(min = 10, max = 10, message = "A data de nascimento deve conter 10 caracteres")
	private LocalDate dataNascimento;
	
	@NotBlank(message = "a Foto é obrigatório!")
	@Size(min = 1, max = 255, message = "A foto deve conter no mínimo 1 e no máximo 255 caracteres")
	private String foto;
	
	@OneToMany(mappedBy = "vendedor", cascade = CascadeType.ALL)
	@JsonIgnoreProperties({"vendedor"})
	private Set<Servico> ServicosVendidos;
	
	@OneToMany(mappedBy = "comprador", cascade = CascadeType.ALL)
	@JsonIgnoreProperties({"comprador"})
	private Set<Servico> ServicosComprados;

	public Set<Servico> getServicosVendidos() {
		return ServicosVendidos;
	}

	public void setServicosVendidos(Set<Servico> servicosVendidos) {
		ServicosVendidos = servicosVendidos;
	}

	public Set<Servico> getServicosComprados() {
		return ServicosComprados;
	}

	public void setServicosComprados(Set<Servico> servicosComprados) {
		ServicosComprados = servicosComprados;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	
	
}