package br.senac.pr.gestao_estoque_mercado.shared.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("produtos")
public class Produto {
  @Id
  private Long id;
  private String descricao;
  private String marca;
  private String tipo;
  private double saldo;

  public Produto(Long id, String descricao, String marca, String tipo, double saldo) {
    this.id = id;
    this.descricao = descricao;
    this.marca = marca;
    this.tipo = tipo;
    this.saldo = saldo;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public String getMarca() {
    return marca;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public double getSaldo() {
    return saldo;
  }

  public void setSaldo(double saldo) {
    this.saldo = saldo;
  }

}
