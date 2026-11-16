import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//Creates Menu Screen
public class Main extends JFrame implements ActionListener{
    public static void main(String[] args) {
        new Main();
    }

    JPanel menuOption;
    JLabel title;
    JButton vsBot;
    JButton vsPlayer;

    JCheckBox unlimitedGames;
    private static boolean isUnlimited = false;

    public Main(){
        setLayout(new BorderLayout());
        menuOption = new JPanel(new GridLayout (0, 1));
        add(menuOption);

        title = new JLabel("Rock Paper Scissor the Game");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        add(title, BorderLayout.NORTH);

        unlimitedGames = new JCheckBox("Unlimited Rounds");
        unlimitedGames.addActionListener(this);
        menuOption.add(unlimitedGames);
        
        vsBot = new JButton("VS BOT");
        vsBot.addActionListener(this);
        menuOption.add(vsBot);

        vsPlayer = new JButton("VS PLAYER");
        vsPlayer.addActionListener(this);
        menuOption.add(vsPlayer);
        
        
        setBounds(0, 0, 500, 500);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == unlimitedGames){
            isUnlimited = unlimitedGames.isSelected();
        }

        if(e.getSource() == vsBot){
            new VsBot();
            dispose();
        } else if (e.getSource() == vsPlayer){

        }
    }

    public static boolean getIsUnlimited(){
        return isUnlimited;
    }
}