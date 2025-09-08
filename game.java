import java.util.*;

public class game{
      static Scanner sc = new Scanner(System.in);
      static List<gameHistory> log = new ArrayList<>();

        public void playGame(String player1, String player2, char[][] board){
            char currentPlayer = 'X';
            String player = player1;
            boolean play = true;
            int size =3;
            int cnt=0;

            //  System.out.print("\n---- choice Timer ----\n1. 2 Min \n2. 5 Min \n3. No Timer");
            //         int choose = sc.nextInt();
            //         if(choose==1){
            //              gameTimer playerTime1 = new gameTimer(2);
            //              playerTime1.start();
            //         }else if(choose==2){
            //              gameTimer playerTime2 = new gameTimer(5);
            //              playerTime2.start();
            //         }else if(choose==3){
            //         }else{
            //             System.out.println("invalid option!");
            //         }

            while(play){
                if(cnt == size*size){
                    System.out.println("Match Draw!");
                    log.add(new gameHistory(player1,player2,"Match Draw"));
                    System.out.println("");
                    break;
                }
                System.out.println(player+" Your turn!");

                System.out.print("Enter positon(row & col): ");
                int movePos = sc.nextInt();
                System.out.println("");

                    int col = movePos%10;
                    int row = movePos/10;

                if(row >=size || col>=size){
                    System.out.println("Out of board position");
                    System.out.println("");
                    break;
                }
                
                if(board[row][col] == 'X' || board[row][col] == 'O'){
                    System.out.println("Wrong position!");
                    System.out.println("");
                    
                }else{
                    board[row][col] = currentPlayer;
                    undoredo urMoves = new undoredo(board);
                    if(isWin(board, currentPlayer, row, col, size)){
                        printBoard(board);
                        System.out.println("");
                        System.out.println(player+" Win the match!");
                        System.out.println("");
                        log.add(new gameHistory(player1,player2,player));
                        break;
                    }

                    
                    System.out.println(urMoves.stackSize());
                    
                    // gameTimer playerTime = new gameTimer(2);
                    // playerTime.start();
                  
                    System.out.println("");
                    printBoard(board);
                    System.out.println("");

                    System.out.print("undo & redo moves (u/r) or No: ");
                    int undoCount1=0;
                    int undoCount2=0;
                    char option = sc.next().charAt(0);
                    System.out.println("");
                    

                    if(option == 'u'){
                        if(urMoves.undoSize()){
                            System.out.println("No Moves Found!");
                            System.out.println("");
                            cnt++;
                            currentPlayer = currentPlayer == 'X' ? 'O' : 'X';
                            player = player == player1 ? player2 : player1;
                        }else{
                            board = urMoves.undoMoves();
                            printBoard(board);
                            System.out.println("");
                            cnt--;
                        }
                     
                    }else if(option == 'r'){
                        if(urMoves.redoSize()){
                            System.out.println("No Moves Found!");
                            System.out.println("");
                            cnt++;
                            currentPlayer = currentPlayer == 'X' ? 'O' : 'X';
                            player = player == player1 ? player2 : player1;
                        }else{
                            board = urMoves.redoMoves();
                            printBoard(board);
                            System.out.println("");
                            cnt++;
                        }
                    }else{
                        cnt++;
                        currentPlayer = currentPlayer == 'X' ? 'O' : 'X';
                        player = player == player1 ? player2 : player1;
                    }
                }

                
            }
            return;
        }

        public void printBoard(char[][] board){
            for(int i=0;i<board.length;i++){
                for(int j=0;j<board.length;j++){
                    System.out.print(board[i][j]+" ");
                }
                System.out.println();
            }
        }

        public boolean rowWin(char[][] board, char currentPlayer, int row, int size) {
            for (int i = 0; i < size; i++) {
                if (board[row][i] != currentPlayer) {
                    return false;
                }
            }
            return true;
        }

        public boolean colWin(char[][] board, char currentPlayer, int col, int size) {
            for (int i = 0; i < size; i++) {
                if (board[i][col] != currentPlayer) {
                    return false;
                }
            }
            return true;
        }

        public boolean diagWin(char[][] board, char currentPlayer, int size) {
            boolean win1 = true, win2 = true;
            for (int i = 0; i < size; i++) {
                if (board[i][i] != currentPlayer) win1 = false;
                if (board[i][size - i - 1] != currentPlayer) win2 = false;
            }
            return win1 || win2;
        }

        public boolean isWin(char[][] board, char currentPlayer, int row, int col, int size) {
            return rowWin(board, currentPlayer, row, size) ||
                colWin(board, currentPlayer, col, size) ||
                diagWin(board, currentPlayer, size);
        }

        public void showHistory(){
            if(log.size() != 0){
                for(gameHistory result:log){
                    System.out.println("");
                    System.out.println("<==== Score Board ====>");
                    System.out.println(result.player1+" vs "+ result.player2+" ---> "+"result: "+result.winner);
                
                }
            }else{
                System.out.println("Score Board Empty!");
            }
            return;
        }
}