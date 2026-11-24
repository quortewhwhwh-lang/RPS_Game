import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ResultScreen extends JPanel implements ActionListener{
    Main main;
    GameData gameData;

    // JPanel leftScreen;
    // JPanel centerScreen;
    // JPanel rightScreen;

    JLabel scoreBoard;
    JLabel player1Won;
    JLabel player2Won;

    GameImage rockImage = new GameImage("Rock.png", 100);
    GameImage paperImage = new GameImage("Paper.png", 100);
    GameImage scissorImage = new GameImage("Scissor.png", 100);

    JLabel message;

    JButton returnToMenu;
    JButton nextRound;
    
    public ResultScreen(Main m, GameData gD){
        main = m;
        gameData = gD;
        // setLayout(new BorderLayout());
        // leftScreen = new JPanel(new BorderLayout());
        // add(leftScreen, BorderLayout.WEST);
        // centerScreen = new JPanel(new BorderLayout());
        // add(centerScreen, BorderLayout.CENTER);
        // rightScreen = new JPanel(new BorderLayout());
        // add(rightScreen, BorderLayout.EAST);
        
        setLayout(new GridLayout(3,3));

        player1Won = new JLabel(gameData.getP1Name() + " WON!");
        add(player1Won);

        scoreBoard = new JLabel("0 - 0");
        add(scoreBoard);

        player2Won = new JLabel(gameData.getP2Name() + " WON!");
        add(player2Won);

        //Placeholder
        add(rockImage);

        message = new JLabel("ROCK beats PAPER");
        add(message);

        //Placeholder
        add(paperImage);

        returnToMenu = new JButton("Return to Menu");
        returnToMenu.addActionListener(this);
        add(returnToMenu);

        nextRound = new JButton("Next Round");
        nextRound.addActionListener(this);
        add(nextRound);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == returnToMenu){
            if(JOptionPane.showConfirmDialog(this, "Return to Menu? The current game will NOT be saved.") == 0){
                resetGame();
                main.showScreen(main.MENU_SCREEN);
            }
        }
        else if(e.getSource() == nextRound){
            main.showScreen(main.MESSAGE_SCREEN);
        }
    }

    public void resetGame(){
        
    }
}




// use wait() function to add pauses