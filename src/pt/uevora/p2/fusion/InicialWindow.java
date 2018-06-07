package pt.uevora.p2.fusion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InicialWindow extends MouseAdapter implements ActionListener {

    static Window win;
    static JFrame inicialFrame;

    public static void run() {

        //Frame
        inicialFrame = new JFrame("Fusion");
        inicialFrame.setSize(400, 600);
        inicialFrame.setVisible(true);
        inicialFrame.setResizable(false);
        inicialFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Container
        Container inicialContainer = inicialFrame.getContentPane();
        inicialContainer.setLayout(new GridLayout(5, 1));
        inicialContainer.setBackground(Color.WHITE);

        //Labels
        JLabel name = new JLabel(inicialFrame.getTitle());
        JLabel devs = new JLabel("Developed by: Eduardo Medeiros and Yaroslav Kolodiy");

        name.setHorizontalAlignment(SwingConstants.CENTER);
        devs.setHorizontalAlignment(SwingConstants.CENTER);

        //Buttons
        JButton playButton = new JButton("Play");
        JButton optionsButton = new JButton("Options");
        JButton quitButton = new JButton("Quit");

        playButton.setBackground(Color.WHITE);
        playButton.setBorderPainted(false);
        playButton.addMouseListener(new InicialWindow());
        playButton.addActionListener(new InicialWindow());

        optionsButton.setBackground(Color.WHITE);
        optionsButton.setBorderPainted(false);
        optionsButton.addMouseListener(new InicialWindow());
        optionsButton.addActionListener(new InicialWindow());

        quitButton.setBackground(Color.WHITE);
        quitButton.setBorderPainted(false);
        quitButton.addMouseListener(new InicialWindow());
        quitButton.addActionListener(new InicialWindow());

        //Adding the components
        inicialContainer.add(name);
        inicialContainer.add(playButton);
        inicialContainer.add(optionsButton);
        inicialContainer.add(quitButton);
        inicialContainer.add(devs);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //Default setings
        int defaultNumberOfColors = 2;
        int defaultNumberOfRows = 5;

        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            String buttonText = button.getText();

            //Play button pressed
            if (buttonText.equalsIgnoreCase("play")) {
                win = new Window(defaultNumberOfRows, defaultNumberOfColors);
                win.setVisible(true);
                inicialFrame.dispose();

                //Options button pressed
            } else if (buttonText.equalsIgnoreCase("options")) {
                JOptionPane.showMessageDialog(null, "test");

                //Quit button pressed
            } else if (buttonText.equalsIgnoreCase("quit")) {
                System.exit(0);
            }
        }
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
}
