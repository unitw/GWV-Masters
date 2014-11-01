import java.awt.Color;
import java.awt.Dimension;
import java.io.PrintStream;
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

    public JFrame fsearch = new JFrame("Search UI");
    JPanel pconsole = new JPanel();
    JTextArea tconsole = new JTextArea();
    Start start = null;

    public void initCmps() {
        start = new Start();

        pconsole.add(new JScrollPane(tconsole));
        JScrollPane scroller = new JScrollPane(tconsole); //die Scrollpane
        fsearch.getContentPane().add(scroller);
        scroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        tconsole.setSize(new Dimension(500, 500));
        scroller.setSize(new Dimension(500, 500));
        
        
        PrintStream out = new PrintStream(new TextAreaOutputStream(tconsole));
        System.setOut(out);
        System.setErr(out);
        start.readStateSpace();
        fsearch.setSize(new Dimension(500, 500));
        pconsole.setSize(new Dimension(500, 500));

        pconsole.setVisible(true);
        fsearch.add(pconsole);
        fsearch.setVisible(true);

    }

}
