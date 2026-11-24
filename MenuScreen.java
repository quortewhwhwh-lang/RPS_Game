import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuScreen extends JPanel implements ActionListener{
    Main main;

    JLabel gameTitle;
    JButton vsBot;
    JButton vsPlayer;
    JButton quit;

    private int optionSelected;
    final int VS_BOT = 0;
    final int VS_PLAYER = 1;

    public MenuScreen(Main m){
        main = m;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        gameTitle = new JLabel("Rock Paper Scissors");
        gameTitle.setFont(new Font("Monospaced", Font.BOLD, 30));
        add(gameTitle);

        vsBot = new JButton("1 Player");
        vsBot.addActionListener(this);
        add(vsBot);

        vsPlayer = new JButton("2 Player");
        vsPlayer.addActionListener(this);
        add(vsPlayer);

        quit = new JButton("Quit");
        quit.addActionListener(this);
        add(quit);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == vsBot){
            optionSelected = VS_BOT;

            main.showScreen(main.CHOOSE_NAME_SCREEN);
        }
        else if(e.getSource() == vsPlayer){
            optionSelected = VS_PLAYER;

            main.showScreen(main.CHOOSE_NAME_SCREEN);
        }
        else if(e.getSource() == quit){
            main.dispose();
        }
    }

    public int getOptionSelected(){
        return optionSelected;
    }
}