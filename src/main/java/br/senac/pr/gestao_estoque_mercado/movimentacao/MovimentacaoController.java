package br.senac.pr.gestao_estoque_mercado.movimentacao;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.senac.pr.gestao_estoque_mercado.movimentacao.impl.MovimentacaoServiceImpl;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {
    
    private final MovimentacaoServiceImpl movimentacaoService;

    public MovimentacaoController(MovimentacaoServiceImpl movimentacoesService) {
        this.
    }

}
