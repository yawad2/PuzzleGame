/*
 Name: Yousra Awad
 Email: yawad2@u.rochester.edu
 
 Name: Apsharee Ireen
 Email: aireen@u.rochester.edu
  */
  import java.util.*;
  import java.util.Random;
  public class Interact extends Puzzle{
      public static void main(String[] args) {
          int counter = 0;
          Scanner scnr = new Scanner (System.in);
          Puzzle puzzle = new Puzzle();
          System.out.println("Difficulty: Easy = 1, Medium = 2, Hard = 3"); // ask the user for their preference 
          int userInput = scnr.nextInt();
          if (userInput ==1){ // for an easy puzzle
              puzzle.unsortedPuzz = clone(puzzle.getEasyPuzzle(), puzzle.unsortedPuzz);
              printArray(puzzle.unsortedPuzz);
              System.out.println("To Move Left = L");
              System.out.println("To Move Right = R");
              System.out.println("To Move Up = U");
              System.out.println("To Move Down = D");
              }
          if (userInput == 2){ // for a medium puzzle
              puzzle.unsortedPuzz = clone(puzzle.getMediumPuzzle(), puzzle.unsortedPuzz);
              printArray(puzzle.unsortedPuzz);
              System.out.println("To Move Left = L");
              System.out.println("To Move Right = R");
              System.out.println("To Move Up = U");
              System.out.println("To Move Down = D");
          }
          if (userInput == 3){// for a hard puzzle
              puzzle.unsortedPuzz = clone(puzzle.getDifficultPuzzle(), puzzle.unsortedPuzz);
              printArray(puzzle.unsortedPuzz);
              System.out.println("To Move Left = L");
              System.out.println("To Move Right = R");
              System.out.println("To Move Up = U");
              System.out.println("To Move Down = D");
          }
          int [][] userAns;
          userAns = puzzle.unsortedPuzz;
          String userMove = scnr.next(); // scan moves from user input
          while (true) {
              if (userMove.equals("U")){ // if the user inputs U, move up
                  if (getFindY (userAns, 0) - 1 < 0){
                      System.out.println("Invalid move. Try Again!"); // if the move isn't valid, warn the user
                  }
                  if (getFindY (userAns, 0) - 1 >=0){ 
                      userAns = swapUp(userAns, 0);
                      counter++; //update the move counter value
                  }
                  if (checkPuzz(userAns)== true){ // check if the puzzle is solved and if true, exit the loop
                      break;
                  }
              }
              if (userMove.equals("D")){ // if the user inputs D, move down
                  if (getFindY (userAns, 0) + 1 >= 4) {
                      System.out.println("Invalid move. Try Again!"); // if the move isn't valid, warn the user
                  }
                  if (getFindY (userAns, 0) + 1 < 4) {
                      userAns = swapDown(userAns, 0);
                      counter++; //update the move counter value
                  }
                  if (checkPuzz(userAns)== true){ // check if the puzzle is solved and if true, exit the loop
                      break;
                  }
              }
              if (userMove.equals("L")){ // if the user inputs L, move left
                  if (getFindX (userAns, 0) - 1 < 0) {
                      System.out.println("Invalid move. Try Again!"); // if the move isn't valid, warn the user
                  }
                  if (getFindX (userAns, 0) -1 >= 0){
                      userAns = swapLeft(userAns, 0);
                      counter++; //update the move counter value
                  }
                  if (checkPuzz(userAns)== true){ // check if the puzzle is solved and if true, exit the loop
                      break;
                  }
              }
              if (userMove.equals("R")){ // if the user inputs R, move right
                  if (getFindX (userAns, 0) + 1 >= 4){
                      System.out.println("Invalid move. Try Again!"); // if the move isn't valid, warn the user
                  }
                  if (getFindX (userAns, 0) + 1 < 4){
                      userAns = swapRight(userAns, 0);
                      counter++; //update the move counter value
                  }
                  if (checkPuzz(userAns)== true){ // check if the puzzle is solved and if true, exit the loop
                      break;
                  }
              }
              printArray(userAns);
              userMove = scnr.next();
          }
          if (checkPuzz(userAns)== true){  // check if the puzzle is solved and if true, exit the loop and print a congratulatory message
              printArray(userAns);
              System.out.println("Congratulations! You solved the puzzle in " + counter + " moves.");
          }
      }
  }