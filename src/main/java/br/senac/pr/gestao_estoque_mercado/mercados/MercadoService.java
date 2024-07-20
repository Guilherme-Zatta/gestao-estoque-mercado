package br.senac.pr.gestao_estoque_mercado.mercados;

import java.util.List;

import br.senac.pr.gestao_estoque_mercado.mercados.dto.CreateMercadoDto;
import br.senac.pr.gestao_estoque_mercado.mercados.dto.UpdateEnderecoMercadoDto;
import br.senac.pr.gestao_estoque_mercado.mercados.dto.UpdateMercadoDto;
import br.senac.pr.gestao_estoque_mercado.shared.models.Mercado;

public interface MercadoService {
    public Mercado save(CreateMercadoDto dto);

    public List<Mercado> findAll();
    
    public Mercado findById(Long id);

    public void update(Mercado object);

    public void update(UpdateEnderecoMercadoDto dto, Long id);

    public void update(UpdateMercadoDto dto, Long id);

    public void deleteById(Long id);
    
}
