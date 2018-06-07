package pt.uevora.p2.fusion;

public class Jogo {

    static Window win;

    public Jogo(int numberOfRows,int numberOfColors,int size){
        win = new Window(numberOfRows,numberOfColors,size);
        win.setVisible(true);

    }
}
