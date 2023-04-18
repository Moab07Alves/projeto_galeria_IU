package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controller.GerenciadorUsuarios;
import entities.Usuario;


public class GuiCriarGaleria extends JFrame{
    
    private GerenciadorUsuarios gerenciador;
    private Usuario usuario;
    private JLabel lbnomGaleria;
    private JButton btCriar;
    private JButton btCancelar;
    private JTextField tfnomeGaleria;

    public GuiCriarGaleria (GerenciadorUsuarios gerenciador, Usuario usuario) {
        this.gerenciador = gerenciador;
        this.usuario = usuario;
        inicializarComponentes();
        definirEventos();
    }

    private void inicializarComponentes() {
        setTitle("Criar Galeria");
        setBounds(0, 0, 275, 175);
        setLayout(null);
        tfnomeGaleria = new JTextField(10);
        lbnomGaleria = new JLabel("Título da galeria:");
        btCriar = new JButton("Criar");
        btCancelar = new JButton("Cancelar");
        lbnomGaleria.setBounds(20, 30, 100, 20);
        tfnomeGaleria.setBounds(120, 30, 120, 25);
        btCriar.setBounds(15, 100, 100, 25);
        btCancelar.setBounds(150, 100, 100, 25);
        add(tfnomeGaleria);
        add(lbnomGaleria);
        add(btCriar);
        add(btCancelar);
    }

    private void definirEventos() {
        btCriar.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e){
                try{
                    String tituloGaleria = String.valueOf(tfnomeGaleria.getText());
                    gerenciador.getUsuario(usuario.getLogin()).criarGaleria(tituloGaleria);
                    gerenciador.salvarPessoas();
                    JOptionPane.showMessageDialog(null, "Nova galeria criada com sucesso");
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
                GuiMenuPrincipal telaMenu = new GuiMenuPrincipal(gerenciador, usuario);
                telaMenu.run();
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
