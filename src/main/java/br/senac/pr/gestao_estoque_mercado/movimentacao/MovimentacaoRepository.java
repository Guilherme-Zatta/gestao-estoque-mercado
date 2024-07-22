package br.senac.pr.gestao_estoque_mercado.movimentacao;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import br.senac.pr.gestao_estoque_mercado.shared.models.Movimentacao;

@Repository
public interface MovimentacaoRepository extends ListCrudRepository<Movimentacao, Long> {
    
}
