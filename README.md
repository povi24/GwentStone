Andreea Povarnă, 324CA
OOP Homework - GwentStone

Overview

	The project aims to simulate a card game similar to HeartStone, named
GwentStone. It allows players to choose a deck of cards, place cards on the 
board, attack the other player's cards and use different abilities of each card.
	
	In order to understand the logic of the game more easily, I tried to
implement as many classes as possible that are connected to each other in the 
following way:
	
- the Card class is like a root, being an abstract class that contains the
fields common to all types of cards.


- the Minion class extends the Card class and has special fields specific to
this type of cards. Furthermore, the Berserker, Disciple, Goliath, Sentinel,
TheCursedOne, TheRipper, Warden cards will be of the MInion type and will have
specific methods that describe their ability and also retain the position they
can be placed on the board (front or back) - the minion abstract class together
with each minion is in the minion package

- the Hero class expands the Card class and retains the heroes who have a
special role in the game, unlike the minion cards. They will not be placed on 
the board, and killing them will win the game - the Hero abstract class together
with each hero is in the hero package

- the Environment class extends the Card class and retains the cards of this
type that have the property that they cannot be placed on the game board, and
their use affects an entire row of the opponent - the abstract class Environment
together with each card of this type is in the environment package

-------------------------------------------------------------------------------

	For the easiest possible testing of the homework and to implement different
functionalities in turn, we started by creating an initial game, where we 
initialize all the necessary data such as:
- hero assignment for each player
- choosing a deck of cards to be shuffled
- placing the first card from the chosen deck in the player's hand
- the mana received by each player at the beginning of the game
- the initiation of the game board
- counter for the number of rounds played
- a variable that holds the player who starts the game


	Therefore, in all the classes that implement different functionalities,
we will receive as a parameter an object of the StartingTHeGame type that will
start the game.

	In order to try to have the best possible modularization, each command
is implemented within a class. Thus, in the DebugCommands package there are the
debug commands mentioned in the homework, and in GameplayCommands those
that test different actions described in the homework
	
-------------------------------------------------------------------------------

some feedback :)

It was a homework where I really learned a lot of new things, which showed me how
important good modularization is in an object-oriented programming subject, and
although I had a very slow start and I didn't manage to implement the whole topic,
with I will definitely continue because i beliebve that it is a very cool project
to put in the portfolio.

