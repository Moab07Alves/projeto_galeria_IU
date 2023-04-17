package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controller.GerenciadorUsuarios;
import entities.Usuario;

public class GuiTelaCadastroUsuario extends JFrame {

    private GerenciadorUsuarios gerenciador;
    private Usuario usuario;
    private JTextField tfLogin;
    private JLabel lbSenha;
    private JLabel lbLogin;
    private JButton btCadastrar;
    private JButton btCancelar;
    private JPasswordField pfSenha;

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
                try{
                    String login = String.valueOf(tfLogin.getText());
                    String senha = String.valueOf(pfSenha.getPassword());
                    usuario = new Usuario(login, senha);
                    gerenciador.cadastarUsuario(usuario);
                    if (gerenciador.verificarUsuario(login)) {
                        JOptionPane.showMessageDialog(null, "Obrigado por se cadastrar no nosso programa, aproveite as funcionalidades");
                    }
                    gerenciador.salvarPessoas();
                    GuiMenuPrincipal telaMenu = new GuiMenuPrincipal(gerenciador, usuario);
                    telaMenu.run();
                    dispose();
                } catch (Exception x) {
                    JOptionPane.showMessageDialog(null, x.getMessage());
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
