package ui;

import java.awt.ScrollPane;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import entities.Galeria;
import entities.Usuario;

public class GuiSelecionarGaleria extends JPanel{

    private Usuario usuario;
    private JList lsGalerias;
    private DefaultListModel dlm;
    //private ImageIcon imagem1;
    private JScrollPane sp;
    //private JLabel lbImagem;
    private JFrame janela;

    public GuiSelecionarGaleria(Usuario usuario, JFrame janela) {
        this.usuario = usuario;
        this.janela = janela;
        incializarComponentes(usuario.todaGalerias(), janela);
        definirEventos();
    }
    
    private void incializarComponentes(List<Galeria> galerias, JFrame janela) {
        int x = janela.getX();
        int y = janela.getY();
        int width = janela.getWidth();
        int height = janela.getHeight();

        setLayout(null);
        dlm = new DefaultListModel<>();
        for(int i = 0; i < galerias.size(); i++) {
            dlm.addElement(i+1 + "- " + galerias.get(i).getTituloGaleria());
        }
        lsGalerias = new JList<>(dlm);
        sp = new JScrollPane(lsGalerias);
        sp.setBounds(40, 50, 70, 150);
        //imagem1 = new ImageIcon();
        //lbImagem = new JLabel(imagem1);
        //lbImagem.setBounds(150, 30, 180,180);
        add(sp);
        //add(lbImagem);
    }

    private void definirEventos() {
        lsGalerias.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e){

            }
        });
        
    }
    
}
