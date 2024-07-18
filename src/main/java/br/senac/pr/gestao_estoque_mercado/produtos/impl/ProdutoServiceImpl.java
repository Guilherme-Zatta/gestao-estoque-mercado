package br.senac.pr.gestao_estoque_mercado.produtos.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.senac.pr.gestao_estoque_mercado.produtos.ProdutoRepository;
import br.senac.pr.gestao_estoque_mercado.produtos.ProdutoService;
import br.senac.pr.gestao_estoque_mercado.produtos.dto.CreateProdutoDto;
import br.senac.pr.gestao_estoque_mercado.produtos.dto.UpdateSaldoProdutoDto;
import br.senac.pr.gestao_estoque_mercado.shared.models.Produto;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public Produto save(CreateProdutoDto dto) {
        var produto = new Produto(null, dto.descricao(), dto.marca(), dto.tipo(), dto.saldo());
        return this.produtoRepository.save(produto);
    }

    @Override
    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    @Override
    public Produto findById(Long id) {
        return produtoRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        produtoRepository.deleteById(id);
    }

    @Override
    public void update(Produto object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void update(UpdateSaldoProdutoDto dto, Long id) {
        Produto produto = produtoRepository.findById(id).get(); 
        if (produto == null) {
            throw new Error("Produto não existe!");
        }
        produto.setSaldo(dto.getSaldo());
        produtoRepository.save(produto);
    }

    public void updateSaldoProduto(Produto produto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateSaldoProduto'");
    }

    

}
