import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VsBot extends JFrame implements ActionListener{
    public static void main(String[] args) {
        new Main();
    }

//GUI
    GameImage playerRock;
    GameImage playerScissor;
    GameImage playerPaper;
    GameImage botRock;
    GameImage botScissor;
    GameImage botPaper;

    JPanel optionPanel; //Bottom Screen
    //Inside optionPanel:
    JButton rockButton;
    JButton scissorButton;
    JButton paperButton;

    //Center Screen
    JPanel playerPanel;
    JLabel playerText;

    JPanel botPanel;
    JLabel botText;

    JPanel scorePanel;
    JLabel resultText;
    JLabel score;
    JLabel winner;
    JButton playAgain;
    JButton returnToMenu;

    GridBagConstraints gbc = new GridBagConstraints();

//Game Logic
    private int playerPick;
    private int botPick;
    private static final int ROCK = 0;
    private static final int PAPER = 1;
    private static final int SCISSOR = 2;
    private String playerPickStr;
    private String botPickStr;
    private int playerWins = 0;
    private int botWins = 0;

    public VsBot(){
        setTitle("RPS Game");
        setLayout(new BorderLayout());
    //Bottom Screen
        optionPanel = new JPanel();
        add(optionPanel, BorderLayout.SOUTH);

        rockButton = new JButton("ROCK");
        rockButton.setFont(new Font("Arial", Font.BOLD, 48));
        rockButton.setForeground(Color.black);
        rockButton.setBackground(Color.red);
        rockButton.addActionListener(this);
        optionPanel.add(rockButton);

        paperButton = new JButton("PAPER");
        paperButton.setFont(new Font("Arial", Font.BOLD, 48));
        paperButton.setForeground(Color.black);
        paperButton.setBackground(Color.blue);
        paperButton.addActionListener(this);
        optionPanel.add(paperButton);

        scissorButton = new JButton("SCISSOR");
        scissorButton.setFont(new Font("Arial", Font.BOLD, 48));
        scissorButton.setForeground(Color.black);
        scissorButton.setBackground(Color.green);
        scissorButton.addActionListener(this);
        optionPanel.add(scissorButton);

    //West Screen
        playerPanel = new JPanel(new GridLayout(0, 1));
        playerText = new JLabel("You Picked");
        playerText.setFont(new Font("Arial", Font.BOLD, 50));
        playerPanel.add(playerText);
        add(playerPanel, BorderLayout.WEST);

    //Center Screen
        scorePanel = new JPanel(new GridBagLayout());
        add(scorePanel, BorderLayout.CENTER);

        score = new JLabel("0 - 0");
        score.setFont(new Font("Monospaced", Font.BOLD, 70));
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.weighty = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        scorePanel.add(score, gbc);

        //Displays multlined messages like
        /*
            ROCK
            beats
            SCISSOR
        */
        if(Main.getIsUnlimited()){
            resultText = new JLabel();
        } else {
            resultText = new JLabel("Best Out of 3 Wins!");
        }
        resultText.setFont(new Font("Monospaced", Font.BOLD, 30));
        gbc.weighty = 1;
        gbc.gridy = 1;
        scorePanel.add(resultText, gbc);

        winner = new JLabel();
        winner.setVisible(false);
        winner.setFont(new Font("Monospaced", Font.BOLD, 50));
        gbc.weighty = 1;
        gbc.gridy = 2;
        scorePanel.add(winner, gbc);

        playAgain = new JButton("Play Again?");
        playAgain.setVisible(false);
        Font buttonFont = new Font("Monospaced", Font.PLAIN, 24);
        playAgain.setFont(buttonFont);
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        playAgain.addActionListener(this);
        scorePanel.add(playAgain, gbc);

        returnToMenu = new JButton("Return to Menu");
        returnToMenu.setFont(buttonFont);
        returnToMenu.setVisible(false);
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridy = 3;
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        returnToMenu.addActionListener(this);
        scorePanel.add(returnToMenu, gbc);

    //East Screen
        botPanel = new JPanel(new GridLayout(0, 1));
        botText = new JLabel("Bot Picked");
        botText.setFont(new Font("Arial", Font.BOLD, 50));
        botPanel.add(botText);
        add(botPanel, BorderLayout.EAST);

        //Add rock, scissor and paper image.
        playerRock = new GameImage("Rock.png", 200, false);
        playerPaper = new GameImage("Paper.png", 200, false);
        playerScissor = new GameImage("Scissor.png", 200, false);
        playerPanel.add(playerRock);
        playerPanel.add(playerPaper);
        playerPanel.add(playerScissor);

        botRock = new GameImage("Rock.png", 200, false);
        botPaper = new GameImage("Paper.png", 200, false);
        botScissor = new GameImage("Scissor.png", 200, false);
        botPanel.add(botRock);
        botPanel.add(botPaper);
        botPanel.add(botScissor);

    //Setting up the JFrame
        setBounds(500, 0, 1080, 960);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == playAgain){

        }
        else if (e.getSource() == returnToMenu){
            new Main();
            dispose();
        }
        
        
        resetRound();
        if(e.getSource() == rockButton){
            playerRock.setVisible(true);
            playerPick = ROCK;
        }
        else if(e.getSource() == paperButton){
            playerPaper.setVisible(true);
            playerPick = PAPER;
        }
        else if(e.getSource() == scissorButton){
            playerScissor.setVisible(true);
            playerPick = SCISSOR;
        }
        startRound();
        //Refreshes screen afterwards
        setVisible(true);
    }

    public void startRound(){
        //The messages are monospaced and have the same amount of characters
        String draw = "  DRAW  ";
        String won = "YOU  WON";
        String lost = "YOU LOST";
    
        playerPickStr = switch(playerPick){
            case ROCK -> "ROCK";
            case PAPER -> "PAPER";
            default -> "SCISSOR";
        };
        botPickStr = switch(botPick){
            case ROCK -> "ROCK";
            case PAPER -> "PAPER";
            default -> "SCISSOR";
        };

        botPick = (int)(Math.random() * 3);

        switch(botPick){
            case ROCK -> botRock.setVisible(true);
            case PAPER -> botPaper.setVisible(true);
            default -> botScissor.setVisible(true);
        }

        resultText.setVisible(true);
        if(playerPick == botPick){
            resultText.setText(draw);
        }
        else {
            switch (playerPick) {
                //You pick ROCK
                case ROCK -> {
                    if(botPick == PAPER){
                        resultText.setText("ROCK Loses to PAPER");
                        botWins++;
                    } else {
                        resultText.setText("ROCK Beats SCISSORS");
                        playerWins++;
                    }
                    
                }
                //You pick PAPER
                case PAPER -> {
                    if(botPick == ROCK){
                        resultText.setText("PAPER Beats ROCK");
                        playerWins++;
                    } else {
                        resultText.setText("PAPER Loses to SCISSORS");
                        botWins++;
                    }
                }
                //You pick SCISSOR
                default -> {
                    if(botPick == ROCK){
                        resultText.setText("SCISSORS Beats PAPER");
                        botWins++;
                    } else {
                        resultText.setText("SCISSORS Loses to ROCK");
                        playerWins++;
                    }
                }
            }
        }

        //Updates the score
        score.setText(playerWins + " - " + botWins);
        //When either player or bot wins twice the game ends and shows a menu.
        if(playerWins == 2){
            showMenu("YOU WON! ");
        } else if (botWins == 2){
            showMenu("YOU LOST!");
        }
    }

    public void resetRound(){
        playerRock.setVisible(false);
        playerPaper.setVisible(false);
        playerScissor.setVisible(false);

        botRock.setVisible(false);
        botPaper.setVisible(false);
        botScissor.setVisible(false);

        resultText.setVisible(false);
        playerPick = -1;
        botPick = -1;
    }

    public void showMenu(String m){
        winner.setVisible(true);
        winner.setText(m);
        playAgain.setVisible(true);
        returnToMenu.setVisible(true);
    }
}


class GameImage extends JPanel{
    //extends JPanel make GameImage act like a JPanel (GameImage IS-A JPanel)
    private final String name;
    private final int size;
    private final boolean isVisable;
    private final ImageIcon orginalImage;
    private final JLabel resizedImage;

    public GameImage(String n, int s, boolean iV){
        name = n;
        size = s;
        isVisable = iV;

        orginalImage = new ImageIcon(getClass().getResource(name));
        resizedImage = new JLabel(new ImageIcon(orginalImage.getImage().getScaledInstance(size, size, Image.SCALE_SMOOTH)));
        setVisible(isVisable);
        this.add(resizedImage);
    }
}