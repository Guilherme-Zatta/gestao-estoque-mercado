package br.senac.pr.gestao_estoque_mercado.shared.repositories;
import java.util.List;
import java.util.Optional;

public interface BaseJdbcRepository<T, ID> {
  int save(T object);

  void update(T object);

  Optional<T> findById(ID id);

  int deleteById(ID id);

  List<T> findAll();

  int deleteAll();
}
