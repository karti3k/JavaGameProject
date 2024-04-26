package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class UI {
    GameManager gm;
    JFrame window;
    public JTextArea messageText;
    public JPanel bgPanel[] = new JPanel[10];
    public JLabel bgLabel[] = new JLabel[10];

    // PLAYER UI
    JPanel lifePanel;
    JLabel lifeLabel[] = new JLabel[6];
    JPanel inventoryPanel;
    public JLabel swordLabel, shieldLabel, lanternLabel;

    // GAME OVER UI
    public JLabel titleLabel;
    public JButton restartButton;

    public UI(GameManager gm)
    {
        this.gm = gm;
        createMainField();
        createPlayerField();
        createGameOverField();
        generateScene();
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
        bgPanel[bgNum].setVisible(false);
        window.add(bgPanel[bgNum]);

        bgLabel[bgNum] = new JLabel();
        bgLabel[bgNum].setBounds(0, 0, 700, 350);

        ImageIcon bgIcon = new ImageIcon(getClass().getResource(bgFileName));
        bgLabel[bgNum].setIcon(bgIcon);
    }
    public void createObject(int bgNum, int objx, int objy, int objWidth, int objHeight, String objFileName, String choice1Name, String choice2Name, String choice3Name, String choice1Command, String choice2Command, String choice3Command){
        //creating pop menu
        JPopupMenu popMenu = new JPopupMenu();
        JMenuItem menuItem[] = new JMenuItem[4];

        //creating pop menu items
        menuItem[1] = new JMenuItem(choice1Name);
        menuItem[1].addActionListener(gm.aHandler);
        menuItem[1].setActionCommand(choice1Command);
        popMenu.add(menuItem[1]);

        menuItem[2] = new JMenuItem(choice2Name);
        menuItem[2].addActionListener(gm.aHandler);
        menuItem[2].setActionCommand(choice2Command);
        popMenu.add(menuItem[2]);

        menuItem[3] = new JMenuItem(choice3Name);
        menuItem[3].addActionListener(gm.aHandler);
        menuItem[3].setActionCommand(choice3Command);
        popMenu.add(menuItem[3]);

        JLabel objectLabel = new JLabel();
//        objectLabel.setBounds(400, 150, 200, 200);
        objectLabel.setBounds(objx, objy, objWidth, objHeight);
        ImageIcon objectIcon = new ImageIcon(getClass().getResource(objFileName));
        objectLabel.setIcon(objectIcon);

        objectLabel.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {

            }
            public void mousePressed(MouseEvent e) {
                if(SwingUtilities.isRightMouseButton(e))
                {
                    popMenu.show(objectLabel, e.getX(), e.getY());
                }
            }
            public void mouseReleased(MouseEvent e) {

            }
            public void mouseEntered(MouseEvent e) {

            }
            public void mouseExited(MouseEvent e) {

            }
        });
        bgPanel[bgNum].add(objectLabel);

    }
    public void createArrowButton(int bgNum, int x, int y, int width, int height, String arrowFileName, String command) {
        ImageIcon arrowIcon = new ImageIcon(getClass().getResource(arrowFileName));

        JButton arrowButton = new JButton();
        arrowButton.setBounds(x, y, width, height);
        arrowButton.setBackground(null);
        arrowButton.setContentAreaFilled(false);
        arrowButton.setFocusPainted(false);
        arrowButton.setIcon(arrowIcon);
        arrowButton.addActionListener(gm.aHandler);
        arrowButton.setActionCommand(command);
        arrowButton.setBorderPainted(false);

        bgPanel[bgNum].add(arrowButton);
    }
    public void createPlayerField() {

        lifePanel = new JPanel();
        lifePanel.setBounds(50, 0, 250, 50);
        lifePanel.setBackground(Color.black);
        lifePanel.setLayout(new GridLayout(1, 5));
        window.add(lifePanel);

        ImageIcon lifeIcon = new ImageIcon(getClass().getResource("/heart.png"));
        Image image = lifeIcon.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT);
        lifeIcon = new ImageIcon(image);

        int i=1;
        while(i<6) {
            lifeLabel[i] = new JLabel();
            lifeLabel[i].setIcon(lifeIcon);
            lifePanel.add(lifeLabel[i]);
            i++;
        }
        inventoryPanel = new JPanel();
        inventoryPanel.setBounds(650,0,100,50);
        inventoryPanel.setBackground(Color.black);
        inventoryPanel.setLayout(new GridLayout(1,3));
        window.add(inventoryPanel);

        // CREATE  ITEMS
        swordLabel = new JLabel();
        ImageIcon swordIcon = new ImageIcon(getClass().getResource("/sword.png"));
        image = swordIcon.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT);
        swordIcon = new ImageIcon(image);
        swordLabel.setIcon(swordIcon);
        inventoryPanel.add(swordLabel);

        shieldLabel = new JLabel();
        ImageIcon shieldIcon = new ImageIcon(getClass().getResource("/shield2.png"));
        image = shieldIcon.getImage().getScaledInstance(28, 28, Image.SCALE_DEFAULT);
        shieldIcon = new ImageIcon(image);
        shieldLabel.setIcon(shieldIcon);
        inventoryPanel.add(shieldLabel);

        lanternLabel = new JLabel();
        ImageIcon lanternIcon = new ImageIcon(getClass().getResource("/lamp.png"));
        image = lanternIcon.getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT);
        lanternIcon = new ImageIcon(image);
        lanternLabel.setIcon(lanternIcon);
        inventoryPanel.add(lanternLabel);
    }
    public void createGameOverField() {

        titleLabel = new JLabel("",JLabel.CENTER);
        titleLabel.setBounds(200,150,400,200);
        titleLabel.setForeground(Color.red);
        titleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 70));
        titleLabel.setVisible(false);
        window.add(titleLabel);

        restartButton = new JButton();
        restartButton.setBounds(340,320,120,50);
        restartButton.setBorder(null);
        restartButton.setBackground(null);
        restartButton.setForeground(Color.white);
        restartButton.setFocusPainted(false);
        restartButton.addActionListener(gm.aHandler);
        restartButton.setActionCommand("restart");
        restartButton.setVisible(false);
        window.add(restartButton);
    }
    public void generateScene(){
        //SCENE1
        createBackground(1, "/firstScene3.png");
        createObject(1,440,150,200,200,"/hut2.png", "Look", "Talk", "Rest", "lookHut", "talkHut", "restHut");
        createObject(1,310,280,70,70,"/chest.png", "Look", "Talk", "Open", "lookChest", "talkChest", "openChest");
        createObject(1,70,180,150,150,"/guard.png", "Look", "Talk", "Attack", "lookGuard", "talkGuard", "attackGuard");
        createArrowButton(1,5,150,50,50,"/arrowleft.png","goScene2");
        bgPanel[1].add(bgLabel[1]);

        //SCENE2
        createBackground(2,"/secondScene.jpg");
        createObject(2,0,100,100,300,"/blank.png", "Look", "Talk", "Enter", "lookCave", "talkCave", "enterCave");
        createObject(2,355,250,50,50,"/blank.png", "Look", "Talk", "Search", "lookRoot", "talkRoot", "searchRoot");
        createArrowButton(2,650,150,50,50,"/arrowright.png","goScene1");
        bgPanel[2].add(bgLabel[2]);

        // SCENE 3
        createBackground(3,"/finalScene.png");
        createArrowButton(3,650,150,50,50,"/arrowright.png","goScene2");
        bgPanel[3].add(bgLabel[3]);
    }
}
