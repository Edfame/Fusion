package pt.uevora.p2.fusion;

import javax.swing.*;
import java.awt.*;

public class Jogo {

    public static void main(String[] args) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenY = (int) screenSize.getHeight();
        int screenX = (int) screenSize.getWidth();

        Window win=new Window(4);
        win.setVisible(true);

    }
}
