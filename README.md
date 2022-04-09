# Yahtzee
A java implementation of the popular game of yahtzee.

## The game

The game of yahtzee is a popular chance game that uses dices to score points on a table.
[Here](https://en.wikipedia.org/wiki/gameLogic.Yahtzee) are the basic rules of the game. Note that there are multiple variation of the game, I will not implement this one but one with slightly different rules since I'm more familiar with this version.
The game will (at least for the moment) be and offline single player with the player aiming to get the higher possible score.

## Rules of the game
At each turn the player starts by rolling all the five dices at his disposal.
After the first roll the player may select all the dices he desires and reroll them.
This is repeated for a second time.

After this the player must score the final combination of dices into one of the possible categories.
Each category can only be scored once and the game will end when all the categories are scored.

Each category has its own rule for scoring. Here is a quick legend of the categories followed by their scoring rule:

<ul>
  <li> Upper part: </li>
    <ul>
      <li> # of 1 &rarr; Sum of all the dices with value 1.</li>
      <li> # of 2 &rarr; Sum of all the dices with value 2.</li>
      <li> # of 3 &rarr; Sum of all the dices with value 3.</li>
      <li> # of 4 &rarr; Sum of all the dices with value 4.</li>
      <li> # of 5 &rarr; Sum of all the dices with value 5.</li>
      <li> # of 6 &rarr; Sum of all the dices with value 6.</li>
      <li> Bonus &rarr; Can't be scored directly. If the player has done at least 63 points in the upper part gives a 50 point bonus.</li>
    </ul>
  <li> Lower part: </li>
    <ul>
      <li> Couple &rarr; Sum of the highest identical couple of dices.</li>
      <li> Double couple &rarr; Sum of the 2 highest couples.</li>
      <li> Tris &rarr; Sum of 3 identical dices.</li>
      <li> Poker &rarr; Sum of 4 identical dices.</li>
      <li> Small scale &rarr; 15 points if the player has this combination: {1,2,3,4,5}.</li>
      <li> Big scale &rarr; 20 points if the player has this combination: {2,3,4,5,6}.</li>
      <li> Full &rarr; Sum of all dices composing the full (tris + couple).</li>
      <li> Chance &rarr; Sum of all dices.</li>
      <li> Yahtzee &rarr; grants (50 + sum of all dices) points if the player has 5 identical dices.</li>
    </ul>
</ul>

If the player doesn't meet the requirements (e.g. scoring in tris without having 3 identical dices). He will be granted 0 points.

At the end of the game all points will be summed up and this will be the final score for the player.
The aim of the game is to obtain the highest possible score.

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
- [x] Refactor the standard game view to make it more usable.
- [ ] Refactor the menu out of the interface.
- [x] Add high scores.
- [ ] Add local multiplayer.
- [ ] Add a graphic interface.
