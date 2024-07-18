package br.senac.pr.gestao_estoque_mercado.produtos.dto;

public class UpdateProdutoDto {
    private String descricao;
    private String marca;
    private String tipo;
    private double saldo;

    public UpdateProdutoDto(String descricao, String marca,
        String tipo, double saldo) {
            this.descricao = descricao;
            this.marca = marca;
            this.tipo = tipo;
            this.saldo = saldo;
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
