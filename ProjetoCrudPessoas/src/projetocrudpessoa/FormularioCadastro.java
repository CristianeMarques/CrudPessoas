package projetocrudpessoa;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

/**
 *
 * 
 */
public class FormularioCadastro {

    protected JButton botaoOk, botaoCancel;
    
    public static final int INCLUI = 1;
    public static final int ATUALIZA = 2;
    
    protected JTextField nome = new JTextField(10);
    protected JTextField idade = new JTextField(10);
    
    public FormularioCadastro(final JFrame telaPrincipal, final Pessoa pessoa, final DefaultListModel listModel, final int modo) {
        //Create and populate the panel.
        JPanel p = new JPanel(new SpringLayout());
        JLabel l = new JLabel("Nome: ", JLabel.TRAILING);
        p.add(l);
        l.setLabelFor(nome);
        nome.setText(pessoa.getNome());
        p.add(nome);
        
        l = new JLabel("Idade: ", JLabel.TRAILING);
        p.add(l);
        l.setLabelFor(idade);
        idade.setText(pessoa.getIdade());
        p.add(idade);

        //Lay out the panel.
        SpringUtilities.makeCompactGrid(p,
                                        2, 2, //rows, cols
                                        6, 6,        //initX, initY
                                        6, 6);       //xPad, yPad

        //Create and set up the window.
        final JFrame frame = new JFrame("Formulario de Cadastro");
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Set up the content pane.
        p.setOpaque(true);  //content panes must be opaque
        
        frame.getContentPane().add(p);
        
        botaoOk = new JButton("Ok");
        botaoCancel = new JButton("Cancelar");
        
        botaoOk.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent ae) {
                 if (modo == INCLUI) {
                     listModel.addElement(new Pessoa(nome.getText(), idade.getText()));
                 } else { // modo == ATUALIZA
                     pessoa.setNome(nome.getText());
                     pessoa.setIdade(idade.getText());
                 }
                 frame.dispose();
                 telaPrincipal.setVisible(true);
             }
        });
        
        botaoCancel.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent ae) {
                 frame.dispose();
                 telaPrincipal.setVisible(true);
             }
        });
        
        JPanel painelBotoes = new JPanel();
        painelBotoes.add(botaoOk);
        painelBotoes.add(botaoCancel);
        frame.getContentPane().add(painelBotoes, BorderLayout.SOUTH);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
}
