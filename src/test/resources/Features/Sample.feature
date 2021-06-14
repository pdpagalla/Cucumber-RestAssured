Feature: Social Network backend services test scenarios

  Scenario: User can make a post
    Given I configure base url for the users request
    When I send POST request for make post
    Then I verify id is returned in response
    And I verify status code to be 201

  Scenario: User can comment on a post
    Given I configure base url for the users request
    When I send POST request for make comment
    Then I verify id is returned in response
    And I verify status code to be 201

  Scenario: Get the list of users
    Given I configure base url for the users request
    When I send GET request
    Then I verify response parameters for get users
    And I verify status code to be 200

  Scenario: Get the list of users with invalid resource
    Given I configure base url for the users request with invalid resource
    When I send GET request
    Then I verify status code to be 404

  Scenario: Get list of posts
    Given I configure base url for the posts request
    When I send GET request
    Then I verify response parameters for get posts
    Then I verify status code to be 200

  Scenario: Get the list of posts with invalid resource
    Given I configure base url for the users request with invalid resource
    When I send GET request
    Then I verify status code to be 404

  Scenario: Get list of comments
    Given I configure base url for the comments request
    When I send GET request
    Then I verify response parameters for get comments
    Then I verify status code to be 200

  Scenario: Get the list of comments with invalid resource
    Given I configure base url for the users request with invalid resource
    When I send GET request
    Then I verify status code to be 404
