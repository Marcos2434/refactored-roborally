@tag
Feature: Robot Selection

    @tag1
    Scenario: As a player I want to have a robot assigned
        Given A player is created with a chosen color for the robot
        Then A robot is assigned to the player
    
    @tag2
    Scenario: As a player, I want to know the direction of my robot
        Given A player is created with a chosen color for the robot
        And A robot is assigned to the player
        Then The robot is facing a direction

    @tag3
        Scenario: As an AI i want to be able to draw cards from a deck
        Given Two AI'
        When they draw cards
        Then their hands are not empty
    
 


    
    


  
        
    