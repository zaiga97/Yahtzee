# Yahtzee
A java implementation of the popular game of yahtzee.

## The game

The game of yahtzee is a popular chance game that uses dices to score points on a table.
[Here](https://en.wikipedia.org/wiki/gameLogic.Yahtzee) are the basic rules of the game. Note that there are multiple variation of the game, I will not implement this one but one with slightly different rules.
[Here]() are the rules of the implemented game.
The game will (at least for the moment) be and offline single player with the player aiming to get the higher possible score.

## The implementation

For implementing the game I will use a TDD approach and gradle for build automation.

To do list:

- [x] Working game using the console for I/O.
  - [x] Make the original ScoringTable for the game.
  - [x] Make the game go till the end/ give an option to exit
  - [x] Refactor StandardView so it is useful.
  - [x] Create the end of the game.
  - [x] Fix game logic so one can't score same category more than once
- [x] Refactoring/Bug fixing
  - [x] Fix input for error handling
  - [x] Refactor the scoring
  - [x] Make already scored categories visible in gw
  - [x] Fix so one can choose not to reroll
- [x] Make documentation for all the project.
- [ ] Refactor the standard game view to make it more usable.
- [ ] Refactor the menu out of the interface.
- [x] Add high scores.
- [ ] Add local multiplayer.
- [ ] Add a graphic interface.
