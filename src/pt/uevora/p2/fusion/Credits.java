package pt.uevora.p2.fusion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Credits extends JFrame {
    public Credits(){
        setSize(700,170);
        setLocation(300,300);
        setResizable(false);
        setVisible(true);
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                MainWindow.main.setVisible(true);
            }
        });

        JPanel info=new JPanel();
        info.setLayout(new FlowLayout());
        JLabel worckInfo=new JLabel("Estre trabalho foi \nrealizado no ambito da disciplina \nde Programação 2 pelos alunos:");
        info.add(worckInfo);
        add(info);

        JPanel info1=new JPanel();
        info1.setLayout(new BorderLayout());
        JLabel yaroslav=new JLabel("Yaroslav Kolodiy n39859 Curso E.I");
        JLabel eduardo=new JLabel("Eduardo MEdeiros n39873 Cruso E.I");
        info1.add(yaroslav,BorderLayout.NORTH);
        info1.add(eduardo);
        info.add(info1);

    }
}
