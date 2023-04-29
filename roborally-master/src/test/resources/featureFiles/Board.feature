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
        Scenario: A robot walks into a wall and is unable to move
        Given A layout, a board is created. And a position is created
        Then the robot tries to move throug a wall and can't move

    @tag6
        Scenario: As a Board, i want to be able to add players to the player list.
        Given A Board and four players
        Then Add the players to the player list

 #   @tag7
  #      Scenario:   As a Board, if a players robot have the same position as any other players in the board 
   #                 it cannot be added
    #    Given A Board and four players
     #   Then Add the player is not added if they have the same position
    
   # @tag8
    #    Scenario: As a Board, if a players robot has the same Color as another player the player cannot be added
     #   Given A Board and four players
      #  Then Add the player is not added if they have the same RobotColor
    
    @tag9
        Scenario: As a Board with players, when a player moves a robot, the position is updated in the playerlist.
        Given A Board and four players
        When the robots move
        Then The robots position is still the same in playerlist

    @tag10
        Scenario: As a Lazertile i want to be a walltile that can shoot a lazer.
        Given A Board and four players
        When A robot is placed to be hit by the lazer tile
        Then The robot takes damge
        When A robot tries to move trough the wall
        Then It is unable to
    
    @tag11
        Scenario: As a BeltTile, if a player is placed on top of me, want to move the robot
        Given A Board and four players
        When A robot is placed on the BeltTile
        Then The robot is pushed in the direction of the belt.
    
    @tag12
        Scenario: As a BeltTile with intensity 2, if a player is placed on top of me but the next tile is not a belt tile, 
                i cant push him two spots.
        Given A Board and four players
        When A robot is placed on the BeltTile with intensity two where the tile after is no a belt tile
        Then The robot is pushed one space 
    
    @tag13 
        Scenario: As a beltTile with intensity 2, I move a player two sapces when there is a Belttile on the next space
        Given A Board and four players
        When A robot is placed on the BeltTile with intensity two where the tile after is a belt tile
        Then The robot is pushed two space 

    @tag14
        Scenario: As a beltTile with intensity 2, If the next belt has a diferent direction, the second step is in that direction
        Given A Board and four players
        When A robot is placed on the BeltTile with intensity two where the tile after is a belt tile with different direction
        Then The robot is pushed twice in different directions.

    @tag15
        Scenario: A board can run and apply the effectfunctions of all tiles on the Board
        Given A Board and four players with different starting points
        When robots are placed on tiles and allTileEffect is called
        Then Each robot is effected accordingly


    @tag16 
        Scenario: As the board, i want to be able to activate the players robots registers one by one.
        Given A clean board and 2 players 
        When The board activates the registers
        Then The Robots follow the register sequence
    
    @tag17
        Scenario: As the board When activating all registers, robots push eachother, and deal damage with lazers
        Given A clean board and 2 players 
        When The board activates the registers in a way that makes them push eachother
        Then The robots respond accordingly
    
    @tag18
        Scenario: As the board When activating all registers, I want to activate all Tiles after each round.
        Given A Board and four players with different starting points
        When The board activates the registers in a way that makes them walk on top of tiles with effects 
        Then The robots are affected acordingly.

    @tag19
        Scenario: When a robot walks over a checkpoint tile, the checkpoint is added to the robots list of checkpoints
        Given A Board and four players with different starting points
        When A robot walks over the next ceckpoint 
        Then it is added to the checkpoints    

    @tag20
        Scenario: When a robot walks over a checkpoint tile that is too far ahead, the checkpoint is not added to the robots list of checkpoints
        Given A Board and four players with different starting points
        When A robot walks over the wrong ceckpoint 
        Then it is not added to the checkpoints    
    
    @tag21 
        Scenario: When A robot dies, but the checkpoints it has aquired are occupied, then it spawns on its starting position and kills any robot there. 
        Given  A Board and four players with different starting points
        When A robot walks over a checkpoint and then dies while the its checkpoint is occupied
        Then it spawns at the stating position
    
    @tag22
        Scenario: A repairTile wil reset the damage of  robot
        Given A Board and four players with different starting points
        When A robot has taken damage and walks on top of a repairTile
        Then The robot heal for all the damage
