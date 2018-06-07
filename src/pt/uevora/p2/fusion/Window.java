package pt.uevora.p2.fusion;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Window extends JFrame {

    private final int X_SIZE = 500;
    private final int Y_SIZE = 500;

    public Window(int numberOfRows) {
        setTitle("Welcome!");
        setSize(X_SIZE, Y_SIZE);
        setResizable(false);
        setResizable(true);

        int level = numberOfRows;

        Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(level, level));


        JButton[][] buttons = new JButton[2 * level][level];

        for (int index = level; index < 2 * level; index++) {
            for (int index2 = 0; index2 < level; index2++) {
                buttons[index][index2] = new JButton();
            }
        }
        for (int index = level; index < 2 * level; index++) {
            for (int index2 = 0; index2 < level; index2++) {
                JButton button = buttons[index][index2];
                button.setPreferredSize(new Dimension(X_SIZE / level, Y_SIZE / level));
                button.setBackground(randomColor(level));
                contentPane.add(button);
            }
        }

    }

    public static Color randomColor(int numOfColors) {

        Color color = null;

        Random random = new Random();

        int num = random.nextInt(numOfColors);

        switch (num) {
            case 0:
                color = Color.BLACK;
                break;
            case 1:
                color = Color.ORANGE;
                break;
            case 2:
                color = Color.GREEN;
                break;
            case 3:
                color = Color.BLUE;
                break;
            case 4:
                color = Color.CYAN;
                break;
            case 5:
                color = Color.DARK_GRAY;
                break;
            case 6:
                color = Color.GRAY;
                break;
            case 7:
                color = Color.LIGHT_GRAY;
                break;
            case 8:
                color = Color.MAGENTA;
                break;
            case 9:
                color = Color.PINK;
                break;
            case 10:
                color = Color.RED;
                break;
            case 11:
                color = Color.WHITE;
                break;
            default:
                color = Color.YELLOW;
                break;
        }
        return color;
    }
}