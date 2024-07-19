package br.senac.pr.gestao_estoque_mercado.mercados;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import br.senac.pr.gestao_estoque_mercado.shared.models.Mercado;

@Repository
public interface MercadoRepository extends ListCrudRepository<Mercado, Long> {
    
}    

