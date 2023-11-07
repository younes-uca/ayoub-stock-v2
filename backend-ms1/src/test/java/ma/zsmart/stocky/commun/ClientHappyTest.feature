Feature: Client

  Background:
    * url 'http://localhost:8036/api/admin/client/'


  Scenario: POST Client and GET it by ID
    * def postBody =
    """
    {
    "cin": "cin-0",
    "nom": "nom-0",
    "prenom": "prenom-0",
    "telephone": "telephone-0",
    "adresse": "adresse-0",
    "description": "description-0",
    "creance": "0",




    """
    Given path ''
    And request postBody
    When method POST
    Then status 201

    * def output = response.output

    Given path 'id', output.id
    When method GET
    Then status 200


  Scenario: DELETE Client and GET all

    Given path 'reference/order-5'
    When method DELETE
    Then status 200

    * def output = response.output

    Given path ''
    When method GET
    Then status 204
    # Todo: 200 in case there is other orders, otherwise 204 if no order in DB




