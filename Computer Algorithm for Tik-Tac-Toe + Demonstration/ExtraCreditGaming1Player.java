//Programmer: Clayton Wasenius
//Java Programming: CS A170-37286
//
//Extra Credit: Gaming 1 Player
//February 20th, 2020

import java.util.Scanner; 


public class ExtraCreditGaming1Player
{
    
     //already initialied to zero right here 
    public static void main(String[] args)
    {
        System.out.println("Programmer: Clayton Wasenius");
        System.out.println("Java Programming: CS A170-37286"); 
        System.out.println(); 
        System.out.println("Extra Credit: Gaming 1 Player "); 
        System.out.println("May 15th, 2020");
        System.out.println("****************************************");
        
        final char PLAYER_SYMBOL = 'O'; 
        final char COMPUTER_SYMBOL = 'X';
        
        
        final int WIDTH = 3;
        final int HEIGHT = 3;
        
        LetterTracker letter = new LetterTracker(); //introduces the object letter which is an instance of the class LetterTraacker 
        
        
        //part 2 
        char[][] ticTacToe = new char[WIDTH][HEIGHT]; 
        
        ticTacToe = initializeBoard(ticTacToe); 
        
        int letters = 0; //this still has to be initialized, even though we are getting help from 
        //another object 
        
        printBoard(ticTacToe);
        //part 1 
        int tempTracker = 0; 
        System.out.println("Welcome to Tic-Tac-Toe!"); 
        
        
        if(askUser()){ //who goes first, true if the user goes first, false if the computer goes first
            
            ticTacToe = ticTacToeBoardPlayer(ticTacToe, PLAYER_SYMBOL); //player's turn
            printBoard(ticTacToe);
            letters = letter.setValueOfLetterTo(1); 
            //System.out.println(letters); this is for error checking, seeing if we are counting the letters
            //properly 
            tempTracker++; 
        }
        else{
            ticTacToe = ticTacToeBoardComputerAlgo(ticTacToe, letters, COMPUTER_SYMBOL, PLAYER_SYMBOL); //computers turn
            letters = letter.setValueOfLetterTo(1);
            //System.out.println(letters); //same goes for here 
            printBoard(ticTacToe);
        }
        
        
         
         //this is going to track how many letters there are on the board 
        
        
        while((winYet(ticTacToe, COMPUTER_SYMBOL, PLAYER_SYMBOL)) == 0){ //while if won returns false, which !false == true, thus the while look will continue 
             //players turn
             if(tempTracker == 0){ //this is only zero at the start if the computer went first
               ticTacToe = ticTacToeBoardPlayer(ticTacToe, PLAYER_SYMBOL); //player's turn
               letters = letter.setValueOfLetterTo(1);
               System.out.println(letters); 
               printBoard(ticTacToe); //print the board once the player has made their selection 
               tempTracker++; //up to one
             }
             //check to see if anyone won 
             if(winYet(ticTacToe, COMPUTER_SYMBOL, PLAYER_SYMBOL) == -1) { //check if someone won
               System.out.printf("You lost... :("); 
               break; 
              } else if(winYet(ticTacToe, COMPUTER_SYMBOL, PLAYER_SYMBOL) == 1){
               System.out.printf("You won!...");
               break; 
             }
             //check to see if there was a draw 
             if(letters == 9 && winYet(ticTacToe, COMPUTER_SYMBOL, PLAYER_SYMBOL) == 0){ //someone could win on the last turn
                System.out.println("It's a Draw! Better luck next time!"); 
                break; 
                }
             
             System.out.println("Computers Turn!");
             //compluters turn 
             if(tempTracker == 1){
             
           
             ticTacToe = ticTacToeBoardComputerAlgo(ticTacToe, letters, COMPUTER_SYMBOL, PLAYER_SYMBOL); //computers turn
             letters = letter.setValueOfLetterTo(1); //increment letters 
             System.out.println(letters); 
             
             System.out.println("Computer has made it's turn.");
             printBoard(ticTacToe); 
             tempTracker--; //back to zero
            }
             
             //check to see if anyone won 
            if(winYet(ticTacToe, COMPUTER_SYMBOL, PLAYER_SYMBOL) == -1) { //check if someone won
               System.out.printf("Final Board%n...You lost... :( %n"); 
               
                
               break; 
            } 
            if(winYet(ticTacToe, COMPUTER_SYMBOL, PLAYER_SYMBOL) == 1){
               System.out.printf("Final Board%n...You won!...");
               
               break; 
            }
             
             //check to see if there's a draw
            if(letters == 9 && winYet(ticTacToe, COMPUTER_SYMBOL, PLAYER_SYMBOL) == 0){
                System.out.println("It's a Draw! Better luck next time!"); 
                break; 
            }
             
              
        }
        System.out.println("End of Game"); 
    }
    
    //part 1
    public static boolean askUser(){
        
        Scanner keyboardInput = new Scanner(System.in); 
        String who; 
        System.out.printf("Who goes first? Computer or Player?%n"); 
        System.out.printf("Entry: %n");  
        
        who = keyboardInput.next(); 
        while(!who.equals("Computer") && !who.equals("Player") && !who.equals("computer") && !who.equals("player")){
            System.out.printf("Incorrect selection, try again: "); 
            who = keyboardInput.next(); 
        }
        
        if(who.equals("computer") || who.equals("Computer"))
        {
            return (false);
        } else {
            return (true); 
        }
    
    }
    public static char[][] ticTacToeBoardPlayer(char[][] board, final char PLAYER_SYMBOL){
         
        int row = 0; //initialization
        int column = 0; //initialization 
        
        Scanner keyboardInput = new Scanner(System.in); 
        //part
        do{
           if(row != 0 && column != 0){ //this shows entry
                System.out.println("Whoops, looks like there's already a letter there! Try again."); 
           }
           System.out.println("Where would you like to place your piece? (You are O's"); 
           System.out.printf("Row: "); 
           row = keyboardInput.nextInt();
           while(row > 3 || row < 1){
              System.out.printf("Row can only be 1, 2, or 3.%n");
              System.out.println("Try again: "); 
              row = keyboardInput.nextInt();
           }
           keyboardInput.nextLine(); 
           System.out.printf("Column: ");
           column = keyboardInput.nextInt();
           while(column > 3 || column < 1){
            System.out.printf("Column can only be 1, 2, or 3.%n");
            System.out.println("Try again: "); 
            column = keyboardInput.nextInt();
           }
           keyboardInput.nextLine();
        }while(board[row - 1][column - 1] != ' '); //this assumes that a letter is already present there
        
           board[row - 1][column - 1] = PLAYER_SYMBOL; 
        
        
           return(board); 
    }
    
    //part 3
    public static char[][] ticTacToeBoardComputerAlgo(char[][] board, int letters, final char COMPUTER_SYMBOL, final char PLAYER_SYMBOL){ 
         if(board[1][1] != COMPUTER_SYMBOL && (board[1][1] != PLAYER_SYMBOL)){ //check for middle spot, if the middle is empty, no matter what, if the computer already
            //put one there then that means that board.length != 0
            board[1][1] = COMPUTER_SYMBOL;
            return (board); 
         } //we can't implement minimax here because we can't assume the human player will play optimally 
         if(letters == 1 && board[1][1] == PLAYER_SYMBOL){
             board[0][2] = COMPUTER_SYMBOL; 
             return (board); 
            
            }
            
        
         //this is an extention off of the case above where the player takes the middle spot
         if((letters == 3) && (board[0][2] == COMPUTER_SYMBOL) && ((board[2][0] == PLAYER_SYMBOL) && (board[1][1] == PLAYER_SYMBOL))){
            
            board[0][0] = COMPUTER_SYMBOL;
            return(board);
           }
         
         //BASE CASES FOR WINNING, This goes first, as we don't care about clocking the players win. If the computer can win on it's turn, it should.
         for(int i = 0; i < board[0].length; i++){ //if there is an open space ACROSS at any point then we fill in the empty space if we have the other two
                //we're going across here 
                if((board[i][0] == COMPUTER_SYMBOL && (board[i][1] == COMPUTER_SYMBOL) || board[i][1] == COMPUTER_SYMBOL && board[i][2] == COMPUTER_SYMBOL) || (board[i][0] == COMPUTER_SYMBOL && board[i][2] == COMPUTER_SYMBOL)){ //this is across at any point 
                    if((board[i][0] == COMPUTER_SYMBOL && board[i][1] == COMPUTER_SYMBOL) && (board[i][2] != COMPUTER_SYMBOL && board[i][2] != PLAYER_SYMBOL)){ //if there is a space to the right, X,X,' '
                        board[i][2] = COMPUTER_SYMBOL; 
                        printBoard(board); 
                        return (board); 
                    }
                    if((board[i][1] == COMPUTER_SYMBOL && board[i][2] == COMPUTER_SYMBOL) && (board[i][0] != COMPUTER_SYMBOL && board[i][0] != PLAYER_SYMBOL)){ //if there is a space to the left, ' ',X,X
                        board[i][0] = COMPUTER_SYMBOL; 
                         
                        return (board); 
                    }
                    if((board[i][0] == COMPUTER_SYMBOL && board[i][2] == COMPUTER_SYMBOL) && (board[i][1] != COMPUTER_SYMBOL && board[i][1] != PLAYER_SYMBOL)){ //if there is a space in the middle, X,' ',X
                        board[i][1] = COMPUTER_SYMBOL; 
                         
                        return (board); 
                    }
                    
                }
                
            }
         for(int j = 0; j < board[0].length; j++){ //if there is an open space ACROSS at any point then we fill in the empty space if we have the other two
                //we're going down here 
                if((board[0][j] == COMPUTER_SYMBOL && (board[1][j] == COMPUTER_SYMBOL) || board[1][j] == COMPUTER_SYMBOL && board[2][j] == COMPUTER_SYMBOL) || (board[0][j] == COMPUTER_SYMBOL && board[2][j] == COMPUTER_SYMBOL)){ //this is across at any point 
                   if((board[0][j] == COMPUTER_SYMBOL && board[1][j] == COMPUTER_SYMBOL) && (board[2][j] != COMPUTER_SYMBOL && board[2][j] != PLAYER_SYMBOL)){
                        board[2][j] = COMPUTER_SYMBOL; 
                        
                        return (board); 
                    }
                   if((board[1][j] == COMPUTER_SYMBOL && board[2][j] == COMPUTER_SYMBOL) && (board[0][j] != COMPUTER_SYMBOL && board[0][j] != PLAYER_SYMBOL)){
                        board[0][j] = COMPUTER_SYMBOL; 
                         
                        return (board); 
                    }
                   if((board[0][j] == COMPUTER_SYMBOL && board[2][j] == COMPUTER_SYMBOL) && (board[1][j] != COMPUTER_SYMBOL && board[1][j] != PLAYER_SYMBOL)){ //technically this should never be used since we 
                       //want to put X in the middle always if it's open regardless if computer or player goes first 
                       board[1][j] = COMPUTER_SYMBOL; 
                         
                       return (board); 
                    }
                }
                
            }
                //diagnal cases 
         if((board[0][0] == COMPUTER_SYMBOL && board[1][1] == COMPUTER_SYMBOL) || (board[1][1] == COMPUTER_SYMBOL && board[2][2] == COMPUTER_SYMBOL)){
                if((board[0][0] == COMPUTER_SYMBOL && board[1][1] == COMPUTER_SYMBOL) && (board[2][2] != COMPUTER_SYMBOL && board[2][2] != PLAYER_SYMBOL)){
                    board[2][2] = COMPUTER_SYMBOL;
                     
                    return (board);
                }
                if((board[1][1] == COMPUTER_SYMBOL && board[2][2] == COMPUTER_SYMBOL) && (board[0][0] != COMPUTER_SYMBOL && board[0][0] != PLAYER_SYMBOL)){
                    board[0][0] = COMPUTER_SYMBOL;
                    
                    return (board);
                }
         }
         if((board[2][0] == COMPUTER_SYMBOL && board[1][1] == COMPUTER_SYMBOL) || (board[1][1] == COMPUTER_SYMBOL && board[0][2] == COMPUTER_SYMBOL)){
                    if((board[2][0] == COMPUTER_SYMBOL && board[1][1] == COMPUTER_SYMBOL) && (board[0][2] != COMPUTER_SYMBOL && board[0][2] != PLAYER_SYMBOL)){
                    board[0][2] = COMPUTER_SYMBOL;
                     
                    return (board);
                   }
                   if((board[1][1] == COMPUTER_SYMBOL && board[0][2] == COMPUTER_SYMBOL) && (board[2][0] != COMPUTER_SYMBOL && board[2][0] != PLAYER_SYMBOL)){
                    board[2][0] = COMPUTER_SYMBOL;
                     
                    return (board);
                   }
            }
         
         
            //THE FOLLOWING CASES ARE FOR BLOCKING WINNING CASES AGAINST THE PLAYER 
         for(int i = 0; i < board[0].length; i++){ //if there is an open space ACROSS at any point then we fill in the empty space if we have the other two
                //we're going across here 
                 if((board[i][0] == PLAYER_SYMBOL && (board[i][1] == PLAYER_SYMBOL) || board[i][1] == PLAYER_SYMBOL && board[i][2] == PLAYER_SYMBOL) || (board[i][0] == PLAYER_SYMBOL && board[i][2] == PLAYER_SYMBOL)){ //this is across at any point 
                    if((board[i][0] == PLAYER_SYMBOL && board[i][1] == PLAYER_SYMBOL) && (board[i][2] != COMPUTER_SYMBOL && board[i][2] != PLAYER_SYMBOL)){ //if there is a space to the right, X,X,' '
                        board[i][2] = COMPUTER_SYMBOL; 
                        
                        return (board); 
                    }
                    if((board[i][1] == PLAYER_SYMBOL && board[i][2] == PLAYER_SYMBOL) && (board[i][0] != COMPUTER_SYMBOL && board[i][0] != PLAYER_SYMBOL)){ //if there is a space to the left, ' ',X,X
                        board[i][0] = COMPUTER_SYMBOL; 
                         
                        return (board); 
                    }
                    if((board[i][0] == PLAYER_SYMBOL && board[i][2] == PLAYER_SYMBOL) && (board[i][1] != COMPUTER_SYMBOL && board[i][1] != PLAYER_SYMBOL)){ //if there is a space in the middle, X,' ',X
                        board[i][1] = COMPUTER_SYMBOL; 
                         
                        return (board); 
                    }
                    
                }
                
            }
         for(int j = 0; j < board[0].length; j++){ //if there is an open space ACROSS at any point then we fill in the empty space if we have the other two
                //we're going down here 
                if((board[0][j] == PLAYER_SYMBOL && (board[1][j] == PLAYER_SYMBOL) || board[1][j] == PLAYER_SYMBOL && board[2][j] == PLAYER_SYMBOL) || board[0][j] == PLAYER_SYMBOL && board[2][j] == PLAYER_SYMBOL){ //this is across at any point 
                   if((board[0][j] == PLAYER_SYMBOL && board[1][j] == PLAYER_SYMBOL) && (board[2][j] != COMPUTER_SYMBOL && board[2][j] != PLAYER_SYMBOL)){
                        board[2][j] = COMPUTER_SYMBOL; 
                        
                        return (board); 
                    }
                   if((board[1][j] == PLAYER_SYMBOL && board[2][j] == PLAYER_SYMBOL) && (board[0][j] != COMPUTER_SYMBOL && board[0][j] != PLAYER_SYMBOL)){
                        board[0][j] = COMPUTER_SYMBOL; 
                         
                        return (board); 
                    }
                   if((board[0][j] == PLAYER_SYMBOL && board[2][j] == PLAYER_SYMBOL) && (board[1][j] != COMPUTER_SYMBOL && board[1][j] != PLAYER_SYMBOL)){ //technically this should never be used since we 
                       //want to put X in the middle always if it's open regardless if computer or player goes first 
                       board[1][j] = COMPUTER_SYMBOL; 
                         
                       return (board); 
                    }
                }
                
            }
                //diagnal cases 
                System.out.println("here?"); 
         if(((board[0][0] == PLAYER_SYMBOL) && (board[1][1] == PLAYER_SYMBOL)) || (board[1][1] == PLAYER_SYMBOL) && (board[2][2] == PLAYER_SYMBOL)){
                if(((board[0][0] == PLAYER_SYMBOL) && (board[1][1] == PLAYER_SYMBOL) && (board[2][2] != COMPUTER_SYMBOL && board[2][2] != PLAYER_SYMBOL))){
                    board[2][2] = COMPUTER_SYMBOL;
                    
                    return (board);
                }
                if((board[1][1] == PLAYER_SYMBOL && board[2][2] == PLAYER_SYMBOL) && (board[0][0] != COMPUTER_SYMBOL && board[0][0] != PLAYER_SYMBOL)){
                    board[0][0] = COMPUTER_SYMBOL;
                    
                    return (board);
                }
            }
         if((board[2][0] == PLAYER_SYMBOL && board[1][1] == PLAYER_SYMBOL) || (board[1][1] == PLAYER_SYMBOL && board[0][2] == PLAYER_SYMBOL)){
                if((board[2][0] == PLAYER_SYMBOL && board[1][1] == PLAYER_SYMBOL) && (board[0][2] != COMPUTER_SYMBOL && board[0][2] != PLAYER_SYMBOL)){
                    board[0][2] = COMPUTER_SYMBOL;
                    
                    return (board);
                }
                if((board[0][2] == PLAYER_SYMBOL && board[1][1] == PLAYER_SYMBOL) && (board[2][0] != COMPUTER_SYMBOL && board[2][0] != PLAYER_SYMBOL)){
                        board[2][0] = COMPUTER_SYMBOL;
                     
                    return (board);
                }
            }
         //We don't need to do middle of the diagal since this should always be filled. As in if board[0][2] and board[2][0] are filled we would win the game anyways 
         
         
         //NOW WE GET A LITTLE COMPLEX HERE 
         //created an object letter 
         
         
         //this is the magic of how we win the game, if the player choses any middle spot, after the computer has taken board[1][1], it's already game over
         if(((letters == 2) && (board[1][1] == COMPUTER_SYMBOL)) && ((board[0][1] == PLAYER_SYMBOL) || (board[1][2] == PLAYER_SYMBOL) || (board[2][1] == PLAYER_SYMBOL) || (board[1][0] == PLAYER_SYMBOL))){
              if(board[0][1] == PLAYER_SYMBOL){
                  board[2][0] = COMPUTER_SYMBOL;  //let's later induce some randominity in here so it feels more organic 
                  return (board); 
                }
              if(board[1][2] == PLAYER_SYMBOL){ // // 
                  board[0][0] = COMPUTER_SYMBOL;  
                  return (board);
                }
              if(board[2][1] == PLAYER_SYMBOL){ // // 
                  board[0][2] = COMPUTER_SYMBOL;  
                  return (board);
                }
              if(board[1][0] == PLAYER_SYMBOL){ // // 
                  board[2][2] = COMPUTER_SYMBOL;  
                  return (board);
                }
            
         }
         //this starts the diagnal track 
         if(((letters == 2) && (board[1][1] == COMPUTER_SYMBOL)) && ((board[0][0] == PLAYER_SYMBOL) || (board[0][2] == PLAYER_SYMBOL) || (board[2][0] == PLAYER_SYMBOL) || (board[2][2] == PLAYER_SYMBOL))){
              if(board[0][0] == PLAYER_SYMBOL){ // this CANNOT be random, the computer must put an x that is diagnal from the players sumbol, so in the opposite corner
                  board[2][2] = COMPUTER_SYMBOL;  //let's later induce some randominity in here so it feels more organic 
                  return (board); 
                }
              if(board[0][2] == PLAYER_SYMBOL){ // //
                  board[2][0] = COMPUTER_SYMBOL;  
                  return (board);
                }
              if(board[2][0] == PLAYER_SYMBOL){ // // 
                  board[0][2] = COMPUTER_SYMBOL;  
                  return (board);
                }
              if(board[2][2] == PLAYER_SYMBOL){ // // 
                  board[0][0] = COMPUTER_SYMBOL;  
                  return (board);
                }
            }
           
         
            
            //this continues onto the previous track where letter == 2, and the computer has the middle spot, there are exponential possabilities, so now we have 8 possabilities 
         if(((letters == 4) && (board[1][1] == COMPUTER_SYMBOL) && (((board[2][0] == COMPUTER_SYMBOL) && (board[0][2] == PLAYER_SYMBOL) && (board[1][0] == PLAYER_SYMBOL))))){
                board[2][1] = COMPUTER_SYMBOL; 
                return(board);
        
          
                
            }
         if(((letters == 4) && (board[1][1] == COMPUTER_SYMBOL) && (((board[2][0] == COMPUTER_SYMBOL) && (board[0][2] == PLAYER_SYMBOL) && (board[2][1] == PLAYER_SYMBOL))))){
                board[1][0] = COMPUTER_SYMBOL; 
                return(board);
         
        
          
            }
         if(((letters == 4) && (board[1][1] == COMPUTER_SYMBOL) && (((board[0][2] == COMPUTER_SYMBOL) && (board[0][1] == PLAYER_SYMBOL) && (board[2][0] == PLAYER_SYMBOL))))){
                board[1][2] = COMPUTER_SYMBOL;
                return(board);
         
        
          
            }
         if(((letters == 4) && (board[1][1] == COMPUTER_SYMBOL) && (((board[0][2] == COMPUTER_SYMBOL) && (board[1][2] == PLAYER_SYMBOL) && (board[2][0] == PLAYER_SYMBOL))))){
                board[0][1] = COMPUTER_SYMBOL; 
                return(board);
         
        
          
            }
         
            
         //other 4 cases 
         if(((letters == 4) && (board[1][1] == COMPUTER_SYMBOL) && (((board[0][0] == COMPUTER_SYMBOL) && (board[1][0] == PLAYER_SYMBOL) && (board[2][2] == PLAYER_SYMBOL))))){
                board[0][1] = COMPUTER_SYMBOL; 
                return(board);
         
        
          
            }
         if(((letters == 4) && (board[1][1] == COMPUTER_SYMBOL) && (((board[0][0] == COMPUTER_SYMBOL) && (board[0][1] == PLAYER_SYMBOL) && (board[2][2] == PLAYER_SYMBOL))))){
                board[1][0] = COMPUTER_SYMBOL; 
                return(board);
         
        
          
            }
         if(((letters == 4) && (board[1][1] == COMPUTER_SYMBOL) && (((board[2][2] == COMPUTER_SYMBOL) && (board[0][0] == PLAYER_SYMBOL) && (board[1][2] == PLAYER_SYMBOL))))){
                board[2][1] = COMPUTER_SYMBOL; 
                return(board);
         
        
          
            }
         if(((letters == 4) && (board[1][1] == COMPUTER_SYMBOL) && (((board[2][2] == COMPUTER_SYMBOL) && (board[0][0] == PLAYER_SYMBOL) && (board[2][1] == PLAYER_SYMBOL))))){
                board[1][2] = COMPUTER_SYMBOL; 
                return(board);
         
        
          
            }
         if(((letters == 3) && (board[0][2] == COMPUTER_SYMBOL) && (board[2][0] == PLAYER_SYMBOL) && (board[1][1] == PLAYER_SYMBOL))){
            
            board[0][0] = COMPUTER_SYMBOL;
            return(board);
            }
            
         if(((letters == 3) && (board[1][1] == COMPUTER_SYMBOL) && (board[0][0] == PLAYER_SYMBOL) && (board[1][2] == PLAYER_SYMBOL))){
            
            board[0][2] = COMPUTER_SYMBOL;
            return(board);
            }
         if(((letters == 3) && (board[1][1] == COMPUTER_SYMBOL) && (board[0][0] == PLAYER_SYMBOL) && (board[2][1] == PLAYER_SYMBOL))){
            
            board[2][0] = COMPUTER_SYMBOL;
            return(board);
            }
         if(((letters == 3) && (board[1][1] == COMPUTER_SYMBOL) && (board[0][1] == PLAYER_SYMBOL) && (board[2][2] == PLAYER_SYMBOL))){
            
            board[0][2] = COMPUTER_SYMBOL;
            return(board);
            }
         if(((letters == 3) && (board[1][1] == COMPUTER_SYMBOL) && (board[1][0] == PLAYER_SYMBOL) && (board[2][2] == PLAYER_SYMBOL))){
            
            board[2][0] = COMPUTER_SYMBOL;
            return(board);
            }
         if(((letters == 3) && (board[1][1] == COMPUTER_SYMBOL) && (board[0][2] == PLAYER_SYMBOL) && (board[2][1] == PLAYER_SYMBOL))){
            
            board[2][2] = COMPUTER_SYMBOL;
            return(board);
            }
         if(((letters == 3) && (board[1][1] == COMPUTER_SYMBOL) && (board[1][0] == PLAYER_SYMBOL) && (board[0][2] == PLAYER_SYMBOL))){
            
            board[0][0] = COMPUTER_SYMBOL;
            return(board);
            }
         if(((letters == 3) && (board[1][1] == COMPUTER_SYMBOL) && (board[0][1] == PLAYER_SYMBOL) && (board[2][0] == PLAYER_SYMBOL))){
            
            board[0][0] = COMPUTER_SYMBOL;
            return(board);
            }
         if(((letters == 3) && (board[1][1] == COMPUTER_SYMBOL) && (board[2][0] == PLAYER_SYMBOL) && (board[1][2] == PLAYER_SYMBOL))){
            
            board[1][0] = COMPUTER_SYMBOL;
            return(board);
            }
            
         //8 more cases 
         if(((letters == 3) && (board[1][1] == COMPUTER_SYMBOL) && (board[0][1] == PLAYER_SYMBOL) && (board[1][0] == PLAYER_SYMBOL))){
            
            board[0][0] = COMPUTER_SYMBOL;
            return(board);
            }
         if(((letters == 3) && (board[1][1] == COMPUTER_SYMBOL) && (board[1][0] == PLAYER_SYMBOL) && (board[2][1] == PLAYER_SYMBOL))){
            
            board[2][0] = COMPUTER_SYMBOL;
            return(board);
            }
         if(((letters == 3) && (board[1][1] == COMPUTER_SYMBOL) && (board[2][1] == PLAYER_SYMBOL) && (board[1][2] == PLAYER_SYMBOL))){
            
            board[2][2] = COMPUTER_SYMBOL;
            return(board);
            }
         if(((letters == 3) && (board[1][1] == COMPUTER_SYMBOL) && (board[0][1] == PLAYER_SYMBOL) && (board[1][2] == PLAYER_SYMBOL))){
            
            board[0][2] = COMPUTER_SYMBOL;
            return(board);
            }
         if(((letters == 3) && (board[1][1] == COMPUTER_SYMBOL) && (board[0][1] == PLAYER_SYMBOL) && (board[2][1] == PLAYER_SYMBOL))){
            
            board[2][1] = COMPUTER_SYMBOL;
            return(board);
            }
         if(((letters == 3) && (board[1][1] == COMPUTER_SYMBOL) && (board[1][0] == PLAYER_SYMBOL) && (board[1][2] == PLAYER_SYMBOL))){
            
            board[2][2] = COMPUTER_SYMBOL;
            return(board);
            }
         if(((letters == 3) && (board[1][1] == COMPUTER_SYMBOL) && (board[0][0] == PLAYER_SYMBOL) && (board[2][2] == PLAYER_SYMBOL))){
            
            board[0][1] = COMPUTER_SYMBOL;
            return(board);
            }
         if(((letters == 3) && (board[1][1] == COMPUTER_SYMBOL) && (board[0][2] == PLAYER_SYMBOL) && (board[2][0] == PLAYER_SYMBOL))){
            
            board[2][1] = COMPUTER_SYMBOL;
            return(board);
            }
            
          
         //if(((letters == 5) && (board[1][1] == COMPUTER_SYMBOL))
         //we need to do cases for letters 3 and 5!
         
        
         
         //if there are 6 letters and no one has won yet, and there aren't any winning cases for computer, or blocking cases against player,
         //then it is going to be a draw and we have to fill in any remaining cases to finish out the game 
         
         if(letters >= 6){
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    if(board[i][j] != 'X' && board[i][j] != 'O'){
                        board[i][j] = 'X'; //just fill in the first empty space that we find 
                        return(board); 
                    } 
                } 
            }
           
         }
         return(board); //we return board just so we know that we don't have a solution yet for the computer's turn 
     }
     //part 5
     public static void printBoard(char[][] board){
        
        //this is the key
        System.out.println("KEY"); 
        System.out.println("   Columns ->"); 
        System.out.printf("R%n");
        System.out.printf("O%n");
        System.out.printf("W%n");
        System.out.printf("S%n");
        System.out.printf(" %n"); 
        
        System.out.printf("|%n");
        System.out.printf("V%n"); 
        
        System.out.printf("%n%n"); 
        
        System.out.printf("CURRENT BOARD...%n");
        
        for(int i = 0; i < board.length; i++){
            System.out.printf("   ___________________________%n");
            for(int j = 0; j < board[0].length; j++){
                
                //System.out.printf("|   %c   |",board[i][j]);
                if(j == 0){
                     System.out.print("   " + "|   " + board[i][j] + "   |"); 
                } else {
                System.out.print("|   " + board[i][j] + "   |");
                }
                if(j == 2){
                     System.out.printf("%n"); 
                }
            }
            if(i == 2){
                System.out.printf("   ___________________________%n");
            }
            System.out.printf("%n");
        }
    }
    //part 6 
    public static int winYet(char[][] board, final int COMPUTER_SYMBOL, final int PLAYER_SYMBOL){ //returns true if won
    
        //COMPUTER WINNING 
        
        //winning accross
        
        for(int i = 0; i < board[0].length; i++){ //this is across
         
                if(board[i][0] == COMPUTER_SYMBOL && (board[i][1] == COMPUTER_SYMBOL) && (board[i][2] == COMPUTER_SYMBOL)){
                    printBoard(board); 
                    return (-1); 
                }
        }
        //winning down
        
        for(int i = 0; i < board.length; i++){ //board[0, 1, or 2].length() == board.length()...
                if(board[0][i] == COMPUTER_SYMBOL && board[1][i] == COMPUTER_SYMBOL && board[2][i] == COMPUTER_SYMBOL){
                    printBoard(board); 
                    return (-1);
                    
                }
        }
        //winning diagnally, both ways
        
        if(board[0][0] == COMPUTER_SYMBOL && board[1][1] == COMPUTER_SYMBOL && board[2][2] == COMPUTER_SYMBOL){
           printBoard(board); 
           return (-1);
            
        }
        
        if(board[0][2] == COMPUTER_SYMBOL && board[1][1] == COMPUTER_SYMBOL && board[2][0] == COMPUTER_SYMBOL){
           printBoard(board); 
           return (-1);
           
        }
        
        //PLAYER WINNING
        //winning across
        for(int i = 0; i < board[0].length; i++){ //this is across
         
                if(board[i][0] == PLAYER_SYMBOL && board[i][1] == PLAYER_SYMBOL && board[i][2] == PLAYER_SYMBOL){
                    printBoard(board);
                    return (1); 
                }
        }
        //winning down
        
        for(int i = 0; i < board.length; i++){ //board[0, 1, or 2].length() == board.length()...
            if(board[0][i] == PLAYER_SYMBOL && board[1][i] == PLAYER_SYMBOL && board[2][i] == PLAYER_SYMBOL){
                    printBoard(board);
                    return (1); 
                }
        }
        //winning diagnally, both ways 
        
        if(board[0][0] == PLAYER_SYMBOL && board[1][1] == PLAYER_SYMBOL && board[2][2] == PLAYER_SYMBOL){
        printBoard(board); 
        return (1);
        }
        
        if(board[0][2] == PLAYER_SYMBOL && board[1][1] == PLAYER_SYMBOL && board[2][0] == PLAYER_SYMBOL){
        printBoard(board); 
        return (1);
        }
        return (0); //none of the winning cases were found 
    }
    public static char[][] initializeBoard(char[][] initializedBoard){
        for(int i = 0; i < initializedBoard[0].length; i++){
            for(int j = 0; j < initializedBoard.length; j++){
                initializedBoard[i][j] = ' '; 
            
            }
        }
        return (initializedBoard); 
    }
}

