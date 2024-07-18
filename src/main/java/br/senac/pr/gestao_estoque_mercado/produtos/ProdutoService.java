package br.senac.pr.gestao_estoque_mercado.produtos;

import java.util.List;

import br.senac.pr.gestao_estoque_mercado.produtos.dto.CreateProdutoDto;
import br.senac.pr.gestao_estoque_mercado.produtos.dto.UpdateSaldoProdutoDto;
import br.senac.pr.gestao_estoque_mercado.shared.models.Produto;

public interface ProdutoService {
    public Produto save(CreateProdutoDto dto);

    public List<Produto> findAll();

    public Produto findById(Long id);

    public void update(Produto object);

    public void update(UpdateSaldoProdutoDto dto, Long id);

    public void deleteById(Long id);
}
