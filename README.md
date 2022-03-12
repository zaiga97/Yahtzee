# gameLogic.Yahtzee
A java implementation of the popular game of yahtzee.

## The game

The game of yahtzee is a popular chance game that uses dices to score points on a table.
[Here](https://en.wikipedia.org/wiki/gameLogic.Yahtzee) are the basic rules of the game. Note that there are multiple variation of the game and I will implement this as the "official" one.
The game will (at least for the moment) be and ofline single player with the player aiming to get the higher possible score.

## The implementation

For implementing the game I will use a TDD aproach and gradle for build automation.
Here is a list of features I aim to implement:

- [x] Working game using the console for I/O.
- -[x] Make the original ScoringTable for the game.
- -[x] Make the game go till the end/ give an option to exit
- -[x] Refactor StandardVfiew so it is useful.
- -[x] Create the end of the game.
- -[x] Fix game logic so one can't score same category more than once
- [ ] Refactoring/Bug fixing
- -[ ] Fix input for error handling
- -[ ] Refactor the scoring 
- [ ] Add high scores.
- [ ] Add local multiplayer.
- [ ] Add a graphic interface.
