@tag
Feature: BoardController functions

    @tag1 
        Scenario: The boardController is able to return a player by name:
        Given a playerlist 
        When Searching for a player by its name
        Then the player is returned

    @tag2 
        Scenario: The boardController is able to return a player by Color:
        Given a playerlist 
        When Searching for a player by its Color
        Then the player is returned