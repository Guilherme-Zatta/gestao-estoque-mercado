package br.senac.pr.gestao_estoque_mercado.shared.models;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("movimentacoes")
public class Movimentacao {
    @Id
    private Long id;
    private Long mercadoId;
    private Long produtoId;
    private LocalDateTime dataHora;
    private Character tipoMovimentacao;
    private Double quantidade;

    public Movimentacao(Long id, Long mercadoId, Long produtoId, Character tipoMovimentacao,
            Double quantidade) {
        this.id = id;
        this.mercadoId = mercadoId;
        this.produtoId = produtoId;
        this.dataHora = LocalDateTime.now();
        this.tipoMovimentacao = tipoMovimentacao;
        this.quantidade = quantidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMercadoId() {
        return mercadoId;
    }

    public void setMercadoId(Long mercadoId) {
        this.mercadoId = mercadoId;
    }

    public Long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Character getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public void setTipoMovimentacao(Character tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

}
