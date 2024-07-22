package br.senac.pr.gestao_estoque_mercado.movimentacao;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.senac.pr.gestao_estoque_mercado.movimentacao.dtos.CreateMovimentacaoDto;
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
}
