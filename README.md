# Hangman Game
## About ##
Upon running the program, a graphical window appears, representing the Hangman game interface.
The program randomly selects a word from a predefined list.
The Hangman figure is set up with an initial frame, rope, and blank lines for each letter in the word.
The user interacts by entering a letter in the provided *TextField* and pressing Enter.
The program processes the user's guess, checking if it matches any letters in the hidden word.
If correct, the corresponding letters are revealed, and the Hangman figure remains unchanged.
If incorrect, a part of the Hangman figure is gradually drawn, and the remaining guesses decrease.
### Visual Appeal ###
The game interface is visually appealing, with a gradient background and well-designed Hangman components.
<img src="https://github.com/Sam221104/Hangman-Game/assets/112628971/7322507f-86b0-4162-9a38-e4ecb3c173fb" width="200">

### Visual Feedback ###
The Hangman figure includes a head, torso, arms, and legs. Each incorrect guess reveals a new part of the figure.
![image](https://github.com/Sam221104/Hangman-Game/assets/112628971/558074b3-4842-4db7-8f7e-14711bf3d802)
![image](https://github.com/Sam221104/Hangman-Game/assets/112628971/ff0c29c6-34a2-4851-b96d-eb4358101ae2)

### Winning the Game ###
If the user correctly guesses all the letters in the word, a congratulatory message is displayed.
![image](https://github.com/Sam221104/Hangman-Game/assets/112628971/272b2fa2-6889-4866-b0d7-4f46024d4892)

### Losing the Game ###
If the user exhausts the allowed number of incorrect guesses, a game over message is displayed along with the correct word.
![image](https://github.com/Sam221104/Hangman-Game/assets/112628971/96902b00-66ee-4743-a4ed-dea7589210f7)
### Resetting the Game ###
Users have the option to reset the game by clicking the *Reset* button.
This initializes a new word, resets the Hangman figure, and allows for a new round of the game.
![image](https://github.com/Sam221104/Hangman-Game/assets/112628971/adf2debd-3cba-4ee8-894e-a92965e7f009)

### Outcome Display ###
The final outcome (win or lose) is displayed on the interface.
The user can see whether they successfully guessed the word or if the Hangman figure was completed.
![image](https://github.com/Sam221104/Hangman-Game/assets/112628971/3d7e71be-ce07-4cb8-b7ef-02b6e1ae1a0e)
