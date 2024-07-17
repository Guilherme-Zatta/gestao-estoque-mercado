package br.senac.pr.gestao_estoque_mercado.produtos;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import br.senac.pr.gestao_estoque_mercado.shared.models.Produto;

@Repository
public interface ProdutoRepository extends ListCrudRepository<Produto, Long> {
    
}
