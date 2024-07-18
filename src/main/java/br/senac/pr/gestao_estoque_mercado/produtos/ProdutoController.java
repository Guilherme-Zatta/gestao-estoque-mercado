package br.senac.pr.gestao_estoque_mercado.produtos;

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

import br.senac.pr.gestao_estoque_mercado.produtos.dto.CreateProdutoDto;
import br.senac.pr.gestao_estoque_mercado.produtos.dto.UpdateSaldoProdutoDto;
import br.senac.pr.gestao_estoque_mercado.produtos.impl.ProdutoServiceImpl;
import br.senac.pr.gestao_estoque_mercado.shared.models.Produto;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoServiceImpl produtoService;

    public ProdutoController(ProdutoServiceImpl produtosService) {
        this.produtoService = produtosService;
    }
// Criar um novo produto
    @PostMapping
    public ResponseEntity<Produto> save(@RequestBody CreateProdutoDto dto) {
        var saved = this.produtoService.save(dto);
        return ResponseEntity.ok(saved);
    }

// GET - Listar todos os produtos
    @GetMapping("")
    public List<Produto> getProdutos() {
        return produtoService.findAll();
    }

// GET - Listar produtos por ID
    @GetMapping("/{id}")
    public ResponseEntity<Produto> getProdutoById(@PathVariable Long id) {
        var produto = produtoService.findById(id);
        if (produto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(produto);
    }

// PATCH - Atualização parcial
    @PatchMapping("/{id}")
    public ResponseEntity<String> updateSaldoProduto(@RequestBody UpdateSaldoProdutoDto dto,
        @PathVariable Long id) {
            produtoService.update(dto, id);
            return ResponseEntity.ok().build();
        }

// DELETE - Exclusão
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduto(@PathVariable Long id) {
        produtoService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
