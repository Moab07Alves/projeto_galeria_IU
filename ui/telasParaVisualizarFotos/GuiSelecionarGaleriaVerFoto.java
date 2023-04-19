package ui.telasParaVisualizarFotos;

import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.GerenciadorUsuarios;
import entities.Galeria;
import entities.Usuario;
import ui.telasDeMenu.GuiMenuPrincipal;

public class GuiSelecionarGaleriaVerFoto extends JFrame{

//------------------------------ Entidades de Domínio ------------------------------------------
    private GerenciadorUsuarios gerenciador;
    private Usuario usuario;
    private String tituloGaleriaSelecionada;
// --------------------------------------------------------------------------------------------

    private JPanel painel;
    private JList lsGalerias;
    private DefaultListModel dlm;
    private JScrollPane sp;
    private JButton jbEscolher;
    private JButton jbVoltar;

    public GuiSelecionarGaleriaVerFoto(GerenciadorUsuarios gerenciador, Usuario usuario) throws Exception {
        this.gerenciador = gerenciador;
        this.usuario = usuario;
        incializarComponentes();
        definirEventos();
    }
    
    private void incializarComponentes() throws Exception {
        setTitle("Selecionar Galeria");
        setBounds(0, 0,450, 300);
        painel = new JPanel();
        setLayout(null);
        painel.setLayout(null);
        painel.setBounds(0, 0, 400, 300);
        dlm = new DefaultListModel<>();

        List<Galeria> galeriasDoUsuario = gerenciador.getUsuario(usuario.getLogin()).todasGalerias();

        for(int i = 0; i < galeriasDoUsuario.size(); i++) {
            dlm.addElement(galeriasDoUsuario.get(i).getTituloGaleria());
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
                tituloGaleriaSelecionada = String.valueOf(lsGalerias.getSelectedValuesList());
                String[] array = tituloGaleriaSelecionada.split("");
                tituloGaleriaSelecionada = "";
                for (String caractere: array) {
                    if (!(caractere.equals("[") || caractere.equals("]"))) {
                        tituloGaleriaSelecionada += caractere;
                    }
                }
            }
        });
        
        jbEscolher.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                //Implementar a função do botão Escolher
                try {
                    GuiSelecionarFotosVisualizar telaSelecionarFotos;
                    telaSelecionarFotos = new GuiSelecionarFotosVisualizar(gerenciador, usuario, tituloGaleriaSelecionada);
                    telaSelecionarFotos.run();
                    dispose();
                } catch (Exception x) {
                    JOptionPane.showMessageDialog(null, x.getMessage());
                }
                
            }
        });

        jbVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                //Implementar a função do botão Voltar
                GuiMenuPrincipal telaMenu = new GuiMenuPrincipal(gerenciador, usuario);
                telaMenu.run();
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

}
