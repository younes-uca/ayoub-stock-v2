Feature: Permutation

  Background:
    * url 'http://localhost:8036/api/admin/permutation/'


  Scenario: POST Permutation and GET it by ID
    * def postBody =
    """
    {
    "description": "description-0",



        "permutationItems": [
            {
                    "produit": {"id":"0"},
                    "quantite": "0",
                    "depotOrigine": {"id":"0"},
                    "depotDestination": {"id":"0"},
                    "permutation": {"id":"0"},
            },
            {
                    "produit": {"id":"0"},
                    "quantite": "0",
                    "depotOrigine": {"id":"0"},
                    "depotDestination": {"id":"0"},
                    "permutation": {"id":"0"},
            }
        ]

    """
    Given path ''
    And request postBody
    When method POST
    Then status 201

    * def output = response.output

    Given path 'id', output.id
    When method GET
    Then status 200


  Scenario: DELETE Permutation and GET all

    Given path 'reference/order-5'
    When method DELETE
    Then status 200

    * def output = response.output

    Given path ''
    When method GET
    Then status 204
    # Todo: 200 in case there is other orders, otherwise 204 if no order in DB




