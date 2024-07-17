package br.senac.pr.gestao_estoque_mercado.produtos;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.senac.pr.gestao_estoque_mercado.produtos.dto.CreateProdutoDto;
import br.senac.pr.gestao_estoque_mercado.produtos.impl.ProdutoServiceImpl;
import br.senac.pr.gestao_estoque_mercado.shared.models.Produto;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoServiceImpl produtoService;

    public ProdutoController(ProdutoServiceImpl produtosService) {
        this.produtoService = produtosService;
    }

    @PostMapping
    public ResponseEntity<Produto> save(@RequestBody CreateProdutoDto dto) {
        var saved = this.produtoService.save(dto);
        return ResponseEntity.ok(saved);
    }
}
