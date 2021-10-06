package launcher;
import view.Client;
public class Start {
    public static void main(String[] args) {
        Client c = new Client();
        c.display(5);
        c.display(-5);
        c.display(50);
        c.display(55);
        c.display(-75);
        c.display(35);
    }
}
