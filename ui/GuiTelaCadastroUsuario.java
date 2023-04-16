package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

import controller.GerenciadorUsuarios;
import entities.Usuario;

public class GuiTelaCadastroUsuario extends JFrame {
    
    private Usuario usuario;
    private JTextField tfLogin;
    private JLabel lbSenha;
    private JLabel lbLogin;
    private JButton btCadastrar;
    private JButton btCancelar;
    private JPasswordField pfSenha;
    private GerenciadorUsuarios gerenciador;

    public GuiTelaCadastroUsuario (GerenciadorUsuarios gerenciador) {
        this.gerenciador = gerenciador;
        inicializarComponentes();
        definirEventos();
    }

    private void inicializarComponentes() {
        setTitle("Cadastro do usuário no sistema");
        setBounds(0, 0, 400, 200);
        setLayout(null);
        tfLogin = new JTextField(5);
        pfSenha = new JPasswordField(5);
        lbSenha = new JLabel("Senha:");
        lbLogin = new JLabel("Login:");
        btCadastrar = new JButton("Cadastrar");
        btCancelar = new JButton("Cancelar");
        tfLogin.setBounds(100, 30, 200, 25);
        lbLogin.setBounds(30, 30, 80, 25);
        lbSenha.setBounds(30, 75, 80, 25);
        pfSenha.setBounds(100, 75, 200, 25);
        btCadastrar.setBounds(75, 120, 100, 25);
        btCancelar.setBounds(200, 120, 100, 25);
        add(tfLogin);
        add(lbSenha);
        add(lbLogin);
        add(btCadastrar);
        add(btCancelar);
        add(pfSenha);
    }

    private void definirEventos() {
        btCadastrar.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String senha = String.valueOf(pfSenha.getPassword());
                String login = String.valueOf(tfLogin.getText());
                criarUsuario(login, senha);
                if(gerenciador.verificarPessoa(login, senha)){
                    JOptionPane.showMessageDialog(null, "Login de usuário já cadastrado, escolha outro nome de usuário");
                    GuiTelaCadastroUsuario telaCadastroUsuario = new GuiTelaCadastroUsuario(gerenciador);
                    telaCadastroUsuario.run();
                    dispose();
                }
                else {
                    gerenciador.cadastarUsuario(usuario);
                    try{
                        gerenciador.salvarPessoas();
                    }catch(IOException o) {
                        JOptionPane.showMessageDialog(null, o.getMessage());
                    }
                    JOptionPane.showMessageDialog(null, "Novo usuário cadastrado com sucesso");
                    GuiMenuPrincipal menu = new GuiMenuPrincipal(usuario);
                    menu.run();
                    dispose();
                }
            }
        });

        btCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
    }

    public void run () {          
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);  
    }

    private void criarUsuario(String login, String senha) {
        this.usuario = new Usuario(login, senha);
    }

    public Usuario getUsuario() {
        return this.usuario;
    }


}
