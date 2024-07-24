package br.senac.pr.gestao_estoque_mercado.movimentacao;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.senac.pr.gestao_estoque_mercado.movimentacao.dtos.CreateMovimentacaoDto;
import br.senac.pr.gestao_estoque_mercado.movimentacao.dtos.UpdateMovimentacaoDto;
import br.senac.pr.gestao_estoque_mercado.movimentacao.dtos.UpdateQtdeMovimentacaoDto;
import br.senac.pr.gestao_estoque_mercado.movimentacao.impl.MovimentacaoServiceImpl;
import br.senac.pr.gestao_estoque_mercado.shared.models.Movimentacao;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {
    
    private final MovimentacaoServiceImpl movimentacaoService;

    public MovimentacaoController(MovimentacaoServiceImpl movimentacoesService) {
        this.movimentacaoService = movimentacoesService;
    }

// Criar uma nova movimentacao
    @PostMapping
    public ResponseEntity<Movimentacao> save(@RequestBody CreateMovimentacaoDto dto) {
        var saved = this.movimentacaoService.save(dto);
        return ResponseEntity.ok(saved);
    }


// GET - Listar todas as movimentações
    @GetMapping("")
    public List<Movimentacao> getMovimentacoes() {
        return movimentacaoService.findAll();
    }

// GET - Listar movimentação por ID
    @GetMapping("/{id}")
    public ResponseEntity<Movimentacao> getMovimentacaoById(@PathVariable Long id) {
        var movimentacao = movimentacaoService.findById(id);
        if (movimentacao == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(movimentacao);
    }
/* 
// PATCH - Atualização Parcial
    @PatchMapping("/{id}")
    public ResponseEntity<String> updateQtdeMovimentacao(@RequestBody UpdateQtdeMovimentacaoDto dto,
        @PathVariable Long id) {
            movimentacaoService.update(dto, id);
            return ResponseEntity.ok().build();
        }

// PUT - Atualização Completa
    @PutMapping("/{id}")
    public ResponseEntity<Movimentacao> updateMovimentacao(@RequestBody UpdateMovimentacaoDto dto,
        @PathVariable Long id) {
            movimentacaoService.update(dto, id);
            return ResponseEntity.ok().build();
        }
*/
// DELETE - Exclusão
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMovimentacao(@PathVariable Long id) {
        movimentacaoService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
