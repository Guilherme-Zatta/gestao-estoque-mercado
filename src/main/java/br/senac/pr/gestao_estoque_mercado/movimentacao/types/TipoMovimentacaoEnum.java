package br.senac.pr.gestao_estoque_mercado.movimentacao.types;

public enum TipoMovimentacaoEnum {
    ENTRADA('E'),
    SAIDA('S');

    private Character value;

    TipoMovimentacaoEnum(Character value) {
        this.value = value;
    }

    public Character getValue() {
        return value;
    }

    public static TipoMovimentacaoEnum fromvalue(Character value) {
        for (TipoMovimentacaoEnum tipo : values()) {
            if (tipo.getValue().equals(value)) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Código de movimentação inválido: " + value);
    }
}
