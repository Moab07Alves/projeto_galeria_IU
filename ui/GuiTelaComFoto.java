package ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.channels.Pipe;

import javax.swing.*;

import entities.Galeria;

public class GuiTelaComFoto extends JFrame{
    
    private Galeria galeria;
    private JPanel painel;
    private JLabel lbDescricao;
    private JLabel lbData;
    private JLabel lbimagem;
    private ImagemIcon imagem;
    private JButton jbvoltar;

    public GuiTelaComFoto(Galeria galeria, String descricao, String data, String caminhaFoto) {
        this.galeria = galeria;
        inicializarComponentes(descricao, data, caminhaFoto);
        definirEventos();
    }

    public void inicializarComponentes(String descricao, String data, String caminhoFoto) {
        setBounds(0, 0, 800, 600);
        setLayout(null);
        painel = new JPanel();
        painel.setLayout(null);
        painel.setBounds(0, 0, 800, 600);
        lbDescricao = new JLabel("Descrição: " + descricao);
        lbDescricao.setBounds(10, 5, 600, 100);
        lbDescricao.setFont(new Font("Arial", Font.BOLD, 15));
        lbData = new JLabel("Data: " + data);
        lbData.setBounds(10, 20, 300, 100);
        lbData.setFont(new Font("Arial", Font.BOLD, 15));
        jbvoltar = new JButton("Voltar");
        jbvoltar.setBounds(325, 525, 100, 25);
        painel.add(jbvoltar);
        painel.add(lbDescricao);
        painel.add(lbData);
        add(painel);
    }

    public void definirEventos() {
        jbvoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GuiSelecionarFotos tSelecionarFotos = new GuiSelecionarFotos(galeria);
                tSelecionarFotos.run();
                dispose();
            }
        });
    }

    public void run() {
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }

}
