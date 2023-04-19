
import java.io.IOException;

import javax.swing.*;

import controller.GerenciadorUsuarios;
import ui.telasDeEntrada.GuiLogin;
import ui.telasDeEntrada.GuiTelaCadastroUsuario;

public class Sistema {
    
    static GerenciadorUsuarios gerenciador = new GerenciadorUsuarios();

    public static void main(String[] args) throws IOException {

        
        try {
            gerenciador.recuperarPessoas();
        } catch(Exception e) {
        }

        int novoUsuario = JOptionPane.showConfirmDialog(null,"Novo Usuário?(Yes = Sim, No = Não)","Escolha um",JOptionPane.YES_NO_OPTION);

        if(novoUsuario == 0) { // Opcao = 0 - Sim, o usuário não tem acesso ao nosso sistema
            GuiTelaCadastroUsuario telaCadastro = new GuiTelaCadastroUsuario(gerenciador);
            telaCadastro.run();
        }
        else{ // Opcao = 1 - Não, o usuário já tem acesso ao nosso sistema
           GuiLogin telaLogin = new GuiLogin(gerenciador);
           telaLogin.run();
        }

    }
      
}      
