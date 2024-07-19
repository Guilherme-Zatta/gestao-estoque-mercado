package br.senac.pr.gestao_estoque_mercado.mercados.dto;

public record CreateMercadoDto(
        String nome,
        String endereco,
        String cidade,
        String estado,
        double cnpj,
        double ie) {

}
