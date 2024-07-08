package main.java.br.senac.pr.gestao_estoque_mercado.shared.models;

public class Mercados {
    private Long id;
    private String nome;
    private String endereco;
    private String cidade;
    private double cnpj;
    private double ie;
  
    public Mercados(Long id, String nome, String endereco, String cidade, double cnpj, double ie) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.cidade = cidade;
        this.cnpj = cnpj;
        this.ie = ie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public double getCnpj() {
        return cnpj;
    }

    public void setCnpj(double cnpj) {
        this.cnpj = cnpj;
    }

    public double getIe() {
        return ie;
    }

    public void setIe(double ie) {
        this.ie = ie;
    }


    
}
