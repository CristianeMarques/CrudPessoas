package projetocrudpessoa;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

/**
 *
 * @author lhries
 */
public class TelaPrincipal {
    
    public TelaPrincipal() {
        final DefaultListModel listModel = new DefaultListModel();
        
        listModel.addElement(new Pessoa("Cristiane","24"));
        listModel.addElement(new Pessoa("Diego","33"));
        listModel.addElement(new Pessoa("Laura","17"));
        listModel.addElement(new Pessoa("Carolina","32"));
        
        final JList listaPessoas = new JList(listModel);
        listaPessoas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        final JFrame frame = new JFrame("Tela Principal");
        frame.getContentPane().add(listaPessoas);
        
        JPanel painelBotoes = new JPanel();
        JButton botaoNovo, botaoEditar, botaoRemover;
        
        botaoNovo = new JButton("Novo");
        
        // classes anonimas
        // para evitar criar uma classe somente com um método
        botaoNovo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.setVisible(false);
                new FormularioCadastro(frame, new Pessoa("",""), listModel, FormularioCadastro.INCLUI);
            }
        });
        
        painelBotoes.add(botaoNovo);
        botaoEditar = new JButton("Editar");
        
        botaoEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int index = listaPessoas.getSelectedIndex();
                Pessoa pessoa = (Pessoa) listModel.get(index);     
                frame.setVisible(false);
                new FormularioCadastro(frame, pessoa, listModel, FormularioCadastro.ATUALIZA);
            }
        });
        
        painelBotoes.add(botaoEditar);
        botaoRemover = new JButton("Remover");
        botaoRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = listaPessoas.getSelectedIndex();
                listModel.remove(index);
            }
        });

        painelBotoes.add(botaoRemover);
        
        frame.getContentPane().add(painelBotoes,BorderLayout.SOUTH);
        
        frame.setSize(300,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);        
    }
}
