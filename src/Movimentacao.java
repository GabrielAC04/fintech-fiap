public class Movimentacao {
    public void adicionarEntrada(Usuario usuario, double valor) {
        usuario.adicionarSaldo(valor);
        System.out.println("Entrada adicionada: R$" + valor);
    }

    public void adicionarSaida(Usuario usuario, double valor) {
        if (usuario.retirarSaldo(valor)) {
            System.out.println("Saída realizada: R$" + valor);
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }
}