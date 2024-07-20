package br.senac.pr.gestao_estoque_mercado.mercados.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.senac.pr.gestao_estoque_mercado.mercados.MercadoRepository;
import br.senac.pr.gestao_estoque_mercado.mercados.MercadoService;
import br.senac.pr.gestao_estoque_mercado.mercados.dto.CreateMercadoDto;
import br.senac.pr.gestao_estoque_mercado.mercados.dto.UpdateEnderecoMercadoDto;
import br.senac.pr.gestao_estoque_mercado.mercados.dto.UpdateMercadoDto;
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
    public void update(UpdateMercadoDto dto, Long id) {
        Mercado mercado = mercadoRepository.findById(id).get();
        if (mercado == null) {
            throw new Error("Mercado não existe!");
        }
        mercado.setNome(dto.nome());
        mercado.setEndereco(dto.endereco());
        mercado.setCidade(dto.cidade());
        mercado.setEstado(dto.estado());
        mercado.setCnpj(dto.cnpj());
        mercado.setIe(dto.ie());
        mercadoRepository.save(mercado);
    }

    @Override
    public void update(UpdateEnderecoMercadoDto dto, Long id) {
        Mercado mercado = mercadoRepository.findById(id).get();
        if (mercado == null) {
            throw new Error("Mercado não existe!");
        }
        mercado.setEndereco(dto.endereco());
        mercado.setCidade(dto.cidade());
        mercado.setEstado(dto.estado());
        mercadoRepository.save(mercado);
    }

    @Override
    public void deleteById(Long id) {
        mercadoRepository.deleteById(id);
    }

    public void updateEnderecoMercado(Mercado mercado) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateSaldoProduto'");
    }

    @Override
    public void update(Mercado object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

}
