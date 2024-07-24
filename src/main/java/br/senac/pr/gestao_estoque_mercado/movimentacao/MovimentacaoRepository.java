package br.senac.pr.gestao_estoque_mercado.movimentacao;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import br.senac.pr.gestao_estoque_mercado.movimentacao.dtos.SaldoProdutoMercadoDto;
import br.senac.pr.gestao_estoque_mercado.shared.models.Movimentacao;

@Repository
public interface MovimentacaoRepository extends ListCrudRepository<Movimentacao, Long> {
    @Query("""
            select  mercado_id, produto_id, sum(quantidade) as saldo
                from (select
                    id, mercado_id, produto_id, data_hora, tipo_movimentacao, 
                    case 
                        when tipo_movimentacao ='E' then quantidade
                        when tipo_movimentacao ='S' then (-1 *quantidade)
                        else quantidade
                    end quantidade
                from movimentacoes where produto_id = :produtoId and mercado_id = :mercadoId)
                group by 1, 2
            """)
    public SaldoProdutoMercadoDto getSaldoProdutoMercado(Long produtoId, Long mercadoId);
}
