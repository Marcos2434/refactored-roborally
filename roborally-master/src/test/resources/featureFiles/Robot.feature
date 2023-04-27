@tag
Feature: Robot Selection

    @tag1
    Scenario: As a player i want my robot to start with 3 lives
        Given A robot being created with a color and a checkpoint
        Then A robot is created with three lives
    
    @tag2
    Scenario: As a player i want to know how many lives my robot have left after loosing lives
        Given A robot being created with a color and a checkpoint
        Then The amount of lives that are left after loosing 2 lives in my robot can be determined
    
    @tag3
    Scenario: As a player i want to know how much damage i have taken
    Given A robot being created with a color and a checkpoint
    Then The robot recieved 4 damage and shows it

    @tag4
    Scenario: As a robot, when i take 10 damage, i loose a life and, reset damage and go back to last checkpoint.
        Given A robot being created with a color and a checkpoint
        When The robot takes 10 damage.
        Then The robot looses a lifetoken, resets damage and go back to last checkpoint.
    
    @tag5
    Scenario: As a robot, i need to be able to turn and show what direction i am facing.
        Given A robot being created with a color and a checkpoint
        Then the robot turns and it can display the direction
        
    @tag6 
    Scenario: When a robot moves around in a circle
        Given A robot being created with a color and a checkpoint
        Then It turns to the right and moves forward and backwards 4 times
        
    @tag7
    Scenario: A robot moves over an edge
        Given A robot being created with a color and a checkpoint
        When A robot moves over the edge
        Then The robot looses a lifetoken, resets damage and go back to last checkpoint.
    
    @tag8
    Scenario: As a robot, when i move into another robot and have movement left, the other robot is pushed the rest of the way
        Given Two robots being created 
        When The robots are beside eachother and one robot tries to move through the other
        Then the other robot is pushed  
    
    @tag9 
    Scenario: As a robot, when i move, i want to ocupie the tile i am on.
        Given A robot being created with a color and a checkpoint
        Then i move. The Tile behind me is not ocupied and the tile i moved to is.

    @tag10
    Scenario: As a robot, I want to be able to shoot a lazer that deals damage
        Given Two robots being created 
        When The robots are facing eachother and fire their lazer 
        Then both robots take dmg.
        
       
    @tag11 
    Scenario: As a robot I want to move according to the description on a card. 
        Given A robot is being created with a color and a checkpoint
        When The robot recieves a card 
        Then The robot moves according to the card desciription
    
    @tag12 
    Scenario:   As a robot, if a robot moves and pushes another robot, but there are robots behind this robot,
                the other robots move too.
        Given Four robots in a row
        When when a robot in the end moves
        Then All the robots are pushed
    
    @tag13
    Scenario:   As a robot, when i push more than one robot, they all take damage
        Given Four robots in a row
        When when a robot in the end moves
        Then All robots take damage

    @tag14 
    Scenario: As a robot, when trying to push one or more robots, but the last robot is unable to move because of a wall,
             no movement is done
        Given Four robots in a row 
        When when the robot opposite the wall moves into the row of robots
        Then Noone moves
    
    @tag15
        Scenario: As a robot, when trying to push one or more robots, but the last robot is unable to move because of a wall,
             All robots except for the one trying to move takes damage
        Given Four robots in a row 
        When when the robot opposite the wall moves into the row of robots
        Then Three robots take damage

    @tag16
        Scenario: As a robot, if i push another robot over the edge it dies
        Given Two robots being created 
        When One robot pushes the other over the edge
        Then The other robot dies and respawns
    
    @tag17 
        Scenario: A robot that have used a program card before can use the same card again by using the Again card
        Given Two robots being created 
        When one robot has a register consiting of one or more Again cards
        Then they will perform the effect of the last run card.

    

    
    

