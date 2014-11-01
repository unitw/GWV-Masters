import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.io.PrintStream;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rw
 */
public class UI extends JFrame {

    public JFrame fsearch = null;
    JPanel pconsole = new JPanel();
    JTextArea tconsole = new JTextArea();
    Start start = null;

    public void initCmps() {
        start = new Start();

        JButton BSearch= new JButton("Search");
        BSearch.addActionListener((ActionEvent e) -> {
            start.readStateSpace();
        });
        BSearch.setSize(new Dimension(100,25));
        
      
        fsearch = new JFrame("Search UI");
        fsearch.setLayout(new BorderLayout());
        fsearch.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fsearch.setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
        fsearch.setExtendedState(JFrame.MAXIMIZED_BOTH);
        fsearch.setMinimumSize(new Dimension(500, 500));
        
        
        tconsole.setEditable(false);
        pconsole.add(new JScrollPane(tconsole));
        

        tconsole.setSize(new Dimension(500, 500));
        
        
        PrintStream out = new PrintStream(new TextAreaOutputStream(tconsole));
        System.setOut(out);
        System.setErr(out);
      
        
       
        
        
        fsearch.getContentPane().add(pconsole,BorderLayout.NORTH);
        fsearch.getContentPane().add(BSearch,BorderLayout.SOUTH);
        fsearch.setVisible(true);

    }

}
