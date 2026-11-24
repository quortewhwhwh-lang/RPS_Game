import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MessageScreen extends JPanel implements ActionListener{
    Main main;
    GameData gameData;

    JLabel message;
    JButton okay;

    public MessageScreen(Main m, GameData gD){
        main = m;
        gameData = gD;
        setLayout(new BorderLayout());
        
        gameData.setCurrentPlayer(gameData.HOST);
        message = new JLabel();
        message.setFont(new Font("Monospaced", Font.BOLD, 30));
        setMessage(gameData.getCurrentPlayer());
        add(message, BorderLayout.CENTER);

        okay = new JButton("OK");
        okay.addActionListener(this);
        add(okay, BorderLayout.SOUTH);
    }

    public void setMessage(int currentPlayer){
        if(currentPlayer == gameData.HOST){
            message.setText("Hide the screen from your opponent!");
        }
        else if(currentPlayer == gameData.OPPONENT){
            message.setText("Pass the screen to your opponent and don't look!");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == okay){
            main.showScreen(main.RPS_SELECT_SCREEN);
        }
    }
}