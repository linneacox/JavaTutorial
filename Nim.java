import java.util.Scanner;

public class Nim {

  public static void main(String[] args) {
    //variable for how many marbles there are
    int pileSize = 100;

    //variables to faciliate user input
    Scanner input = new Scanner(System.in);
    int userGuess;

    //variable for a smart Nim
    boolean smartNim = true;
    int cpuGuess;
    int[] pow2s = {1,2,4,8,16,32,64,128};

    //variable for who's turn it is
    boolean humanTurn; //true means it is the human's turn

    //decide who goes first
    if (Math.random() >= 0.5) {
      humanTurn = true;
    } else {
      humanTurn = false;
    }

    //game loop
    while (pileSize > 1) {
      //report how many marbles left in pile
      System.out.println("Marbles left:" + pileSize);

      if (humanTurn) {
        System.out.print("Choose a number: ");
        userGuess = input.nextInt();
        pileSize -= userGuess;
      } else {
        if (smartNim) {
          int maxGuess = pileSize/2;
          boolean found = false;
          int i = pow2s.length-1;

          while(i >= 0) {
            if (pileSize-pow2s[i] + 1 <= maxGuess) {
              found = true;
              break;
            }
          }
          i--;

          if(found){
            cpuGuess = pileSize - pow2s[i] + 1;
            pileSize -= cpuGuess;
          } else {
            pileSize -= Math.random()*(pileSize/2)+1;
          }
        }
        pileSize -= Math.random()*(pileSize/2)+1;
      }

      humanTurn = !humanTurn;
    }
    //report the winner
    if (humanTurn) {
      System.out.println("Computer wins");
    } else {
      System.out.println("Human wins");
    }

  }
}
