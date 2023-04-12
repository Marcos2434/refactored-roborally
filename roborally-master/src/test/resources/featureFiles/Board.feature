@tag
Feature: Boardfunctions

    @tag1
    Scenario: A board can be created
        Given A layout, a board is created. And a position is created


    @tag2
    Scenario: As a player i want to be able to extract the Tile from the bord with a position
        Given A layout, a board is created. And a position is created
        Then Show me what Tile it is
    
    @tag3
        Scenario: A robot steps on a holetile and dies.
        Given A layout, a board is created. And a position is created
        When the robot steps on a holetile
        Then The robot Dies

    @tag4
        Scenario: a walltile is created and can show its name
        Given A layout, a board is created. And a position is created
        Then Show me a wall tile

    @tag5 
        Scenario: A robot walks into a wall and is unable to move to the next tile.
        Given A layout, a board is created. And a position is created
        Then the robot tries to move throug a wall and can't move
