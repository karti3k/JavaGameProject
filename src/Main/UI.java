package Main;

import javax.swing.*;
import java.awt.*;

public class UI {
    GameManager gm;
    JFrame window;
    public JTextArea messageText;
    public JPanel bgPanel[] = new JPanel[10];
    public JLabel bgLabel[] = new JLabel[10];

    public UI(GameManager gm)
    {
        this.gm = gm;
        createMainField();
        generateScreen();
        window.setVisible(true);
    }

    public void createMainField()
    {
        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);
        window.setLayout(null);

        messageText = new JTextArea("THIS IS A SAMPLE TEXT");
        messageText.setBounds(50, 410, 700, 150);
        messageText.setBackground(Color.BLACK);
        messageText.setForeground(Color.WHITE);
        messageText.setEditable(false);
        messageText.setLineWrap(true);
        messageText.setWrapStyleWord(true);
        messageText.setFont(new Font("Book Antique", Font.PLAIN, 26));
        window.add(messageText);
    }
    public void createBackground(int bgNum, String bgFileName)
    {
        bgPanel[bgNum] = new JPanel();
        bgPanel[bgNum].setBounds(50, 50, 700, 350);
        bgPanel[bgNum].setBackground(Color.BLACK);
        bgPanel[bgNum].setLayout(null);
        window.add(bgPanel[1]);

        bgLabel[bgNum] = new JLabel();
        bgLabel[bgNum].setBounds(0, 0, 700, 350);

        ImageIcon bgIcon = new ImageIcon(getClass().getResource(bgFileName));
        bgLabel[bgNum].setIcon(bgIcon);
    }
    public void createObject(int bgNum, int objx, int objy, int objWidth, int objHeight, String objFileName){
        JLabel objectLabel = new JLabel();
//        objectLabel.setBounds(400, 150, 200, 200);
        objectLabel.setBounds(objx, objy, objWidth, objHeight);
        ImageIcon objectIcon = new ImageIcon(getClass().getResource(objFileName));
        objectLabel.setIcon(objectIcon);

        bgPanel[bgNum].add(objectLabel);
        bgPanel[bgNum].add(bgLabel[bgNum]);
    }

    public void generateScreen(){
        //SCREEN1
        createBackground(1, "/firstScene3.png");
        createObject(1,440,150,200,200,"/hut2.png");
        createObject(1,310,280,70,70,"/chest.png");
        createObject(1,70,180,150,150,"/guard.png");
    }
}
