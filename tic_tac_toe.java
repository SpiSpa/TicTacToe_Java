/*create a one and two player Tic Tac Toe game
 * 1. Give it a Unique Name this is your Game. 
 * 2. Create two Classes they must be in two separate files.
 * 3. Must have a constructor.
 * 4. Must include the following in your code: array or arraylist, trys/catches, 
 *      Functions, if/else, while loops, inheritance, comments, JOption,
 * 5. Save and send the scores to a file. 
 * 6. This must be 1 and 2 player game
 */

 import java.io.FileWriter;
 import javax.swing.JOptionPane; 
 import javax.swing.JLabel; // helps to change font
 import javax.swing.JPanel;
 import java.util.Scanner;
 import java.awt.Font; // to change font in option pane message
 import java.awt.GridLayout;

public class tic_tac_toe {

    public void player_move(){   // in charge of player move
        System.out.println("Place player move class here");
    }

    public void board_manager(){
        System.out.println("manage board here");
    }

    public void check_win(){
        System.out.println("check for a win");
    }
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
    public static void display(int[][] board){
        String message1;
        String message2;
        String message3;

        //message1 = " X | O | X ";
        message1 = XorO(board[0][0]) + "|" + XorO(board[0][1]) + "|" + XorO(board[0][2]);
        message2 = XorO(board[1][0]) + "|" + XorO(board[1][1]) + "|" + XorO(board[1][2]);
        message3 = XorO(board[2][0]) + "|" + XorO(board[2][1]) + "|" + XorO(board[2][2]);

        JLabel label1 = new JLabel(message1); 
        JLabel label2 = new JLabel(message2);
        JLabel label3 = new JLabel(message3);
        label1.setFont(new Font("Courier", Font.BOLD, 18));
        label2.setFont(new Font("Courier", Font.BOLD, 18));
        label3.setFont(new Font("Courier", Font.BOLD, 18));
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
    //found above here: https://stackoverflow.com/questions/26913923/how-do-you-change-the-size-and-font-of-a-joptionpane
    JOptionPane.showMessageDialog(null, panel, "TTT", JOptionPane.INFORMATION_MESSAGE);
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
    public void computer_move(){
        System.out.println("Computer makes his move yet.");
        //check and move for computer winning move
        //check and block for user winning move
        //normal moves 
            //usually choose middle if possible
            //then choose corner, if possible
            //then choose non corner, if possible
    }
    public void game_manager1Player(){
        System.out.println("manage 1 player game");
    }
    public void game_manager2Player(){
        System.out.println("manage 2 player game");
    }
    public static void main(String[] args) {
        int[][] board = new int[3][3];
        board = initalizeBoard();
        display(board);
    }
}
