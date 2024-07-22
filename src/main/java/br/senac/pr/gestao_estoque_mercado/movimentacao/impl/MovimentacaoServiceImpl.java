package br.senac.pr.gestao_estoque_mercado.movimentacao.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import br.senac.pr.gestao_estoque_mercado.movimentacao.MovimentacaoRepository;
import br.senac.pr.gestao_estoque_mercado.movimentacao.MovimentacaoService;
import br.senac.pr.gestao_estoque_mercado.movimentacao.dtos.CreateMovimentacaoDto;
import br.senac.pr.gestao_estoque_mercado.shared.models.Movimentacao;

@Service
public class MovimentacaoServiceImpl implements MovimentacaoService{
    
    private final MovimentacaoRepository movimentacaoRepository;

    public MovimentacaoServiceImpl(MovimentacaoRepository movimentacaoRepository) {
        this.movimentacaoRepository = movimentacaoRepository;
    }

    @Override
    public Movimentacao save(CreateMovimentacaoDto dto) {
        var movimentacao = new Movimentacao(null, dto.mercadoId(), dto.produtoId(), 
        LocalDateTime.now(), dto.tipoMovimentacao(), dto.quantidade());
        return this.movimentacaoRepository.save(movimentacao);
    }

    @Override
    public List<Movimentacao> findAll() {
        return movimentacaoRepository.findAll();
    }

    @Override
    public Movimentacao findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    @Override
    public void update(Movimentacao object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    
}
