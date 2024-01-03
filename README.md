# Hangman Game
### About ###
Upon running the program, a graphical window appears, representing the Hangman game interface.
The program randomly selects a word from a predefined list.
The Hangman figure is set up with an initial frame, rope, and blank lines for each letter in the word.
The user interacts by entering a letter in the provided *TextField* and pressing Enter.
The program processes the user's guess, checking if it matches any letters in the hidden word.
If correct, the corresponding letters are revealed, and the Hangman figure remains unchanged.
If incorrect, a part of the Hangman figure is gradually drawn, and the remaining guesses decrease.
#### Visual Feedback ####
The Hangman figure includes a head, torso, arms, and legs. Each incorrect guess reveals a new part of the figure.
#### Winning the Game ####
If the user correctly guesses all the letters in the word, a congratulatory message is displayed.
#### Losing the Game ####
If the user exhausts the allowed number of incorrect guesses, a game over message is displayed along with the correct word.
#### Resetting the Game ####
Users have the option to reset the game by clicking the *Reset* button.
This initializes a new word, resets the Hangman figure, and allows for a new round of the game.
#### Visual Appeal ####
The game interface is visually appealing, with a gradient background and well-designed Hangman components.
#### Outcome Display ####
The final outcome (win or lose) is displayed on the interface.
The user can see whether they successfully guessed the word or if the Hangman figure was completed.
