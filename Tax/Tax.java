/**
 * This class contains the main method required for starting execution
 *
 * @author Swastik Pal
 * @version 27/03/2018
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class Tax extends JFrame {

    private static final long serialVersionUID = 4_4_18L;
    private JMenuBar menuBar;
    static JTextArea console;
    static JTextArea display;
    static JEditorPane in;
    static JButton send;
    private JLabel labelf16;
    private JLabel labelpb;
    static JCheckBox seniorcitizen;
    UI calc;
    private int i;

    //Constructor 
    public Tax() {

        this.setTitle("Tax");
        this.setSize(1600, 800);
        //menu generate method
        generateMenu();
        this.setJMenuBar(menuBar);

        //pane with null layout
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(1600, 800));
        contentPane.setBackground(new Color(255, 185, 150));


        console = new JTextArea();
        console.setBounds(100, 650, 1400, 100);
        console.setBackground(new Color(200, 200, 200));
        console.setForeground(new Color(0, 0, 0));
        console.setEnabled(true);
        console.setFont(new Font("SansSerif", 2, 12));
        console.setText("Loading...");
        console.setBorder(BorderFactory.createBevelBorder(1));
        console.setVisible(true);

        //adding console to contentPane panel
        contentPane.add(console);

        display = new JTextArea();
        display.setBounds(100, 100, 1400, 425);
        display.setBackground(new Color(255, 255, 255));
        display.setForeground(new Color(0, 0, 0));
        display.setEnabled(true);
        display.setFont(new Font("sansserif", 0, 12));
        display.setText("");
        display.setBorder(BorderFactory.createBevelBorder(1));
        display.setVisible(true);

        in = new JEditorPane();
        in.setBounds(100, 575, 1200, 50);
        in.setBackground(new Color(153, 51, 0));
        in.setForeground(new Color(0, 0, 0));
        in.setEnabled(true);
        in.setFont(new Font("sansserif", 0, 12));
        in.setText("Input data here");
        in.setBorder(BorderFactory.createBevelBorder(1));
        in.setVisible(true);

        send = new JButton();
        send.setBounds(1350, 575, 100, 50);
        send.setBackground(new Color(153, 51, 0));
        send.setForeground(new Color(0, 69, 96));
        send.setEnabled(true);
        send.setFont(new Font("SansSerif", 2, 20));
        send.setText("Enter");
        send.setVisible(true);
        send.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                enter(evt);
            }
        });

        labelf16 = new JLabel();
        labelf16.setBounds(765, 25, 90, 35);
        labelf16.setBackground(new Color(214, 217, 223));
        labelf16.setForeground(new Color(0, 0, 0));
        labelf16.setEnabled(true);
        labelf16.setFont(new Font("SansSerif", 1, 20));
        labelf16.setText("Form 16");
        labelf16.setVisible(true);

        labelpb = new JLabel();
        labelpb.setBounds(730, 50, 144, 30);
        labelpb.setBackground(new Color(214, 217, 223));
        labelpb.setForeground(new Color(0, 0, 0));
        labelpb.setEnabled(true);
        labelpb.setFont(new Font("SansSerif", 0, 18));
        labelpb.setText("Part B (Annexure)");
        labelpb.setVisible(true);

        seniorcitizen = new JCheckBox();
        seniorcitizen.setBounds(100, 535, 150, 25);
        seniorcitizen.setBackground(new Color(214, 217, 223));
        seniorcitizen.setForeground(new Color(175, 125, 0));
        seniorcitizen.setEnabled(true);
        seniorcitizen.setFont(new Font("SansSerif", 1, 16));
        seniorcitizen.setText("Senior citizen");
        seniorcitizen.setVisible(true);

        //adding components to contentPane panel
        contentPane.add(display);
        contentPane.add(in);
        contentPane.add(send);
        contentPane.add(labelf16);
        contentPane.add(labelpb);
        contentPane.add(seniorcitizen);

        //adding panel to JFrame and setting of window position and close operation
        this.add(contentPane);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);

        i = 1;
        try {
            UI.begin(i);
        } catch (Exception E) {
        }
    }

    //method for generate menu
    public void generateMenu() {
        menuBar = new JMenuBar();


        JMenuItem credits = new JMenuItem("Credits");

        //Settings action for menu item
        //Call defined method
        credits.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                credits(evt);
            }
        });


    }

    private void enter(MouseEvent evt) {
        try {
            UI.begin(++i);
        } catch (Exception E) {
            console.append("\nInput Error");
            --i;
        }
    }

    //Method for Credits from menuMenu 
    private void credits(ActionEvent evt) {
        //TODO
    }


    public static void main(String[] args) {
        System.setProperty("swing.defaultlaf", "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Tax();
            }
        });
    }

}