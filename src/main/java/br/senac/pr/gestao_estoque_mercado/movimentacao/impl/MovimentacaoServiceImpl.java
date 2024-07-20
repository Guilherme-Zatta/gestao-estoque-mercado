package br.senac.pr.gestao_estoque_mercado.movimentacao.impl;

import org.springframework.stereotype.Service;

import br.senac.pr.gestao_estoque_mercado.movimentacao.MovimentacaoService;

@Service
public class MovimentacaoServiceImpl implements MovimentacaoService{

    private final MovimentacaoRepository MovimentacaoRepository;

    public MovimentacaoServiceImpl(MovimentacaoRepository movimentacaoRepository) {
        this.movimentacaoRepository = movimentacaoRepository;
    }
    
}
