public class Meta {
    private String descricao;
    private double valor;

    public Meta(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return descricao + " - R$" + valor;
    }
}