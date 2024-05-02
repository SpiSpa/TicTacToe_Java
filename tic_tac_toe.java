/*create a one and two player Tic Tac Toe game
 * 1. Give it a Unique Name this is your Game. 
 * 2. Create two Classes they must be in two separate files.
 * 3. Must have a constructor.
 * 4. Must include the following in your code: array or arraylist, trys/catches, 
 *      Functions, if/else, while loops, inheritance, comments, JOption,
 * 5. Save and send the scores to a file. 
 * 6. This must be 1 and 2 player game
 */

import javax.swing.JOptionPane; 
import javax.swing.JLabel; // helps to change font
import javax.swing.JPanel;

import java.util.Arrays;
import java.util.Random;
import java.awt.Font; // to change font in option pane message
import java.awt.GridLayout;

public class tic_tac_toe {

    public static String XorO(int item){
        String displayXorO;
        if (item == -1){
            displayXorO = " X ";
        }
        else if (item == 1){
            displayXorO = " O ";
        }
        else if (item == 0){
            displayXorO = "___";
        }
        else{
            displayXorO = "ERR";  // only returns if we get a weird integer.  
        }
        return(displayXorO);
    }

    public static boolean winCheck(int[][] board){
        int horSum;
        int verSum;
        int diag1Sum;
        int diag2Sum;

        diag1Sum = board[0][0] + board[1][1] + board[2][2];
        diag2Sum = board[0][2] + board[1][1] + board [2][0];

        if (diag1Sum == 3 || diag1Sum == -3 || diag2Sum == 3 || diag2Sum == -3){
            return true;
        }
        for(int i = 0; i < 3; i++){
            horSum = board[i][0] + board[i][1] + board[i][2];
            verSum = board[0][i] + board[1][i] + board[2][i];

            if (horSum == 3 || verSum == 3 || horSum == -3 || verSum == -3){
                return true;
            }
        }
        return false;
    }

    public static int display(int[][] board){
        String message1;
        String message2;
        String message3;
        String instructions;

        String moveString;
        int move;
        final String[] BOARD_LOCATIONS = {"00", "01", "02", "10", "11", "12", "20", "21", "22"};
        //boolean inputCheck = false;

        //message1 = " X | O | X ";
        message1 = XorO(board[0][0]) + "|" + XorO(board[0][1]) + "|" + XorO(board[0][2]);
        message2 = XorO(board[1][0]) + "|" + XorO(board[1][1]) + "|" + XorO(board[1][2]);
        message3 = XorO(board[2][0]) + "|" + XorO(board[2][1]) + "|" + XorO(board[2][2]);
        instructions = "Enter your move as an ordered pair.\n Ex. upper left: 00";

        JLabel label1 = new JLabel(message1); 
        JLabel label2 = new JLabel(message2);
        JLabel label3 = new JLabel(message3);
        JLabel label4 = new JLabel(instructions);

        label1.setFont(new Font("Courier", Font.BOLD, 18));
        label2.setFont(new Font("Courier", Font.BOLD, 18));
        label3.setFont(new Font("Courier", Font.BOLD, 18));

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);
    //found above here: https://stackoverflow.com/questions/26913923/how-do-you-change-the-size-and-font-of-a-joptionpane
        do{
            moveString = JOptionPane.showInputDialog(null, panel, "TTT", JOptionPane.INFORMATION_MESSAGE);
            if (moveString == null){
                System.out.println("Program Ends");
                System.exit(0);
            }
            try{
            move = Integer.parseInt(moveString);  // check if input is a number
            System.out.println("try block" + move);
        }
        catch (IllegalArgumentException e){
            JOptionPane.showMessageDialog(null, "Sorry!  Please input your \n move as two digits \n  e.g. 11 for the middle square.", "Whoops!", JOptionPane.INFORMATION_MESSAGE);
            move = -1;
            System.out.println("catch block" + move);
        } }
        while(Arrays.asList(BOARD_LOCATIONS).contains(moveString) == false);
        System.out.println("exited try/catch blocks");
        return move;
    }

    public static int computerMove(int[][] board, int i){
        int move;
        int[][] cornerList = {{0, 0}, {0, 2}, {2, 0}, {2, 2}};
        int[][] nonCornerList = {{0, 1}, {1, 0}, {1, 2}, {2, 1}};
        int decider;
        Random rand = new Random();
        
        decider = rand.nextInt(9);

        // check and make a winning move, first.

        // check for wins
        // if you don't block, do a "normal move"
        move = -1;
        return move;
    }
    public static int[][] initalizeBoard(){
        int[][] board = new int[3][3];
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                board[i][j] = 0;
            }
        }
        return board;
    }
    public static void main(String[] args) {
        boolean gameEnd = false;
        int[][] board = new int[3][3];
        int x; 
        int y;
        int moveInteger;
        board = initalizeBoard();
        // TODO: prompt if you want to go first or second.
        // if first, do that below
        // else if for going second. 
        while (gameEnd == false){
            moveInteger = display(board);
            x = moveInteger / 10;
            y = moveInteger % 10;
            while (board[x][y] == 1){
                JOptionPane.showMessageDialog(null, "Sorry! That square\nhas been taken", "Whoops!", JOptionPane.INFORMATION_MESSAGE);
                moveInteger = display(board);
                x = moveInteger / 10;
                y = moveInteger % 10;
            }
            // TODO: decide where in the code to display winning board.  
            board[x][y] = 1;
            gameEnd = winCheck(board);
            if (gameEnd == true){
                System.out.println("We have a winner!");
            }
            // TODO: computer move

            gameEnd = winCheck(board);
        }
        }
}

///Users/sarabellus/Desktop/CIS_263