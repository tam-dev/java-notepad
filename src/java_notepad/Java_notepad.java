package java_notepad;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author tam
 */
public class Java_notepad extends JFrame {

    JTextArea mainarea;
    JMenuBar mbar;
    JMenu mnuFile, mnuEdit, mnuFormat, mnuHelp;
    JMenuItem itmNew, itmOpen, itmSave;

    public Java_notepad() {
        initComponent();
        itmSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               save();
            }
        });
    }

    private void initComponent() {
        mainarea = new JTextArea();
        getContentPane().add(mainarea);
        getContentPane().add(new JScrollPane(mainarea), BorderLayout.CENTER);
        setTitle("Untitled Notepad");
        setSize(800, 600);

        // menu bar
        mbar = new JMenuBar();

        // menu
        mnuFile = new JMenu("File");
        mnuEdit = new JMenu("Edit");
        mnuFormat = new JMenu("Format");
        mnuHelp = new JMenu("Help");

        // add icon to menu item
        ImageIcon newIcon = new ImageIcon(getClass().getResource("/img/new.gif"));
        ImageIcon newOpen = new ImageIcon(getClass().getResource("/img/open.gif"));
        ImageIcon newSave = new ImageIcon(getClass().getResource("/img/save.gif"));

        // adding shortcut
//        itmNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
//        itmOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
//        itmSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));

        // menu item
        itmNew = new JMenuItem("New", newIcon);
        itmOpen = new JMenuItem("Open", newOpen);
        itmSave = new JMenuItem("Save", newSave);

        // add menu item
        mnuFile.add(itmNew);
        mnuFile.add(itmOpen);
        mnuFile.add(itmSave);

        // add menu item to menu bar
        mbar.add(mnuFile);
        mbar.add(mnuEdit);
        mbar.add(mnuFormat);
        mbar.add(mnuHelp);

        // add menu bar to frame
        setJMenuBar(mbar);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Save 
    private void save() {
        PrintWriter fout = null;
        try {
            fout = new PrintWriter(new FileWriter("text.txt"));
            String s = mainarea.getText();
            StringTokenizer st = new StringTokenizer(s, System.getProperty("line.separator"));
            while (st.hasMoreElements()) {
                fout.println(st.nextToken());

            }
        } catch (IOException e) {
        } finally {
            fout.close();
        }
        JOptionPane.showMessageDialog(rootPane, "File saved~");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Java_notepad in = new Java_notepad();
    }

}
