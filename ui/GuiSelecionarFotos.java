package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import entities.Foto;
import entities.Galeria;
import entities.Usuario;

public class GuiSelecionarFotos extends JFrame{
    
    private JPanel telaFotos; 
    private JList lsFotos;
    private DefaultListModel dlm;
    private ImageIcon imagem1;
    private JScrollPane sp;
    private JLabel lbImagem;
    private Galeria galeria;
    private JButton jbabir;
    private JButton jbVoltar;

    public GuiSelecionarFotos(Galeria galeria) {
        this.galeria = galeria;
        incializarComponentes(galeria);
        definirEventos();
    }
    
    private void incializarComponentes(Galeria galeria) {
        setTitle("Fotos da Galeria: " + galeria.getTituloGaleria());
        setBounds(0, 0, 600, 315);
        telaFotos = new JPanel();
        telaFotos.setLayout(null);
        dlm = new DefaultListModel();
        galeria.getFotos().size();
        for(int i = 0; i < galeria.getFotos().size(); i++) {
            dlm.addElement(galeria.getFotos().get(i).getDescricao());
        }
        lsFotos = new JList(dlm);
        sp = new JScrollPane(lsFotos);
        sp.setBounds(10, 20, 200, getHeight() - 75);
        imagem1 = new ImageIcon();
        lbImagem = new JLabel(imagem1);
        lbImagem.setBounds(300, 30, 200,200);
        jbabir = new JButton("Abrir foto");
        jbabir.setBounds(350, 245, 100, 25);
        jbabir.setVisible(false);
        jbabir.setBounds(420, 245, 100, 25);
        jbVoltar = new JButton("Voltar");
        jbVoltar.setBounds(280, 245, 100, 25);
        telaFotos.add(jbabir);
        telaFotos.add(sp);
        telaFotos.add(lbImagem);
        telaFotos.add(jbVoltar);
        add(telaFotos);
    }

    private void definirEventos() {
        lsFotos.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                imagem1 = new ImageIcon();//passar caminho da foto
                lbImagem.setIcon(imagem1);
                jbabir.setVisible(true);

            }
        });

        jbabir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               //implementar função do botão abrir
            }
        });  

        jbVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //implementar função do botão voltar
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