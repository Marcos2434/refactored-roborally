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
        
       
        

