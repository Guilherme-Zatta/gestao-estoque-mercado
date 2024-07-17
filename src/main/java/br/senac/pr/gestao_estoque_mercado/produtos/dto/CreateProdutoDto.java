package br.senac.pr.gestao_estoque_mercado.produtos.dto;

public record CreateProdutoDto(
        String descricao,
        String marca,
        String tipo,
        double saldo) {

}
