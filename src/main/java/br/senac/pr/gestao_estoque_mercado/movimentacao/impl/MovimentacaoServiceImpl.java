package br.senac.pr.gestao_estoque_mercado.movimentacao.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.senac.pr.gestao_estoque_mercado.movimentacao.MovimentacaoRepository;
import br.senac.pr.gestao_estoque_mercado.movimentacao.MovimentacaoService;
import br.senac.pr.gestao_estoque_mercado.movimentacao.dtos.CreateMovimentacaoDto;
import br.senac.pr.gestao_estoque_mercado.movimentacao.dtos.UpdateMovimentacaoDto;
import br.senac.pr.gestao_estoque_mercado.movimentacao.dtos.UpdateQtdeMovimentacaoDto;
import br.senac.pr.gestao_estoque_mercado.movimentacao.types.TipoMovimentacaoEnum;
import br.senac.pr.gestao_estoque_mercado.produtos.ProdutoRepository;
import br.senac.pr.gestao_estoque_mercado.shared.models.Movimentacao;
import br.senac.pr.gestao_estoque_mercado.shared.models.Produto;

@Service
public class MovimentacaoServiceImpl implements MovimentacaoService{
    
    private final MovimentacaoRepository movimentacaoRepository;
    private final ProdutoRepository produtoRepository;

    public MovimentacaoServiceImpl(MovimentacaoRepository movimentacaoRepository, ProdutoRepository produtoRepository) {
        this.movimentacaoRepository = movimentacaoRepository;
        this.produtoRepository = produtoRepository;
    }

    @Override
    public Movimentacao save(CreateMovimentacaoDto dto) {
        // Procurar o produto e validar se ele existe
        Optional<Produto> produtoOptional = produtoRepository.findById(dto.produtoId());
        if (produtoOptional.isEmpty()) {
            throw new RuntimeException("Produto não encontrado");
        }

        Produto produto = produtoOptional.get();

        // Se o produto existir e se for uma movimentação de saída, validar se o produto tem saldo disponível
        if (dto.tipoMovimentacao().equals(TipoMovimentacaoEnum.SAIDA.getValue()) && produto.getSaldo() < dto.quantidade()) {
            throw new RuntimeException("Saldo insuficiente");
        }

        // Se for uma movimentação de entrada, ajusta o saldo e segue cadastrando a movimentação
        if (dto.tipoMovimentacao().equals(TipoMovimentacaoEnum.ENTRADA.getValue())) {
            produto.setSaldo(produto.getSaldo() + dto.quantidade());
        } else if (dto.tipoMovimentacao().equals(TipoMovimentacaoEnum.SAIDA.getValue())) {
            produto.setSaldo(produto.getSaldo() - dto.quantidade());
        }
        
        // Atualizo o saldo do produto (produtoRepository.save - equivalente a um patch no saldo do produto)
        produtoRepository.save(produto);

        Movimentacao movimentacao = new Movimentacao(null, dto.mercadoId(), dto.produtoId(), 
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
        Movimentacao movimentacao = movimentacaoRepository.findById(id).orElse(null);
        if (movimentacao == null) {
            throw new Error("Movimentação não existe!");            
        }
        movimentacao.setTipoMovimentacao(dto.tipoMovimentacao());
        movimentacao.setQuantidade(dto.quantidade());
        movimentacaoRepository.save(movimentacao);
    }

    @Override
    public void update(UpdateMovimentacaoDto dto, Long id) {
        Movimentacao movimentacao = movimentacaoRepository.findById(id).orElse(null);
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