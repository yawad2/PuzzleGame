/*
 Name: Yousra Awad
 Email: yawad2@u.rochester.edu
 
 Name: Apsharee Ireen
 Email: aireen@u.rochester.edu
  */
  import java.util.Scanner;
  public class Validate extends Puzzle{
      public int [][]userArray = new int [4][4];
      public static void main(String[] args) {
          Scanner s = new Scanner(System.in);
          Puzzle puzzle = new Puzzle();
          System.out.println("Please enter a puzzle"); // prompting the user to enter 
          int [][]userArray = puzzle.getStoredArray(); // get array from user input
          System.out.println("Please enter a move sequence"); // ask the user to enter a move sequence
          System.out.println();
          printArray(userArray); // print the puzzle that the user inputed 
          String userLine = s.nextLine(); // scan the next line for move sequence
          for (int i=0; i< userLine.length(); i++){ // go over the sequence and move up for U, down for D, left for L, and right for R
              if(userLine.charAt(i) == 'U'){ 
                  userArray = swapUp(userArray, 0);
              }
              if(userLine.charAt(i) == 'D'){
                  userArray = swapDown(userArray, 0);
              }
              if(userLine.charAt(i) == 'R'){
                  userArray = swapRight(userArray, 0);
              }
              if(userLine.charAt(i) == 'L'){
                  userArray = swapLeft(userArray, 0);
              }
              if (i+1 == userLine.length()){// at the end, check if the puzzle is solved and print success if solved, failed if not solved 
                  if(checkPuzz(userArray)== true){
                      System.out.println("Success!");
                  }
                  else {
                      System.out.println("Failed!");
                  }
              }
          }
      }
  }
  