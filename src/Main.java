import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UsuarioService usuarioService = new UsuarioService();
        Movimentacao movimentacao = new Movimentacao();

        Usuario usuarioLogado = null;
        int opcao;

        while (true) {
            if (usuarioLogado == null) {
                System.out.println("\n--- MENU INICIAL ---");
                System.out.println("1. Criar conta");
                System.out.println("2. Fazer login");
                System.out.println("3. Sair");
                System.out.print("Escolha: ");
                opcao = sc.nextInt();
                sc.nextLine();

                if (opcao == 1) {
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Senha: ");
                    String senha = sc.nextLine();
                    usuarioLogado = usuarioService.criarConta(nome, email, senha);
                    System.out.println("Conta criada com sucesso!");
                } else if (opcao == 2) {
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Senha: ");
                    String senha = sc.nextLine();
                    usuarioLogado = usuarioService.validarLogin(email, senha);
                    if (usuarioLogado != null) {
                        System.out.println("Login realizado com sucesso!");
                    } else {
                        System.out.println("Email ou senha inválidos.");
                    }
                } else if (opcao == 3) {
                    System.out.println("Saindo do sistema...");
                    break;
                }
            } else {
                System.out.println("\n--- MENU DO USUÁRIO ---");
                System.out.println("1. Ver saldo");
                System.out.println("2. Adicionar entrada");
                System.out.println("3. Adicionar saída");
                System.out.println("4. Criar meta");
                System.out.println("5. Ver metas");
                System.out.println("6. Excluir conta");
                System.out.println("7. Sair para menu inicial");
                System.out.print("Escolha: ");
                opcao = sc.nextInt();
                sc.nextLine();

                switch (opcao) {
                    case 1:
                        System.out.println("Saldo atual: R$" + usuarioLogado.getSaldo());
                        break;
                    case 2:
                        System.out.print("Valor da entrada: ");
                        double entrada = sc.nextDouble();
                        movimentacao.adicionarEntrada(usuarioLogado, entrada);
                        break;
                    case 3:
                        System.out.print("Valor da saída: ");
                        double saida = sc.nextDouble();
                        movimentacao.adicionarSaida(usuarioLogado, saida);
                        break;
                    case 4:
                        System.out.print("Descrição da meta: ");
                        String descricao = sc.nextLine();
                        System.out.print("Valor da meta: ");
                        double valor = sc.nextDouble();
                        sc.nextLine();
                        usuarioLogado.adicionarMeta(new Meta(descricao, valor));
                        System.out.println("Meta criada com sucesso!");
                        break;
                    case 5:
                        System.out.println("Metas:");
                        for (Meta meta : usuarioLogado.getMetas()) {
                            System.out.println(meta);
                        }
                        break;
                    case 6:
                        usuarioService.excluirConta(usuarioLogado);
                        usuarioLogado = null;
                        System.out.println("Conta excluída com sucesso!");
                        break;
                    case 7:
                        usuarioLogado = null;
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            }
        }
        sc.close();
    }
}