/*
 Name: Yousra Awad
 Email: yawad2@u.rochester.edu
 
 Name: Apsharee Ireen
 Email: aireen@u.rochester.edu
  */
  import java.util.Scanner;
  import java.util.Random;
  public class Puzzle {
          int [][] unsortedPuzz = new int[4][4];
          static int[][] arr2 = new int[4][4];
          private static int [][] ans2 = arrValues(arr2);
          static int[][] arr = new int[4][4];
          private static int [][] ans1 = arrValues2(arr);
          Scanner scnr = new Scanner(System.in);
          Scanner sc = new Scanner(System.in);
          Scanner s = new Scanner(System.in);
          public int[][] getAns1(){ // a method to get ans1 which is one of the two possible answers for the puzzle
              return ans1;
          }
          public int[][] getAns2(){ // a method to get ans2 which is one of the two possible answers for the puzzle
              return ans2;
          }
      public static int [][] arrValues(int [][] array){ // a method to store array values from 1-15 and 0 at the end
          int val = 1;
          for (int i=0; i < 4; i++){
              for (int j=0; j < 4; j++){
                  array [i][j] = val;
                  val +=1;
                  if (val == 17){
                      array [i][j] = 0;
                  }
              }
          }
          return array;
      }
      public static int [][] arrValues2(int [][] array){ // a method to store array values from 0-15
          int val = 0;
          for (int i=0; i < 4; i++){
              for (int j=0; j < 4; j++){
                  array [i][j] = val;
                  val +=1;
              }
          }
          return array;
      }
      public static void printArray(int [][] array){ // a method to print arrays
          for (int i=0; i < array.length; i++){
              for (int j=0; j < array.length; j++){
                  System.out.print(array[i][j] + " ");
              }
              System.out.println();
          }
      }
  
      private static int findX(int [][] array,  int element){ // a method to find the x-coordinate of a 2D array 
          int x = 0;
          for (int i = 0; i < array.length; i++){
              for(int j= 0; j < array.length; j++){
                  if (array [i][j] == element){
                      x= j;
                      break;
                  }
              }
          }
          return x;
      }
      public static int getFindX(int [][] array,  int element){ // a method to get one index (x-coordinate) of a 2D array
          return findX(array,  element);
      }
      
      private static int findY(int [][] array, int element){ // a method to find the y-coordinate of a 2D array 
          int y = 0;
          for (int i = 0; i < array.length; i++){
              for(int j= 0; j < array.length; j++){
                  if (array [i][j] == element){
                      y= i;
                      break;
                  }
              }
          }
          return y;
      }
      public static int getFindY(int [][] array,  int element){ // a method to get one index (y-coordinate) of a 2D array
          return findY(array,  element);
      }
      public static int [][] swapLeft (int [][] arr, int toSwap){ // a method to swap to the left
          int [][] empty = {{0,0,0,0}, {0,0,0,0}, {0,0,0,0},{0,0,0,0}};
          int yPosition = findY(arr, toSwap);
          int orgPosition = findX (arr, toSwap);
          int newPosition = orgPosition - 1;
          if (newPosition >= 0){
              int orgElement = arr[yPosition][newPosition];
              arr[yPosition][newPosition] = toSwap;
              arr[yPosition][orgPosition] = orgElement;
          }
          return arr;
      }
  
      public static int [][] swapRight (int [][] arr, int toSwap){ // a method to swap to the right
          int [][] empty = {{0,0,0,0}, {0,0,0,0}, {0,0,0,0},{0,0,0,0}};
          int yPosition = findY(arr, toSwap);
          int orgPosition = findX (arr, toSwap);
          int newPosition = orgPosition + 1;
          if (newPosition < 4){
              int orgElement = arr[yPosition][newPosition];
              arr[yPosition][newPosition] = toSwap;
              arr[yPosition][orgPosition] = orgElement;
          }
          return arr;
      }
      public static int [][] swapUp (int [][] arr, int toSwap){ // a method to swap up
          int [][] empty = {{0,0,0,0}, {0,0,0,0}, {0,0,0,0},{0,0,0,0}};
          int XPosition = findX(arr, toSwap);
          int orgPosition = findY (arr, toSwap);
          int newPosition = orgPosition - 1;
          if (newPosition >= 0){
              int orgElement = arr[newPosition][XPosition];
              arr[newPosition][XPosition] = toSwap;
              arr[orgPosition][XPosition] = orgElement;
          }
          return arr;
      }
      public static int [][] swapDown (int [][] arr, int toSwap){ // a method to swap down
          int [][] empty = {{0,0,0,0}, {0,0,0,0}, {0,0,0,0},{0,0,0,0}};
          int XPosition = findX(arr, toSwap);
          int orgPosition = findY (arr, toSwap);
          int newPosition = orgPosition + 1;
          if (newPosition < 4){
              int orgElement = arr[newPosition][XPosition];
              arr[newPosition][XPosition] = toSwap;
              arr[orgPosition][XPosition] = orgElement;
          }
          return arr;
      }
      public static int [][] clone (int [][] original, int [][] cloned){ // a method to make a copy of an array
          for (int i = 0; i < 4; i++){
              for (int j= 0; j <4; j++){
                  cloned [i][j] = original [i][j];
              }
          }
  
          return cloned;
      }
      public static boolean matchArr (int[][] arr1, int [][] arr2){ // a method to check if 2 arrays match
          for (int i=0; i<4; i++){
              for (int j=0; j<4;j++){
                  if (arr1 [i][j] != arr2[i][j]){
                      return false;
                  }
              }
          }
          return true;
      }
      private static int [][] easyPuzzle(){ // a method to generate easy puzzle that can be solved in 15 moves or less
          Random rand = new Random();
          int[][] puzz1 = new int[4][4];
          int randomNo = rand.nextInt(4);
          puzz1 = clone(ans1, puzz1);
          for(int i=0; i<15; i++){
              if (randomNo == 0){
                      puzz1 = swapLeft(puzz1, 0);
                      randomNo = rand.nextInt(4);
              }
              if (randomNo == 1){
                      puzz1 = swapDown(puzz1, 0);
                      randomNo = rand.nextInt(4);
              }
              if (randomNo == 2){
                      puzz1 = swapRight(puzz1, 0);
                      randomNo = rand.nextInt(4);
              }
              if (randomNo == 3 ){
                      puzz1 = swapUp(puzz1, 0);
                      randomNo = rand.nextInt(4);
              }
          }
          return puzz1;
          }
      public static int [][] getEasyPuzzle(){ // a method to get the generated easy puzzle
          return easyPuzzle();
      }
  
      private static int [][] difficultPuzzle(){ // a method to generate difficult puzzle that can be solved in 25 moves or less
          Random rand = new Random();
          int randomNo = rand.nextInt(4);
          int[][] puzz3 = new int[4][4];
          puzz3 = clone(ans1, puzz3);
          for (int i=0; i<25; i++){
              if (randomNo == 0){
                  puzz3 = swapRight(puzz3, 0);
                  randomNo = rand.nextInt(4);
              }
              if (randomNo == 1){
                  puzz3 = swapDown(puzz3, 0);
                  randomNo = rand.nextInt(4);
              }
              if (randomNo == 2){
                  puzz3 = swapLeft(puzz3, 0);
                  randomNo = rand.nextInt(4);
              }
              if (randomNo == 3){
                  puzz3 = swapUp(puzz3, 0);
                  randomNo = rand.nextInt(4);
              }
     }
          return puzz3;
     }
      public static int [][] getDifficultPuzzle(){ // a method to get the generated difficult puzzle
          return difficultPuzzle();
      }
      private static int[][] mediumPuzzle(){ // a method to generate medium puzzle that can be solved in 20 moves or less
          Random rand = new Random();
          int[][] puzz2 = new int[4][4];
          puzz2 = clone(ans1, puzz2);
          int randomNo = rand.nextInt(4);
          for (int i=0; i< 20; i++){
              if (randomNo == 0){
                  puzz2 = swapRight(puzz2, 0);
                  randomNo = rand.nextInt(4);
              }
              if (randomNo == 1){
                  puzz2 = swapDown(puzz2, 0);
                  randomNo = rand.nextInt(4);
              }
              if (randomNo == 2){
                  puzz2 = swapLeft(puzz2, 0);
                  randomNo = rand.nextInt(4);
              }
              if (randomNo == 3){
                  puzz2 = swapUp(puzz2, 0);
                  randomNo = rand.nextInt(4);
              }
          }
          return puzz2;
      }
      public static int[][] getMediumPuzzle(){ // a method to get the generated medium puzzle
          return mediumPuzzle();
      }
      private static int[][] storeArray(){ // a method to store array from userInput
          Scanner sc = new Scanner(System.in);
          int [][] userArray = new int[4][4];
          for (int i=0; i<4; i++){
              for (int j=0; j<4; j++){
                  userArray[i][j]= sc.nextInt();
              }
          }
          return userArray;
      }
      public static int[][] getStoredArray(){ // a method to get the array stored from userInput
          return storeArray();
      }
      public static boolean checkPuzz(int [][] arr) { // a method to check whether the puzzle is solved or not
          boolean isSolved = false;
          if (matchArr(arr, ans1)) {
              isSolved = true;
          }
          else if(matchArr(arr, ans2)) {
              isSolved = true;
          }
          else {
              isSolved = false;
          }
          return isSolved;
      }
  
  }
          
      
  
  