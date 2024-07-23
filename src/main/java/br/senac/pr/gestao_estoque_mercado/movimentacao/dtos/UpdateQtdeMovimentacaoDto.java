package br.senac.pr.gestao_estoque_mercado.movimentacao.dtos;

public record UpdateQtdeMovimentacaoDto(
    Character tipoMovimentacao,
    double quantidade) {

}