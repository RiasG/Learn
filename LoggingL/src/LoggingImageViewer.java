import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.*;

/**
 * 10 * Это видоизмененный вариант программы просмотра,
 * 11 * в которой регистрируются различные события
 * 12 * @version 1.03 2015-08-20
 * 13 * @author Сау Horstmann
 * 14
 */
public class LoggingImageViewer {
    public static void main(String[] args) {

        if (System.getProperty(
                "java.util.logging.config.class") == null
                && System.getProperty(
                "java.util.logging.config.file") == null) {
            try {

                Logger.getLogger("com. horstmann. corej ava")
                        .setLevel(Level.ALL);
                final int LOG_ROTATION_COUNT = 10;
                var handler = new FileHandler(
                        "%h/LoggingImageViewer.log",
                        0, LOG_ROTATION_COUNT);
                Logger.getLogger("com. horstmann. corej ava")
                        .addHandler(handler);
            } catch (IOException е) {
                Logger.getLogger("com.horstmann.corejava")
                        .log(Level.SEVERE,
                                "Can't create log file handler", е);
            }
        }

        EventQueue.invokeLater(() -> {
            Handler windowHandler = new WindowHandler();
            windowHandler.setLevel(Level.ALL);


            Logger.getLogger("com.horstmann.corejava")
                    .addHandler(windowHandler);
            JFrame frame = new ImageViewerFrame();
            frame.setTitle("LoggingImageViewer");
            frame.setDefaultCloseOperation(
                    JFrame.EXIT_ON_CLOSE);
            Logger.getLogger("com.horstmann.corejava")
                    .fine("Showing frame");
            frame.setVisible(true);
        });
    }
}


/**
 * Фрейм, в котором показывается изображение
 *
 */


class ImageViewerFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 400;
    private JLabel label;


    private static Logger logger =
            Logger.getLogger("com.horstmann.corejava");

    public ImageViewerFrame() {
        logger.entering("ImageViewerFrame", "<init>");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        // установить строку меню
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu = new JMenu("File");
        menuBar.add(menu);

        JMenuItem openItem = new JMenuItem("Open");
        menu.add(openItem);
        openItem.addActionListener(new FileOpenListener());

        JMenuItem exitItem = new JMenuItem("Exit");
        menu.add(exitItem);
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                logger.fine("Exiting.");
                System.exit(0);
            }
        });

        // использовать метку для обозначения изображений
        label = new JLabel();
        add(label);
        logger.exiting("ImageViewerFrame", "<init>");
    }

    private class FileOpenListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            logger.entering(
                    "ImageViewerFrame. FileOpenListener",
                    "actionPerformed", event);

            // установить селектор файлов
            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new File("."));

            // принять все файлы с расширением .gif
            chooser.setFileFilter(new javax.swing.filechooser.FileFilter() {

                public boolean accept(File f) {
                    return f.getName().toLowerCase()
                            .endsWith(".jpeg") || f.isDirectory();

                }

                public String getDescription() {
                    return "GIF Images";
                }
            });

            // показать диалоговое окно селектора файлов
            int r = chooser.showOpenDialog(
                    ImageViewerFrame.this);

            // если файл изображения подходит, выбрать
            // его в качестве пиктограммы для метки
            if (r == JFileChooser.APPROVE_OPTION) {
                String name = chooser.getSelectedFile()
                        .getPath();
                logger.log(Level.FINE, "Reading file {0}", name);
                label.setIcon(new ImageIcon(name));
            } else logger.fine("File open dialog canceled.");
            logger.exiting("ImageViewerFrame.FileOpenListener", "actionPerformed");
        }
    }
}

/**
 * 159 * Обработчик для отображения протокольных
 * 160 * записей в окне
 * 161
 */
class WindowHandler extends StreamHandler {

    private JFrame frame;

    public WindowHandler() {
        frame = new JFrame();

        final JTextArea output = new JTextArea();
        output.setEditable(false);
        frame.setSize(200, 200);
        frame.add(new JScrollPane(output));
        frame.setFocusableWindowState(false);
        frame.setVisible(true);

        setOutputStream(new OutputStream() {
            public void write(int b) {
            } // не вызывается!

            public void write(byte[] b, int off, int len) {
                output.append(new String(b, off, len));
            }
        });
    }

    public void publish(LogRecord record) {
        if (!frame.isVisible()) return;
        super.publish(record);
        flush();
    }
}
