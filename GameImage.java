import java.awt.*;
import javax.swing.*;

public class GameImage extends JPanel{
    //extends JPanel make GameImage act like a JPanel (GameImage IS-A JPanel)
    private final String name;
    private final int size;
    private final ImageIcon orginalImage;
    private final JLabel resizedImage;

    public GameImage(String n, int s){
        name = n;
        size = s;

        orginalImage = new ImageIcon(getClass().getResource("Assets/" + name));
        resizedImage = new JLabel(new ImageIcon(orginalImage.getImage().getScaledInstance(size, size, Image.SCALE_SMOOTH)));
        setVisible(true);
        this.add(resizedImage);
    }
}