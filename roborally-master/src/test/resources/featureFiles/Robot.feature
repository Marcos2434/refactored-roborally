@tag
Feature: Robot Selection

    @tag1
    Scenario: As a player i want my robot to have 3 lifes
        Given A robot being created
        Then A robot is created with three lives
    
    @tag2
    Scenario: As a player i want to know how many lives my robot have left after loosing lives
        Given A robot being created with a color
        Then The amount of lives that are left after loosing 2 lives in my robot can be determined

