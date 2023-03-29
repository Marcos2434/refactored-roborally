@tag
Feature: Player receives cards from the deck
    @tag1
        Scenario: As a player i want to generate deck of cards
            Given A player is created
            Then A deck of cards is generated
            

    @tag2
     Scenario: As a player I want to receive 9 cards from the deck
         Given A player is created with a chosen color for the robot
         And A deck is created
         When The player receives 9 cards from the deck
         Then The player has 9 cards in his hand

    
    
