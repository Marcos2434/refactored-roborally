@tag
Feature: Boardfunctions

    @tag1
    Scenario: A board can be created
        Given A layout, a board is created. And a position is created


    @tag2
    Scenario: As a player i want to be able to extract the Tile from the bord with a position
        Given A layout, a board is created. And a position is created
        Then Show me what Tile it is