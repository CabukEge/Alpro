package bonn.uni.alpro;

public class Cell {
    public static final String EMPTY = " ";
    public static final String PLAYER_1 = "X";
    public static final String PLAYER_2 = "O";

    boolean empty;
    String player;

    Cell(){
        empty = true;
        player = Cell.EMPTY;
    }
}
