@RoomDB
Feature: Room Validation
  Scenario: Validate Room By Room Number
    Given user connects to database
    When get all "room_number" as a list from "room"
    Then verify list contains "75634221"
    And close the connection