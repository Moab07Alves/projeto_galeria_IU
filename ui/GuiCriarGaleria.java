package ui;

import java.awt.Dimension;
import java.awt.Menu;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import entities.Galeria;
import entities.Usuario;

public class GuiCriarGaleria extends JFrame{
    
    private Usuario usuario;
    private JLabel lbnomGaleria;
    private JButton btCriar;
    private JButton btCancelar;
    private JTextField tfnomeGaleria;

    public GuiCriarGaleria (Usuario usuario) {
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
        GuiMenuPrincipal menu = new GuiMenuPrincipal(this.usuario);
        btCriar.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String nomeGaleria = String.valueOf(tfnomeGaleria.getText());
                if(nomeGaleria.equals(null) || nomeGaleria.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "ERRO! O nome da galeria não foi inserido\n\n\tTENTE NOVAMENTE");
                    menu.run();
                    setVisible(false);
                }else {
                    adicionarGaleriaUsuario(nomeGaleria);
                    menu.run();
                    setVisible(false);
                }
            }
        });

        btCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                menu.run();
                setVisible(false);
            }
        });
    }

    public void run () {  
        setResizable(false);        
        Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((tela.width - getSize().width) / 2, (tela.height - getSize().height) / 2);
        setLocationRelativeTo(null);
        setVisible(true);  
    }

    private void adicionarGaleriaUsuario(String nomeGaleria){
        this.usuario.criarGaleria(new Galeria(this.usuario, nomeGaleria));
    }


}
