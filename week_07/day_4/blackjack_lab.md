# Lab

## Pair Programming Lab - Blackjack

Using our start point, simulate a game of "BlackJack".

To start off with you should be working in a TDD fashion and creating tests for your classes.

## MVP
- Draw a class diagram
- Deal two cards to the dealer and the player
- Compare the hands
- Determine the winner from who has the highest value hand
- Allow the player to "twist" or "stick" (Player go bust if hand value exceeds 21 and they automatically lose the round). 

### Additional notes

- To start, the Game class will give two cards to each player and two cards to the dealer. 

- The Game will then take a decision on whether the player wants to twist or stand and then run a turn.

- The turn will deal a card to a player if they decide to twist. If the total value is greater than 21, they will lose. 

- If the player did not lose, the dealer will get a card if the dealer total value is less than 16. If the dealer's total value is greater than 21, they will lose. 

- If the player decides to stand.
    + If the dealer total value is less than 16, they must hit. If they get over 21 then they lose.
    + Else compare both hands, highest wins.