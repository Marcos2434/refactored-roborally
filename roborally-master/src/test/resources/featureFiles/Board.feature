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

    @tag6
        Scenario: As a Board, i want to be able to add players to the player list.
        Given A Board and four players
        Then Add the players to the player list

    @tag7
        Scenario:   As a Board, if a players robot have the same position as any other players in the board 
                    it cannot be added
        Given A Board and four players
        Then Add the player is not added if they have the same position
    
    @tag8
        Scenario: As a Board, if a players robot has the same Color as another player the player cannot be added
        Given A Board and four players
        Then Add the player is not added if they have the same Color
    
    @tag9
        Scenario: As a Board with players, when a player moves a robot, the position is updated in the playerlist.
        Given A Board and four players
        When the robots move
        Then The robots position is still the same in playerlist

    @tag5 
        Scenario: A robot walks into a wall and is unable to move
        Given A layout, a board is created. And a position is created
        When the robot walks into a wall
        Then The robot is unable to move