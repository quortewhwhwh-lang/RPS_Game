public class GameData{
    private String p1Name = "Player 1";
    private String p2Name = "Player 2";

    private int currentPlayer;
    public final int HOST = 0;
    public final int OPPONENT = 1;

    private int p1Pick = -1;
    private int p2Pick = -1;
    public final int ROCK = 0;
    public final int PAPER = 1;
    public final int SCISSOR = 2;

    public String getP1Name(){
        return p1Name;
    }
    public void setP1Name(String p1){
        p1Name = p1;
    }

    public String getP2Name(){
        return p2Name;
    }
    public void setP2Name(String p2){
        p2Name = p2;
    }

    public int getCurrentPlayer(){
        return currentPlayer;
    }
    public void setCurrentPlayer(int p){
        currentPlayer = p;
    }

    public int getP1Pick(){
        return p1Pick;
    }
    public void setP1Pick(int p){
        p1Pick = p;
    }

    public int getP2Pick(){
        return p2Pick;
    }
    public void setP2Pick(int p){
        p2Pick = p;
    }

    
}