import entities.Usuario;
import ui.GuiLogin;
import ui.GuiMenuPrincipal;
import ui.GuiTelaCadastroUsuario;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.*;

import controller.GerenciadorUsuarios;

public class Sistema {
    
    static GerenciadorUsuarios gerenciador = new GerenciadorUsuarios();

    public static void main(String[] args) throws IOException {

        try {
            gerenciador.recuperarPessoas();
        } catch(FileNotFoundException e) {
        }

        int novoUsuario = JOptionPane.showConfirmDialog(null,"Novo Usuário?(Yes = Sim, No = Não)","Escolha um",JOptionPane.YES_NO_OPTION);

        if(novoUsuario == 0) { // Opcao = 0 - Sim, o usuário não tem acesso ao nosso sistema
            Usuario usuarioCadastrado;
                GuiTelaCadastroUsuario telaCadastro = new GuiTelaCadastroUsuario(gerenciador);
                telaCadastro.run();
                usuarioCadastrado = telaCadastro.getUsuario();

        }
        else{ // Opcao = 1 - Não, o usuário já tem acesso ao nosso sistema
            GuiLogin telaLogin = new GuiLogin(gerenciador);
            telaLogin.run();
            Usuario usuario = telaLogin.getUsuario();
        }
    }
      
}      
