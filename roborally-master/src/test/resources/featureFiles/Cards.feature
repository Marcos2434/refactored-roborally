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
    
    #@tag3
    #Scenario: As a player I want to be able to have different kinds of cards in my generated deck
     #       Given A player is created with a chosen color for the robot and a deck is generated 
      #      Then The deck has 5 different kinds of cards in it
    
    @tag4
    Scenario: As a player i want to be able to choose 5 cards out of my hand
          Given A player is created with a chosen color for the robot and a deck is generated 
          When The player receives 9 cards from the deck and chooses 5 of them
          Then The player has 5 cards in the register
          
   #@tag6
   #Scenario: As a player I want to be able to have all necessary programming cards in my deck 
    #    Given A player is created with a chosen color for the robot and a deck is generated
     #   Then The deck has all necessary programming cards in it

    @tag7                   
    Scenario: As a player I want to have less cards in my hand after I put them in my register
        Given A player is created with a chosen color for the robot and a deck is generated
        When The player receives 9 cards from the deck and chooses 5 of them
        Then The player has 4 cards in his hand

     @tag8 
    Scenario: As a player I want to draw my cards from a shuffeled deck 
         Given A player is created with a chosen color for the robot and a deck is generated
         When The player receives 9 cards from the deck
        Then The cards are shuffeled