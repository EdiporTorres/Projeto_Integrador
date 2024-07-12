package com.generation.econectar.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_servicos")
public class ServicoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O atributo nome do serviço é obrigatório!")
    @Size(max = 255, message = "O  atributo nome do serviço deve conter no máximo 255 caracteres.")
    private String nomeservico;

    @NotBlank(message = "O atributo descrição é obrigatório!")
    @Size(max = 1000, message = "O atributo descricao deve conter no máximo 1000 caracteres")
    private String descricao;

    @NotBlank(message = "O atributo valor é obrigatório!")
    private float valor;

    @Size(max = 2000, message = "O atributo sobre mim deve conter no máximo 2000 caracteres")
    private String sobremim;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeservico() {
        return nomeservico;
    }

    public void setNomeservico(String nomeservico) {
        this.nomeservico = nomeservico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getSobremim() {
        return sobremim;
    }

    public void setSobremim(String sobremim) {
        this.sobremim = sobremim;
    }

}
