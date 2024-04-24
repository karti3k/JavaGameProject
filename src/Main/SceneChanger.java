package Main;

public class SceneChanger {
    GameManager gm;

    public SceneChanger(GameManager gm) {

        this.gm = gm;
    }

    public void showSceen1() {

        gm.ui.bgPanel[1].setVisible(true);
        gm.ui.bgPanel[2].setVisible(false);
        gm.ui.messageText.setText("Let's defeat the Demon Lord and save the world!");
    }

    public void showSceen2() {

        gm.ui.bgPanel[1].setVisible(false);
        gm.ui.bgPanel[2].setVisible(true);
        gm.ui.messageText.setText("");
    }
}