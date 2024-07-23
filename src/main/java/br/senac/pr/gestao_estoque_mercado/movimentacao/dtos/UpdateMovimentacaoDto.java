package br.senac.pr.gestao_estoque_mercado.movimentacao.dtos;

public record UpdateMovimentacaoDto(
    Long mercadoId,
    Long produtoId,
    Character tipoMovimentacao,
    double quantidade) {

}
    

