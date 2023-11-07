Feature: Inventaire

  Background:
    * url 'http://localhost:8036/api/admin/inventaire/'


  Scenario: POST Inventaire and GET it by ID
    * def postBody =
    """
    {
    "reference": "reference-0",
    "description": "description-0",

    "entrepriseSociete": {"id":"0"},


        "inventaireItems": [
            {
                    "produit": {"id":"0"},
                    "quantiteEstime": "0",
                    "quantiteReelle": "0",
                    "inventaire": {"id":"0"},
            },
            {
                    "produit": {"id":"0"},
                    "quantiteEstime": "0",
                    "quantiteReelle": "0",
                    "inventaire": {"id":"0"},
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


  Scenario: DELETE Inventaire and GET all

    Given path 'reference/order-5'
    When method DELETE
    Then status 200

    * def output = response.output

    Given path ''
    When method GET
    Then status 204
    # Todo: 200 in case there is other orders, otherwise 204 if no order in DB




