import java.util.Scanner;

class TicTacToeBoard
{
    static char[][] board;

    public TicTacToeBoard()
    {
        board = new char[3][3];
        initBoard();
    }

    void initBoard()
    {
        for(int r=0; r < board.length; r++)
        {
            for(int c=0; c < board[r].length; c++)
            {
                board[r][c] = ' ';
            }
        }
    }
    static void disBoard()
    {
        System.out.println("-------------");
        for(int r=0; r < board.length; r++)
        {
            System.out.print("| ");
            for(int c=0; c < board.length; c++)
            {
                System.out.print(board[r][c] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }
//        private static void display()
//        {
//            for(int row = 0; row < ROWS; row++)
//            {
//                for(int col = 0; col < COLS; col++)
//                {
//                    System.out.print(board[row][0] + " | " + board[row][1] + " | " + board[row][2]);
//                }
//                System.out.println("");
//            }
//        }
    static void placeMark(int row, int col, char mark) {
        if (row >= 0 && row <= 2 && col >= 0 && col <= 2)
        {
            board[row][col] = mark;
        }
        else
        {
            System.out.println("Invalid Position");
        }
    }
    static boolean checkColWin()
    {
        for (int c = 0; c <= 2; c++)
        {
            if (board[0][c] != ' ' && board[0][c] == board[1][c] && board[1][c] == board[2][c])
            {
                return true;
            }
        }
        return false;
    }
    //        private static boolean isColWin(String player)
//        {
//            for(int col = 0; col < COLS; col++)
//            {
//                if(board[col][0].equals(player) && board[col][1].equals(player) && board[col][2].equals(player))
//                {
//                    return true;
//                }
//            }
//            return false;
//        }
    static boolean checkRowWin()
    {
        for (int r = 0; r <= 2; r++)
        {
            if (board[r][0] != ' ' && board[r][0] == board[r][1] && board[r][1] == board[r][2])
            {
                return true;
            }
        }
        return false;
    }
    //        private static boolean isRowWin(String player)
//        {
//            for(int row = 0; row < ROWS; row++)
//            {
//                if(board[row][0].equals(player) && board[row][1].equals(player) && board[row][2].equals(player))
//                {
//                    return true;
//                }
//            }
//                return false;
//        }
    static boolean checkDiagWin()
    {
        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2] ||
                board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0])
            {
                return true;
            }
        return false;
    }

    //        private static boolean isDiagonalWin(String player)
//        {
//            if (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player))
//            {
//                return true;
//            }
//            return false;
//
////            ifelse(board[2][0].equals(player) && board[1][1].equals(player) && board[0][2].equals(player))
////            {
////                return true;
////            }
////            return false;
//        }



    //        private static boolean isWin(String player)
//        {
//            if(isColWin(player) || isRowWin(player) || isDiagonalWin(player))
//            {
//                return true;
//            }
//            return false;
//        }
    static boolean checkDraw()
    {
        for (int r = 0; r <= 2; r++)
        {
            for (int c = 0; c <= 2; c++)
            {
                if(board[r][c] == ' ')
                {
                    return false;
                }
            }
        }
        return true;
    }

    //
////        private static boolean isTie()
////        {
////            for(int row = 0; row < ROWS; row++)
////            {
////                if(board[row][0].equals(player) && board[row][1].equals(player) && board[row][2].equals(player))
////                {
////                    return true;
////                }
////            }
////            return false;
//        }
//
    static void clearBoard()
    {
        for(int r = 0; r <= 2; r++)
        {
            for(int c = 0; c <= 2; c++)
            {
                board[r][c] = ' ';
            }
        }
    }
}

class Player
{
    String name;
    char mark;

    Player(String name, char mark)
    {
        this.name = name;
        this.mark= mark;
    }

    void makeMove()
    {
        Scanner in = new Scanner(System.in);
        int row;
        int col;

        do
        {
            System.out.print("Enter your move [row space column]: ");
            row = in.nextInt();
            col = in.nextInt();
        }while(!isValidMove(row,col));

        TicTacToeBoard.placeMark(row,col,mark);
    }

    boolean isValidMove(int row, int col)
    {
        if(row >= 0 && row <= 2 && col >= 0 && col <= 2)
        {
            if(TicTacToeBoard.board[row][col] == ' ')
            {
                return true;
            }
        }
        return false;
    }
    //        private static boolean isValidMove(int row, int col)
//        {
//            boolean refVal = false;
//            if (board[row][col].equals(" "))
//            {
//                refVal = true;
//                return refVal;
//            }
//            return board[row][col].equals(" ");
//        }
}


public class TicTacToe
{
//    private static final int ROWS = 3;
//    private static final int COLS = 3;
//    private static String board [][] = new String[ROWS][COLS];

    public static void main(String[] args)
    {
            Scanner in = new Scanner(System.in);
//            int row=0;
//            int col=0;
        TicTacToeBoard t = new TicTacToeBoard();
        Player playerA = new Player("Player A",'X');
        Player playerB = new Player("Player B", 'O');


        Player cp;
        cp = playerA;
//        Scanner in = new Scanner(System.in);
        String continueYN = "";

        do
        {
            //Clear the Board
            TicTacToeBoard.clearBoard();
            while(true)
            {
                System.out.println(cp.name + " turn");
                //Get Player A / B move this will switch back and forth
                //x assigned to player a, o assigned to player b
                //take players input
                cp.makeMove();
//                int rowMove = SafeInput.getRangedInt(in, "Enter row",0,2);
//                int colMove = SafeInput.getRangedInt(in, "Enter col",0,2);
                //display the board with the players selected coordinates
                TicTacToeBoard.disBoard();

                //check for player win, if not keep looping
                if (TicTacToeBoard.checkColWin() || TicTacToeBoard.checkRowWin() || TicTacToeBoard.checkDiagWin())
                {
                    //when a player wins announce the winner
                    System.out.println(cp.name + " has WON");
                    break; //once a winner stop the loop
                } else if (TicTacToeBoard.checkDraw())
                {
                    //if all spaces are filled and no one won
                    System.out.println("Game is over!");
                    break;
                }
                else
                {
                    //switch between player a & b
                    if (cp == playerA)
                    {
                        cp = playerB;
                    }
                    else
                    {
                        cp = playerA;
                    }
                }
            }
            //ask player if they want to play again
            System.out.print("Do you want to play again [Y/N]?");
            continueYN = in.nextLine();
        }while(continueYN.equalsIgnoreCase("Y"));

    }
}
