package ui;

import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import entities.Galeria;
import entities.Usuario;

public class GuiSelecionarGaleria extends JFrame{

    private Galeria galeriaSelecionada;
    private JPanel painel;
    private Usuario usuario;
    private JList lsGalerias;
    private DefaultListModel dlm;
    private JScrollPane sp;
    private JButton jbEscolher;
    private JButton jbVoltar;

    public GuiSelecionarGaleria(Usuario usuario) {
        this.usuario = usuario;
        incializarComponentes(usuario.todaGalerias());
        definirEventos();
    }
    
    private void incializarComponentes(List<Galeria> galerias) {
        setTitle("Selecionar Galeria");
        setBounds(0, 0,450, 300);
        painel = new JPanel();
        setLayout(null);
        painel.setLayout(null);
        painel.setBounds(0, 0, 400, 300);
        dlm = new DefaultListModel<>();
        for(int i = 0; i < galerias.size(); i++) {
            dlm.addElement(i+1 + "- " + galerias.get(i).getTituloGaleria());
        }
        lsGalerias = new JList<>(dlm);
        sp = new JScrollPane(lsGalerias);
        sp.setBounds(30, 10, 500, 200);
        jbEscolher = new JButton("Escolher");
        jbEscolher.setBounds(250, 220, 100, 25);
        jbVoltar = new JButton("Voltar");
        jbVoltar.setBounds(75, 220, 100, 25);
        painel.add(sp);
        painel.add(jbEscolher);
        painel.add(jbVoltar);
        add(painel);
    }

    private void definirEventos() {
        lsGalerias.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e){
                String nomeGaleria = "" + lsGalerias.getSelectedValuesList();
                galeriaSelecionada = usuario.procurarGaleriaPorTitulo(nomeGaleria);
            }
        });
        
        jbEscolher.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null, "A galeria escolhida foi " + galeriaSelecionada.getTituloGaleria());
            }
        });

        jbVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                GuiMenuPrincipal menu = new GuiMenuPrincipal(usuario);
                menu.run();
                dispose();
            }
        });
    }
    
    public void run() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);  
    }

    public Galeria galeriaEscolhida() {
        return this.galeriaSelecionada;
    }

}
