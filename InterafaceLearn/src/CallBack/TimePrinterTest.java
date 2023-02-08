package CallBack;

import javax.swing.*;


public class TimePrinterTest {
    public static void main(String[] args) {
        var listener = new TimePrinter();
        Timer t = new Timer(3000, listener);
        t.start();
        JOptionPane.showMessageDialog(null, "Quit program?");

    }
}
