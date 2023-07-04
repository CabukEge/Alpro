package bonn.uni.alpro;

import java.util.Objects;
import java.util.Scanner;

public class Board {
    public Cell[][] cells;
    public String playerTurn;

    public Board(){
        cells = new Cell[3][3];
        playerTurn = "X";

        for (int i = 0;i<cells.length;i++){
            for (int j = 0; j<cells[i].length;j++){
                // Assign a new Instance of the class Cell to cells[i][j]
                cells[i][j] = new Cell();
            }
        }
    }

    public void printBoard(){
        for (int i = 0;i<cells.length;i++){
            for (int j = 0; j<cells[i].length;j++){
                System.out.print(cells[i][j].player + "|");
            }
            System.out.println("\n-----");
        }
    }

    public void makeMove(int x, int y, Scanner input){
        // Handle case if the cell is already occupied and quit method (return)
        boolean check = false;
        do{
            if(x > 2  || y > 2){
                System.out.println("Remember: x and y have to be less than 3");
            }
            else if(!cells[x][y].empty){
                System.out.println("Remember: the cell has to be empty");
            }
            else
            {
                check = true;
                cells[x][y].player = playerTurn;
                // Set empty-property of Cell to false
                cells[x][y].empty = false;

                if (playerTurn.equals(Cell.PLAYER_1)) {
                    playerTurn = Cell.PLAYER_2;
                } else {
                    playerTurn = Cell.PLAYER_1;
                }
                return;
            }
            x = input.nextInt();
            y= input.nextInt();
        }while(check == false);
    }

    public String getWinner(){
        for (int i = 0; i< cells.length;i++){
            /*
                This if compares each row for containing the same symbol and not being empty
             */
            if(!cells[i][0].player.equals(Cell.EMPTY) && cells[i][0].player.equals(cells[i][1].player) && cells[i][1].player.equals(cells[i][2].player)){
                return cells[i][0].player;
            }
            if (!cells[0][i].player.equals(Cell.EMPTY) && cells[0][i].player.equals(cells[1][i].player) && cells[1][i].player.equals(cells[2][i].player)) {
                return cells[1][1].player;
            }
        }
        // Program the same check for columns
        // Check other diagonal as well for a winner
            if (!cells[0][0].player.equals(Cell.EMPTY) && cells[0][0].player.equals(cells[1][1].player) && cells[1][1].player.equals(cells[2][2].player)
                    |!cells[2][0].player.equals(Cell.EMPTY) && cells[2][0].player.equals(cells[1][1].player) && cells[1][1].player.equals(cells[0][2].player))
            {
                return cells[1][1].player;
            }


        return Cell.EMPTY;
    }

    public boolean hasWinner(){
        return !getWinner().equals(Cell.EMPTY);
    }

    public boolean isDraw() {
        for (int i = 0;i<cells.length;i++){
            for (int j = 0; j<cells[i].length;j++){
                if(cells[i][j].player.equals(Cell.EMPTY)){
                    return false;
                }
            }
        }
        return true;
    }
}
