import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

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

    public JFrame frame = null;
    JPanel panel = new JPanel();
    JPanel buttonpanel = new JPanel();
    JTextArea textarea = new JTextArea();
    Start start = null;

    public void initCmps() {
        start = new Start();
        buttonpanel.setLayout(new BorderLayout());

        JButton BDeepSearch = new JButton("Deep-Search");
        BDeepSearch.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        start.DeepFirstSearch();
                    }
                });
            }
        });
        BDeepSearch.setSize(new Dimension(100, 25));

        JButton BBreadthSearch = new JButton("Breadth-First-Search");
        BBreadthSearch.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        start.BreadthFirstSearch();
                    }
                });
            }
        });
        BBreadthSearch.setSize(new Dimension(100, 25));

        frame = new JFrame("Search UI");
        frame.setLayout(new BorderLayout());

        buttonpanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setMinimumSize(new Dimension(500, 500));

        PrintStream out = new PrintStream(new TextAreaOutputStream(textarea));
        System.setOut(out);
        System.setErr(out);

        textarea.setEditable(false);

        JScrollPane scroller = new JScrollPane(textarea);
        frame.getContentPane().add(scroller, BorderLayout.CENTER);

        scroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroller.setPreferredSize(new Dimension(frame.getWidth() - 10, 700));

        panel.add(scroller);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 200;
        buttonpanel.add(BBreadthSearch, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 200;
        buttonpanel.add(BDeepSearch, gbc);

        panel.setPreferredSize(new Dimension(frame.getWidth() - 10, 700));
        frame.getContentPane().add(panel, BorderLayout.NORTH);
        frame.getContentPane().add(buttonpanel, BorderLayout.SOUTH);
        frame.setVisible(true);

    }

}
