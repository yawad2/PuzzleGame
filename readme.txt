
How to Play the puzzle:

- validation mode = the program asks the user to input a puzzle. it then prints that puzzle and asks for a move sequence. After scanning that, it solves the puzzle according to it and then checks if it matches one of the answers. If they match, it prints "Success!". If they don't, it prints "Failed!".

- interactive mode = the program asks the user whether they want an easy, medium, or hard puzzle. 
   *easy: it generates a puzzle that can be solved in 15 moves or less. 

   *medium: it generates a puzzle that can be solved in 20 moves or less. 

   *hard: it generates a puzzle that can be solved in 25 moves or less. 

- After each move the user inputs, the program checks if the puzzle is solved. If the move is invalid, it prints "invalid move. Try again!". 
- If the puzzle is solved, it exits the loop and prints a congratulatory message. If it's not solved, it keeps scanning input from user.

Notes:
for loops were used to randomize the arrays according to difficulty levels. a random number from 0 to 3 was generated, and for each number, a move was simulated.
the longer the loops the harder the puzzle. a lot of numbers were tested and 15, 20, and 25 worked the best. Sometimes the easy puzzle was too easy and the difficulty levels overlapped. 
