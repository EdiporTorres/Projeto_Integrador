package com.generation.econectar.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_servico")
public class Serviço {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O nome do serviço é obrigatório!")
	@Size(min = 1, max = 255, message = "O nome do serviço deve conter no mínimo 1 e no máximo 255 caracteres")
	private String nomeServico;
	
	@NotBlank(message = "A descrição é obrigatória!")
	@Size(min = 1, max = 1000, message = "A descrição deve conter no mínimo 1 e no máximo 1000 caracteres")
	private String descricao;
	
	@NotBlank(message = "O valor é obrigatório!")
	private double valor;
	
	@NotBlank(message = "Sobre mim é obrigatória!")
	@Size(min = 1, max = 1000, message = "Sobre mim deve conter no mínimo 1 e no máximo 1000 caracteres")
	private String sobreMim;
	
	
	@ManyToOne
	@JoinColumn(name = "categoria_id", nullable = false)
	private Categorial categoria;
	
	@ManyToOne
	@JoinColumn(name = "vendedor_id", nullable = false)
	private Usuario vendedor;
	
	@ManyToOne
	@JoinColumn(name = "comprador_id", nullable = false)
	private Usuario comprador;

	public Categorial getCategoria() {
		return categoria;
	}

	public void setCategoria(Categorial categoria) {
		this.categoria = categoria;
	}

	public Usuario getVendedor() {
		return vendedor;
	}

	public void setVendedor(Usuario vendedor) {
		this.vendedor = vendedor;
	}

	public Usuario getComprador() {
		return comprador;
	}

	public void setComprador(Usuario comprador) {
		this.comprador = comprador;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeServico() {
		return nomeServico;
	}

	public void setNomeServico(String nomeServico) {
		this.nomeServico = nomeServico;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getSobreMim() {
		return sobreMim;
	}

	public void setSobreMim(String sobreMim) {
		this.sobreMim = sobreMim;
	}


	
	

}
