import java.util.ArrayList;
import java.util.List;

public class UsuarioService {
    private List<Usuario> usuarios = new ArrayList<>();

    public Usuario criarConta(String nome, String email, String senha) {
        Usuario usuario = new Usuario(nome, email, senha);
        usuarios.add(usuario);
        return usuario;
    }

    public Usuario validarLogin(String email, String senha) {
        for (Usuario u : usuarios) {
            if (u.getEmail().equals(email) && u.getSenha().equals(senha)) {
                return u;
            }
        }
        return null;
    }

    public void excluirConta(Usuario usuario) {
        usuarios.remove(usuario);
    }
}