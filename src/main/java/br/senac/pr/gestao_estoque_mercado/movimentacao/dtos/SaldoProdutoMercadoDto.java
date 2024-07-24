package br.senac.pr.gestao_estoque_mercado.movimentacao.dtos;

public record SaldoProdutoMercadoDto(
        Long produtoId,
        Long mercadoId,
        Double saldo) {

}
