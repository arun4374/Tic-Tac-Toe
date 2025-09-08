import java.util.*;

public class main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        char[][] board = new char[3][3];
        

        while(true){
            System.out.printf("\n --- XO Game Menu --- \n1. Play Game \n2. Display Scoreboard \n3. Exit \nEnter your choice: ");
            int choice = sc.nextInt();
            System.out.println("");
            game gameClass = new game();
            switch(choice){
                case 1:
                    initializeBoard(board);
                    sc.nextLine();
                    System.out.print("Enter PLayer 1 Name: ");
                    String player1 = sc.nextLine();
                    System.out.print("Enter PLayer 2 Name: ");
                    String player2 = sc.nextLine();

                    gameClass.playGame(player1,player2,board);
                    break;
                case 2:
                    gameClass.showHistory();
                    break;
                case 3:
                    System.out.println("Application was closed");
                    return;
                default:
                    System.out.println("Invalid request! Try again..");
            }
        }
    }

    public static void initializeBoard(char[][] board){
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    board[i][j] = '-';
                }
            }
        }
}