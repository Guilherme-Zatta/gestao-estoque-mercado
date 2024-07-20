package br.senac.pr.gestao_estoque_mercado.movimentacao;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimentacaoRepository extends ListCrudRepository<Movimentacao, Long> {
    
}
