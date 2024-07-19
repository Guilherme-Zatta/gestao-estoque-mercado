package br.senac.pr.gestao_estoque_mercado.mercados;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.senac.pr.gestao_estoque_mercado.mercados.dto.CreateMercadoDto;
import br.senac.pr.gestao_estoque_mercado.mercados.dto.UpdateEnderecoMercadoDto;
import br.senac.pr.gestao_estoque_mercado.mercados.impl.MercadoServiceImpl;
import br.senac.pr.gestao_estoque_mercado.shared.models.Mercado;

@RestController
@RequestMapping("/mercados")
public class MercadoController {
    
    private final MercadoServiceImpl mercadoService;

    public MercadoController(MercadoServiceImpl mercadoService) {
        this.mercadoService = mercadoService;
    }
// Criar um novo produto
    @PostMapping
    public ResponseEntity<Mercado> save(@RequestBody CreateMercadoDto dto) {
        var saved = this.mercadoService.save(dto);
        return ResponseEntity.ok(saved);
    }

// GET - Listar todos os mercados
    @GetMapping("")
    public List<Mercado> getMercados() {
        return mercadoService.findAll();
    }

// GET - Listar mercador por ID
    @GetMapping("/{id}")
    public ResponseEntity<Mercado> getMercadoById(@PathVariable Long id) {
        var mercado = mercadoService.findById(id);
        if (mercado == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(mercado);
    }

// PATCH - Atualização parcial

    @PatchMapping("/{id}")
    public ResponseEntity<String> updateEnderecoMercado(@RequestBody UpdateEnderecoMercadoDto dto,
        @PathVariable Long id) {
            mercadoService.update(dto, id);
            return ResponseEntity.ok().build();
        }

 // DELETE - Exclusão
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMercado(@PathVariable Long id) {
        mercadoService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
