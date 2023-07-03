package bonn.uni.games;

import bonn.uni.alpro.Board;
import bonn.uni.alpro.Cell;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean finished = false;

        // Create instance of Class Board and store it in a variable
        Board board = new Board();

        System.out.println("Welcome to TicTacToe. Player1: "+ Cell.PLAYER_1+", Player2: "+Cell.PLAYER_2);
        System.out.println("First Enter your number from 0-2 for the x-axis and then for the y-axis ");
        while(!finished){
            // 1. print Board
            board.printBoard();

            // 2. Read from Commandline row and column of next move
            board.makeMove(input.nextInt(),input.nextInt(), input);

            // 3. Update finished-Variable of while-loop in case of a winner or draw
            if(board.hasWinner() | board.isDraw()){
                finished = true;
            }

        }

        // print Board one last time :)
        board.printBoard();
        // Handle winner/draw
        if(board.hasWinner()){
            System.out.println("The Winner is: " + board.getWinner());
        }else if( board.isDraw())
        {
            System.out.println("DRAW!!!");
        }


    }
}
