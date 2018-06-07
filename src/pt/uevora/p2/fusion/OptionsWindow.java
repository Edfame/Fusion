package pt.uevora.p2.fusion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OptionsWindow extends JFrame implements MouseListener {

    private JLabel error;

    public OptionsWindow() {
        setTitle("Options");
        setSize(400, 200);
        setResizable(false);
        setLocationRelativeTo(null);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                InicialWindow.run();
                dispose();
            }
        });

        Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(4, 3));
        contentPane.setBackground(Color.WHITE);

        JLabel howManyRows = new JLabel("How many rows? ");
        JLabel howManyColors = new JLabel("How many Colors:");
        JLabel sizeText = new JLabel("What is the size:");
        JLabel emptyLabel = new JLabel("");
        error = new JLabel("");

        howManyRows.setHorizontalAlignment(SwingConstants.CENTER);
        howManyColors.setHorizontalAlignment(SwingConstants.CENTER);
        sizeText.setHorizontalAlignment(SwingConstants.CENTER);
        error.setHorizontalAlignment(SwingConstants.CENTER);
        error.setForeground(Color.RED);

        JTextField rows = new JTextField(15);
        JTextField colors = new JTextField(15);
        JTextField size = new JTextField(15);

        JButton submit = new JButton();
        submit.setBorderPainted(false);
        submit.setText("SUBMIT");
        submit.setBackground(Color.WHITE);
        submit.addMouseListener(this);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (Integer.parseInt(colors.getText()) > 9) {
                        throw new ArithmeticException("Number of Color is invalid need to be less than 9");
                    }
                    InicialWindow.win = new Window(Integer.parseInt(rows.getText()), Integer.parseInt(colors.getText()), Integer.parseInt(size.getText()));
                    InicialWindow.win.setVisible(true);
                    dispose();
                } catch (java.lang.NumberFormatException e) {
                    writeError("(invalid input)");
                } catch (java.lang.ArithmeticException e) {
                    writeError(e.getMessage());
                }
            }
        });

        JButton clear = new JButton();
        clear.setBorderPainted(false);
        clear.setText("Clear");
        clear.setBackground(Color.WHITE);
        clear.addMouseListener(this);
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                rows.setText("");
                colors.setText("");
                size.setText("");
            }
        });

        JButton credits = new JButton();
        credits.setBorderPainted(false);
        credits.setText("Credits");
        credits.setBackground(Color.WHITE);
        credits.addMouseListener(this);
        credits.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Credits win = new Credits();
                dispose();
            }
        });

        JButton back = new JButton();
        back.setBorderPainted(false);
        back.setText("Back");
        back.setBackground(Color.WHITE);
        back.addMouseListener(this);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                InicialWindow.run();
                dispose();
            }
        });

        contentPane.add(howManyRows);
        contentPane.add(rows);
        contentPane.add(submit);
        contentPane.add(howManyColors);
        contentPane.add(colors);
        contentPane.add(clear);
        contentPane.add(sizeText);
        contentPane.add(size);
        contentPane.add(credits);
        contentPane.add(emptyLabel);
        contentPane.add(error);
        contentPane.add(back);


    }

    public void writeError(String text) {
        this.error.setText(text);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton buttonEntered = (JButton) e.getSource();
            buttonEntered.setBackground(Color.LIGHT_GRAY);
        }

    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton buttonEntered = (JButton) e.getSource();
            buttonEntered.setBackground(Color.WHITE);
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }


}
