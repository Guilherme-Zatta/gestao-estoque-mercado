package br.senac.pr.gestao_estoque_mercado.movimentacao.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import br.senac.pr.gestao_estoque_mercado.movimentacao.MovimentacaoRepository;
import br.senac.pr.gestao_estoque_mercado.movimentacao.MovimentacaoService;
import br.senac.pr.gestao_estoque_mercado.movimentacao.dtos.CreateMovimentacaoDto;
import br.senac.pr.gestao_estoque_mercado.movimentacao.dtos.UpdateMovimentacaoDto;
import br.senac.pr.gestao_estoque_mercado.movimentacao.dtos.UpdateQtdeMovimentacaoDto;
import br.senac.pr.gestao_estoque_mercado.shared.models.Movimentacao;

@Service
public class MovimentacaoServiceImpl implements MovimentacaoService{
    
    private final MovimentacaoRepository movimentacaoRepository;

    public MovimentacaoServiceImpl(MovimentacaoRepository movimentacaoRepository) {
        this.movimentacaoRepository = movimentacaoRepository;
    }

    @Override
    public Movimentacao save(CreateMovimentacaoDto dto) {
        // Procurar o produto e validar se ele existe

        // Se o produto existir e se for uma movimentação de saída, validar se o produto tem saldo disponível
        // Se for uma movimentação de entrada, ajusta o saldo e segue cadastrando a movimentação

        // Atualizo o saldo do produto (produtoRepository.save - equivalente a um patch no saldo do produto)
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
        return movimentacaoRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        movimentacaoRepository.deleteById(id);
    }

    @Override
    public void update(Movimentacao object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void update(UpdateQtdeMovimentacaoDto dto, Long id) {
        Movimentacao movimentacao = movimentacaoRepository.findById(id).get();
        if (movimentacao == null) {
            throw new Error("Movimentação não existe!");            
        }
        movimentacao.setTipoMovimentacao(dto.tipoMovimentacao());
        movimentacao.setQuantidade(dto.quantidade());
        movimentacaoRepository.save(movimentacao);
    }

    @Override
    public void update(UpdateMovimentacaoDto dto, Long id) {
        Movimentacao movimentacao = movimentacaoRepository.findById(id).get();
        if (movimentacao == null) {
            throw new Error("Movimentação não existe!");
        }
        movimentacao.setMercadoId(dto.mercadoId());
        movimentacao.setProdutoId(dto.produtoId());
        movimentacao.setTipoMovimentacao(dto.tipoMovimentacao());
        movimentacao.setQuantidade(dto.quantidade());
        movimentacaoRepository.save(movimentacao);
    }

}
