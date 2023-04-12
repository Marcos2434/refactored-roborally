@tag
Feature: Position of robot

    @tag1
    Scenario: As a player, I want to be able to see the position of the robots on the board
        Given A player is created with a chosen color
        And A robot is assigned to player
        Then Robot is moved on the board
        Then Player receives position of robot