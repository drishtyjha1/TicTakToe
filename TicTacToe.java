import java.io.*;
import java.util.*;

class TicTacToe {

    static HashSet<Integer> user_set = new HashSet<Integer>();
    static HashSet<Integer> comp_set = new HashSet<Integer>();

    public static void main(String[] args) {

        char[][] g_board = { { ' ', '&', ' ', '&', ' ' },
         { '-', '-', '-', '-', '-', '-' },
        { ' ', '&', ' ', '&', ' ' },
         { '-', '-', '-', '-', '-', '-' },
         { ' ', '&', ' ', '&', ' ' } };

        print_board(g_board);

        Scanner in =new Scanner(System.in);
        while(true)
        {
           
	       System.out.print("Enter any number from 1 - 9:");
           int user_pos = in.nextInt();
           while(user_set.contains(user_pos)|| comp_set.contains(user_pos))
           {
                 System.out.println("Postion is already taken.TryAgain");
                 System.out.print("Enter any number from 1 - 9:");
                 user_pos = in.nextInt();
           }
           place_holder(g_board,user_pos,"cpu");

           String res = check_winning();
           if(res.length()>0)
           {
               System.out.println(res);
               break;
           }
           
           int comp_pos = gen_rendom();
           while(user_set.contains(user_pos)|| comp_set.contains(user_pos))
           {
                comp_pos =gen_rendom();
           }
           place_holder(g_board,user_pos,"cpu");

          res =check_winning();
           if(res.length()>0)
           {
               System.out.println(res);
               break;
           }
        }
    }

     static String check_winning()
      {
        HashSet<Integer> r1 =new HashSet<Integer>();
        r1.add(1);r1.add(2);r1.add(3);
        HashSet<Integer> r2 =new HashSet<Integer>();
        r2.add(4);r1.add(5);r1.add(6);
        HashSet<Integer> r3 =new HashSet<Integer>();
        r3.add(7);r1.add(8);r1.add(9);
        HashSet<Integer> c1 =new HashSet<Integer>();
        c1.add(1);c1.add(4);c1.add(7);
        HashSet<Integer> c2 =new HashSet<Integer>();
        c2.add(2);c2.add(5);c2.add(8);
        HashSet<Integer> c3 =new HashSet<Integer>();
        c3.add(3);c3.add(6);c3.add(9);
        HashSet<Integer> d1 =new HashSet<Integer>();
        d1.add(3);d1.add(6);d1.add(9);
        HashSet<Integer> d2 =new HashSet<Integer>();
        d2.add(3);d2.add(5);d2.add(7);
       
        HashSet<HashSet> set =  new HashSet<HashSet>();
        set.add(r1);set.add(r2);set.add(r3);
        set.add(c1);set.add(c2);set.add(c3);
        set.add(d1);set.add(d2 );

        for(HashSet c:set){

            if(user_set.containsAll(c))
                  return "You win";
            else if(comp_set.containsAll(c))  
                  return"You lose";
        }
        if(user_set.size()+comp_set.size()==9)
        return"Drow";
        return "";
      
    }

     static int gen_rendom()
      {
        int max=9;
        int min =1;


        int  range = max*min-1;
        int res = (int) ((Math.random()*range)*min);
        return res;
        
    }

    static void place_holder(char[][] g_board, int position_in_board, String user) {
        char syb = 'X';
        if (user.equals("You")) {
            syb = 'X';
            user_set.add(position_in_board);
        }

        else if (user.equals("Comp")) {
            syb = 'O';
            comp_set.add(position_in_board);
	        } 
	     else 
            System.out.println("Invalid User");
            switch(position_in_board)
            {
                 case 1:
                      g_board[0][0]=syb;
                      break;
                      case 2:
                      g_board[0][2]=syb;
                      break;
                      case 3:
                      g_board[0][4]=syb;
                      break;
                      case 4:
                      g_board[2][0]=syb;
                      break;
                      case 5:
                      g_board[2][2]=syb;
                      break;
                      case 6:
                      g_board[2][4]=syb;
                      break;
                      case 7:
                      g_board[4][0]=syb;
                      break;
                      case 8:
                      g_board[4][2]=syb;
                      break;

                       case 9:
                      g_board[4][4]=syb;
                      break; 
                      
                  default:
                        System.out.println("Invalid Input");
              }
              System.out.println();
              
                   print_board(g_board); 
        }
   
   

        static void print_board(char [][]g_board)
{
   for(int i=0;i<g_board.length;i++)
	 {
     for(int j=0;j<g_board[0].length;j++)
	    {
	                System.out.print(g_board[i][j]);
	         }
	       System.out.println();
	     }
    }

}