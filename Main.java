import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame implements ActionListener{
    public static void main(String[] args) {
        new Main();
    }

    public final int MENU_SCREEN = 0;
    public final int CHOOSE_NAME_SCREEN = 1;
    public final int RPS_SELECT_SCREEN = 2;
    public final int MESSAGE_SCREEN = 3;
    public final int RESULT_SCREEN = 4;

    GameData gameData = new GameData();

    MenuScreen menuScreen = new MenuScreen(this);
    MessageScreen messageScreen = new MessageScreen(this, gameData);
    RPSSelectScreen rpsSelectScreen = new RPSSelectScreen(this, gameData, messageScreen);
    ResultScreen resultScreen = new ResultScreen(this, gameData);
    ChooseNameScreen chooseNameScreen = new ChooseNameScreen(this, gameData, rpsSelectScreen);

    public Main(){
        setTitle("RPS GAME 2.0");
        setLayout(new FlowLayout());

        menuScreen.setVisible(false);
        add(menuScreen);
        chooseNameScreen.setVisible(false);
        add(chooseNameScreen);
        rpsSelectScreen.setVisible(false);
        add(rpsSelectScreen);
        messageScreen.setVisible(false);
        add(messageScreen);
        resultScreen.setVisible(false);
        add(resultScreen);

        showScreen(MENU_SCREEN);

        setBounds(500, 0, 1200, 960);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void showScreen(int screen){
        menuScreen.setVisible(false);
        chooseNameScreen.setVisible(false);
        rpsSelectScreen.setVisible(false);
        messageScreen.setVisible(false);
        resultScreen.setVisible(false);
        switch(screen){
            case MENU_SCREEN -> menuScreen.setVisible(true);
            case CHOOSE_NAME_SCREEN -> chooseNameScreen.setVisible(true);
            case RPS_SELECT_SCREEN -> rpsSelectScreen.setVisible(true);
            case MESSAGE_SCREEN -> messageScreen.setVisible(true);
            case RESULT_SCREEN -> resultScreen.setVisible(true);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e){

    }
}