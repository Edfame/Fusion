package pt.uevora.p2.fusion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainWindow extends JPanel {

    private JLabel error;
    static JFrame main;

    public MainWindow() {
        final int[] numberOfRows = new int[1];

        setLayout(new FlowLayout());

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new FlowLayout());
        JLabel howManyRows = new JLabel("How many rows? ");
        northPanel.add(howManyRows);

        JTextField rows = new JTextField(15);
        northPanel.add(rows);

        add(northPanel);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new FlowLayout());
        JLabel howManyColors = new JLabel("How many Colors:");
        centerPanel.add(howManyColors);

        JTextField colors = new JTextField(15);
        centerPanel.add(colors);

        add(centerPanel);

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new FlowLayout());
        JLabel sizeText = new JLabel("What is the size:");
        southPanel.add(sizeText);

        JTextField size = new JTextField(15);
        southPanel.add(size);

        add(southPanel);

        JPanel errorPanel = new JPanel();
        errorPanel.setLayout(new FlowLayout());
        error=new JLabel("");
        error.setForeground(Color.RED);
        errorPanel.add(error);
        add(errorPanel);

        JButton submit = new JButton();
        submit.setSize(new Dimension(100, 100));
        submit.setText("SUBMIT");
        submit.setBackground(Color.blue);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (Integer.parseInt(colors.getText())>9){
                        throw new ArithmeticException("Number of Color is invalid need to be less than 9");
                    }
                    Jogo jogo = new Jogo(Integer.parseInt(rows.getText()), Integer.parseInt(colors.getText()), Integer.parseInt(size.getText()));
                    main.setVisible(false);
                }catch (java.lang.NumberFormatException e){
                    writeError("(invalid input)");
                }catch (java.lang.ArithmeticException e){
                    writeError(e.getMessage());
                }
            }
        });
        add(submit);

        JButton clean=new JButton();
        clean.setBackground(Color.MAGENTA);
        clean.setText("Clear");
        clean.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                rows.setText("");
                colors.setText("");
                size.setText("");
            }
        });
        add(clean);

        JButton credits=new JButton();
        credits.setText("Credits");
        credits.setBackground(Color.ORANGE);
        credits.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Credits win=new Credits();
                main.setVisible(false);
            }
        });
        add(credits);
    }

    public void writeError(String text){
        this.error.setText(text);
    }

    public static void main(String[] args) {
        main = new JFrame();
        main.setSize(400, 200);
        main.setTitle("FUSION");
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.add(new MainWindow());
        main.setResizable(false);
        main.setLocation(300, 300);
        main.setVisible(true);

    }
}
