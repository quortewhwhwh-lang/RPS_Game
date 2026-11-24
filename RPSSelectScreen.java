import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RPSSelectScreen extends JPanel implements ActionListener{
    Main main;
    GameData gameData;
    MessageScreen messageScreen;
    ChooseNameScreen chooseNameScreen;
    GridBagConstraints gbc = new GridBagConstraints();

    //add this to display the current round;
    JLabel roundText;

    JLabel title;
    JLabel instructions;
    JButton rockButton;
    JButton paperButton;
    JButton scissorButton;

    //This code is repeated in ResultScreen class
    //Try to group this
    GameImage rockImage = new GameImage("Rock.png", 100);
    GameImage paperImage = new GameImage("Paper.png", 100);
    GameImage scissorImage = new GameImage("Scissor.png", 100);


    public RPSSelectScreen(Main m, GameData gd, MessageScreen mS){
        main = m;
        messageScreen = mS;
        gameData = gd;
        setLayout(new GridBagLayout());

        title = new JLabel();
        title.setFont(new Font("Monospaced", Font.BOLD, 48));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        add(title, gbc);

        instructions = new JLabel("Pick One");
        instructions.setFont(new Font("Monospaced", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        add(instructions, gbc);

        Font rpsFont = new Font("Arial", Font.BOLD, 48);
        rockButton = new JButton("ROCK");
        rockButton.setFont(rpsFont);
        rockButton.setForeground(Color.BLACK);
        rockButton.setBackground(new Color(255, 100, 100));
        rockButton.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        add(rockButton, gbc);

        paperButton = new JButton("PAPER");
        paperButton.setFont(rpsFont);
        paperButton.setForeground(Color.black);
        paperButton.setBackground(new Color(100, 100, 255));
        paperButton.addActionListener(this);
        gbc.gridx = 1;
        add(paperButton, gbc);

        scissorButton = new JButton("SCISSORS");
        scissorButton.setFont(rpsFont);
        scissorButton.setForeground(Color.black);
        scissorButton.setBackground(new Color(100, 255, 100));
        scissorButton.addActionListener(this);
        gbc.gridx = 2;
        add(scissorButton, gbc);

        gbc.gridy = 3;
        gbc.gridx = 0;     
        add(rockImage, gbc);
        gbc.gridx = 1;
        add(paperImage, gbc);
        gbc.gridx = 2;
        add(scissorImage, gbc);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == rockButton){
            if(gameData.getCurrentPlayer() == gameData.HOST){
                gameData.setP1Pick(gameData.ROCK);
            } else {
                gameData.setP2Pick(gameData.ROCK);
            }
        }
        else if(e.getSource() == paperButton){
            if(gameData.getCurrentPlayer() == gameData.HOST){
                gameData.setP1Pick(gameData.PAPER);
            } else {
                gameData.setP2Pick(gameData.PAPER);
            }
        }
        else if(e.getSource() == scissorButton){
            if(gameData.getCurrentPlayer() == gameData.HOST){
                gameData.setP1Pick(gameData.SCISSOR);
            } else {
                gameData.setP2Pick(gameData.SCISSOR);
            }
        }


        if(gameData.getCurrentPlayer() == gameData.HOST){
            title.setText(gameData.getP2Name() + "'s Turn");
            gameData.setCurrentPlayer(gameData.OPPONENT);
            main.showScreen(main.MESSAGE_SCREEN);
        }
        else if(gameData.getCurrentPlayer() == gameData.OPPONENT){
            title.setText(gameData.getP1Name() + "'s Turn");
            //Reset the message Screen
            gameData.setCurrentPlayer(gameData.HOST);
            main.showScreen(main.RESULT_SCREEN);
        }
        messageScreen.setMessage(gameData.getCurrentPlayer());
    }

    public void setTitle(String name){
        title.setText(name + "'s Turn");
    }
}