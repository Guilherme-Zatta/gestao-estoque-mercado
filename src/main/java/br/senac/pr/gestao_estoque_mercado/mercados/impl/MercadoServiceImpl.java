package br.senac.pr.gestao_estoque_mercado.mercados.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.senac.pr.gestao_estoque_mercado.mercados.MercadoRepository;
import br.senac.pr.gestao_estoque_mercado.mercados.MercadoService;
import br.senac.pr.gestao_estoque_mercado.mercados.dto.CreateMercadoDto;
import br.senac.pr.gestao_estoque_mercado.shared.models.Mercado;

@Service
public class MercadoServiceImpl implements MercadoService{

    private final MercadoRepository mercadoRepository;

    public MercadoServiceImpl(MercadoRepository mercadoRepository) {
        this.mercadoRepository = mercadoRepository;
    }

    @Override
    public Mercado save(CreateMercadoDto dto) {
        var mercado = new Mercado(null, dto.nome(), dto.endereco(), dto.cidade(), dto.estado(), dto.cnpj(), dto.ie());
        return this.mercadoRepository.save(mercado);
    }

    @Override
    public List<Mercado> findAll() {
        return mercadoRepository.findAll();
    }

    @Override
    public Mercado findById(Long id) {
        return mercadoRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Mercado object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }
}
