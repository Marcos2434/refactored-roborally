@tag
Feature: Player receives cards from the deck
    @tag1
        Scenario: As a player i want to generate deck of cards
            Given A player is created
            Then A deck of cards is generated
            
    @tag2
     Scenario: As a player I want to receive 9 cards from the deck
         Given A player is created with a chosen color for the robot and a deck is generated 
         When The player receives 9 cards from the deck
         Then The player has 9 cards in his hand
    
    
    
    @tag4
    Scenario: As a player i want to be able to choose 5 cards out of my hand
          Given A player is created with a chosen color for the robot and a deck is generated 
          When The player receives 9 cards from the deck and chooses 5 of them
          Then The player has 5 cards in the register

    @tag5                   
    Scenario: As a player I want to have less cards in my hand after I put them in my register
        Given A player is created with a chosen color for the robot and a deck is generated
        When The player receives 9 cards from the deck and chooses 5 of them
        Then The player has 4 cards in his hand

     @tag6 
    Scenario: As a player I want to draw my cards from a shuffeled deck 
        Given A player is created with a chosen color for the robot and a deck is generated
        When The player receives 9 cards from the deck
        Then The cards are shuffeled     

    @tag7
        Scenario: There are different action cards that with different effects
        Given three robots
        When each robot gets a diffenret card
        Then they act acordingly    
    

    