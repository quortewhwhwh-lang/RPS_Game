import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ChooseNameScreen extends JPanel implements ActionListener{
    Main main;
    GameData gameData;
    RPSSelectScreen rPSSelectScreen;
    GridBagConstraints gbc = new GridBagConstraints();

    JLabel title;
    JLabel player1;
    JTextField player1Field;
    JLabel player2;
    JTextField player2Field;
    JButton confirm;
    JButton returnToMenu;
    
    //Default names
    
    public ChooseNameScreen(Main m, GameData gD, RPSSelectScreen rps){
        main = m;
        gameData = gD;
        rPSSelectScreen = rps;
        setLayout(new GridBagLayout());

        title = new JLabel("Choose Your Name!");
        title.setFont(new Font("Monospaced", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(title, gbc);
    //Player 1
        gbc.gridwidth = 1;

        player1 = new JLabel("Player 1: ");
        Font playerFont = new Font("Arial", Font.PLAIN, 24);
        player1.setFont(playerFont);
        gbc.gridx = 0;
        gbc.gridy = 1;   
        add(player1, gbc);

        player1Field = new JTextField(20);
        player1Field.setFont(playerFont);
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(player1Field, gbc);
    //Player 2 
        player2 = new JLabel("Player 2: ");
        player2.setFont(playerFont);
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(player2, gbc);

        player2Field = new JTextField(20);
        player2Field.setFont(playerFont);
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(player2Field, gbc);

    //Other Options
        confirm = new JButton("Confirm?");
        confirm.addActionListener(this);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        add(confirm, gbc);

        returnToMenu = new JButton("Return to Menu");
        returnToMenu.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        add(returnToMenu, gbc);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == confirm){
            if(!player1Field.getText().equals("")){
                gameData.setP1Name(player1Field.getText());
            } else {
                gameData.setP1Name("Player 1");
            }
            if(!player2Field.getText().equals("")){
                gameData.setP2Name(player2Field.getText());
            } else {
                gameData.setP2Name("Player 2");
            }
            
            rPSSelectScreen.setTitle(gameData.getP1Name());
            main.showScreen(main.MESSAGE_SCREEN);
        }
        else if(e.getSource() == returnToMenu){
            main.showScreen(main.MENU_SCREEN);
        }
    }
}