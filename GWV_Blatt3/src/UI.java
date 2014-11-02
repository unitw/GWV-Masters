import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.ScrollPane;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

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
    TextArea textarea = new TextArea();
    Start start = null;
    JButton BBreadthSearch;
    JButton BDeepSearch;
    JButton BpreviousSearch;
    JButton BnextSearch;
    public JTextField Schritte = new JTextField();

    public UI() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
        }
    }

    public void initCmps() {
        start = new Start(this);
        buttonpanel.setLayout(new BorderLayout());

        BDeepSearch = new JButton("Deep-Search");
        BDeepSearch.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        start.DepthFirstSearch();
                    }
                });
            }
        });
        BDeepSearch.setSize(new Dimension(100, 25));

        BBreadthSearch = new JButton("Breadth-First-Search");
        BBreadthSearch.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        start.BreadthFirstSearch(0);
                    }
                });
            }
        });
        BBreadthSearch.setSize(new Dimension(100, 25));

        BpreviousSearch = new JButton("<-");
        BpreviousSearch.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        start.DepthFirstSearch();
                    }
                });
            }
        });
        BpreviousSearch.setSize(new Dimension(50, 25));

        BnextSearch = new JButton("->");
        BnextSearch.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        start.DepthFirstSearch();
                    }
                });
            }
        });
        BnextSearch.setSize(new Dimension(50, 25));

        frame = new JFrame("Search UI");
        frame.setLayout(new BorderLayout());

        buttonpanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setMinimumSize(new Dimension(500, 500));

        new RedirectText(textarea);
//        System.setOut(new PrintStreamCapturer(textarea, System.out));
//        System.setErr(new PrintStreamCapturer(textarea, System.err, "[ERROR] "));
//        textarea.setEditable(false);
        ScrollPane scroller = new ScrollPane();
        scroller.add(textarea);
        scroller.setSize(new Dimension(frame.getWidth() - 5, frame.getHeight() - 250));
        frame.getContentPane().add(scroller, BorderLayout.PAGE_START);

//        panel.add(scroller);
        gbc.insets = new Insets(10,10,20,10);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 200;
        gbc.gridwidth = 2;
        gbc.ipadx = 500;
        buttonpanel.add(Schritte, gbc);

//        gbc.gridx = 2;
//        gbc.gridy = 1;
//        gbc.fill = GridBagConstraints.NONE;
//        gbc.anchor = GridBagConstraints.WEST;
//        gbc.ipadx = 100;
//        buttonpanel.add(BpreviousSearch, gbc);
//
//        gbc.gridx = 1;
//        gbc.gridy = 1;
//        gbc.fill = GridBagConstraints.NONE;
//        gbc.anchor = GridBagConstraints.EAST;
//        gbc.ipadx = 100;
//        buttonpanel.add(BnextSearch, gbc);
        gbc.gridwidth = 1;
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 200;
        buttonpanel.add(BBreadthSearch, gbc);
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 200;
        buttonpanel.add(BDeepSearch, gbc);

        panel.setPreferredSize(new Dimension(frame.getWidth() - 10, 700));
        frame.getContentPane().add(panel, BorderLayout.NORTH);
        frame.getContentPane().add(buttonpanel, BorderLayout.SOUTH);
        frame.setVisible(true);

    }

}
