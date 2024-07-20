package br.senac.pr.gestao_estoque_mercado.movimentacao.dtos;

import java.time.LocalDateTime;

public record CreateMovimentacaoDto(
    Long mercadoId,
    Long produtoId,
    LocalDateTime dataHora,
    Character tipoMovimentacao,
    Double quantidade) {
    
}
