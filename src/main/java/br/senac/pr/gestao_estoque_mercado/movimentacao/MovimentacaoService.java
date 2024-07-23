package br.senac.pr.gestao_estoque_mercado.movimentacao;

import java.util.List;

import br.senac.pr.gestao_estoque_mercado.movimentacao.dtos.CreateMovimentacaoDto;
import br.senac.pr.gestao_estoque_mercado.movimentacao.dtos.UpdateMovimentacaoDto;
import br.senac.pr.gestao_estoque_mercado.movimentacao.dtos.UpdateQtdeMovimentacaoDto;
import br.senac.pr.gestao_estoque_mercado.shared.models.Movimentacao;
public interface MovimentacaoService {
  public Movimentacao save(CreateMovimentacaoDto dto);

  public List<Movimentacao> findAll();

  public Movimentacao findById(Long id);

  public void update(Movimentacao object);

  public void update(UpdateQtdeMovimentacaoDto dto, Long id);

  public void update(UpdateMovimentacaoDto dto, Long id);

  public void deleteById(Long id);
}
