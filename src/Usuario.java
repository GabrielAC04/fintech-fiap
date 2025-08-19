import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome;
    private String email;
    private String senha;
    private double saldo;
    private List<Meta> metas;

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.saldo = 0.0;
        this.metas = new ArrayList<>();
    }

    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public String getSenha() { return senha; }
    public double getSaldo() { return saldo; }

    public void adicionarSaldo(double valor) { this.saldo += valor; }

    public boolean retirarSaldo(double valor) {
        if (valor <= saldo) {
            this.saldo -= valor;
            return true;
        }
        return false;
    }

    public void adicionarMeta(Meta meta) { metas.add(meta); }
    public List<Meta> getMetas() { return metas; }
}