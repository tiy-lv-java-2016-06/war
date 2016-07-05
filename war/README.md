# WAR!!!!

This card game is popular with kids but often leads to boredom since it can take hours to play.  Fortunately, you don't have to worry about hours since you are an programmer.

The game is simple:
* A full deck of cards is dealt to players
* Each round the players flip the top card in their hand
* High card wins both cards which go back into the winner's deck
* In the event of a tie WAR!!!
  * Each player puts 4 cards face down then the last card face up
  * Winner takes all cards
* When a player runs out of cards they lose

## Normal Mode

Build the game out for 2 players.  No input interaction is needed as the game
requires 0 strategy to play. You MUST write tests for all methods but this
action will actually make your programming faster.  Additionally, you may want
to use a static factory to generate a standard deck of cards.

### Requirements
* At least 3 classes (you will probably want more)
* Tests for all methods that contain logic (no getter/setters)
* Javadoc blocks for all methods
* Use ENUM for card suits and ranks

Output should look similar to

```
Let's play war!
*** Round Starting ***
Fred plays Ace of Spades
George plays King of Hearts
Fred wins with Ace of Spades

*** Round Starting ***
Fred plays 10 of Hearts
George plays 10 of Diamonds
#### WAR!!!! ####
Fred plays 5 of Hearts
George plays Jack of Spades
George wins the WAR
```

## Hard Mode

Make the game work for any number of players.

## External Links
* [Github Repo](https://github.com/tiy-lv-java-2016-06/war)
