package br.senac.pr.gestao_estoque_mercado.produtos.dto;

public class UpdateSaldoProdutoDto {
    private Double saldo;

    public UpdateSaldoProdutoDto(Double saldo) {
        this.saldo = saldo;
    }

    public UpdateSaldoProdutoDto() {
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

}
