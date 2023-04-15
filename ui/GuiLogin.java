package ui;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

import entities.Usuario;

public class GuiLogin extends JFrame {
    
    private Usuario usuario;
    private JTextField tfLogin;
    private JLabel lbSenha;
    private JLabel lbLogin;
    private JButton btLogar;
    private JButton btCancelar;
    private JPasswordField pfSenha;
    private static GuiLogin frame;

    public GuiLogin () {
        inicializarComponentes();
        definirEventos();
    }

    private void inicializarComponentes() {
        setTitle("Login no sistema");
        setBounds(0, 0, 250, 200);
        setLayout(null);
        tfLogin = new JTextField(5);
        pfSenha = new JPasswordField(5);
        lbSenha = new JLabel("Senha:");
        lbLogin = new JLabel("Login:");
        btLogar = new JButton("Logar");
        btCancelar = new JButton("Cancelar");
        tfLogin.setBounds(100, 30, 120, 25);
        lbLogin.setBounds(30, 30, 80, 25);
        lbSenha.setBounds(30, 75, 80, 25);
        pfSenha.setBounds(100, 75, 120, 25);
        btLogar.setBounds(20, 120, 100, 25);
        btCancelar.setBounds(125, 120, 100, 25);
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
                String senha = String.valueOf(pfSenha.getPassword());
                String login = String.valueOf(tfLogin.getText());
                if(tfLogin.getText().equals("java8") && senha.equals("java8")) {
                    setVisible(false);
                    GuiMenuPrincipal menu = new GuiMenuPrincipal(criarUsuario(login, senha));
                    menu.run();
                } else {
            JOptionPane.showMessageDialog(null, "Login ou Senha incorretas!");
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
        Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((tela.width - getSize().width) / 2, (tela.height - getSize().height) / 2);
        setLocationRelativeTo(null);
        setVisible(true);  
    }

    private Usuario criarUsuario(String login, String senha) {
        this.usuario = new Usuario(login, senha);
        return this.usuario;
    }

}
