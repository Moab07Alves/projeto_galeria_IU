package ui;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

import controller.GerenciadorUsuarios;
import entities.Usuario;

public class GuiLogin extends JFrame {

    private GerenciadorUsuarios gerenciador;
    private Usuario usuario;
    private JTextField tfLogin;
    private JLabel lbSenha;
    private JLabel lbLogin;
    private JButton btLogar;
    private JButton btCancelar;
    private JPasswordField pfSenha;

    public GuiLogin (GerenciadorUsuarios gerenciador) {
        this.gerenciador = gerenciador;
        inicializarComponentes();
        definirEventos();
    }

    private void inicializarComponentes() {
        setTitle("Login no sistema");
        setBounds(0, 0, 400, 200);
        setLayout(null);
        tfLogin = new JTextField(5);
        pfSenha = new JPasswordField(5);
        lbSenha = new JLabel("Senha:");
        lbLogin = new JLabel("Login:");
        btLogar = new JButton("Logar");
        btCancelar = new JButton("Cancelar");
        tfLogin.setBounds(100, 30, 200, 25);
        lbLogin.setBounds(30, 30, 80, 25);
        lbSenha.setBounds(30, 75, 80, 25);
        pfSenha.setBounds(100, 75, 200, 25);
        btLogar.setBounds(75, 120, 100, 25);
        btCancelar.setBounds(200, 120, 100, 25);
        add(tfLogin);
        add(lbSenha);
        add(lbLogin);
        add(btLogar);
        add(btCancelar);
        add(pfSenha);
    }

    private void definirEventos() {
        btLogar.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String login = String.valueOf(tfLogin.getText());
                String senha = String.valueOf(pfSenha.getPassword());
                usuario = new Usuario(login, senha);
                if (gerenciador.verificarUsuario(login)) {
                    GuiMenuPrincipal telaMenu = new GuiMenuPrincipal(gerenciador, usuario);
                    telaMenu.run();
                    dispose();
                }
                else {
                    JOptionPane.showMessageDialog(null, "O usuário ainda não foi cadastrado, por isso será rediracionado para tela de cadastro para assim poder utilizar as funcionalidades");
                    GuiTelaCadastroUsuario telaCadastro = new GuiTelaCadastroUsuario(gerenciador);
                    telaCadastro.run();
                    dispose();
                }
            }
        });

        btCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null, "Obrigado por usar o nosso programa");
                dispose();
            }
        });
    }

    public void run () {          
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);  
    }

}
