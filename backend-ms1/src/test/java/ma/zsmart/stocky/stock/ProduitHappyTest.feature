Feature: Produit

  Background:
    * url 'http://localhost:8036/api/admin/produit/'


  Scenario: POST Produit and GET it by ID
    * def postBody =
    """
    {
    "reference": "reference-0",
    "barCode": "barCode-0",
    "designation": "designation-0",
    "quantite": "0",
    "prixAchatMoyen": "0",
    "prixVente": "0",
    "pathPhoto": "pathPhoto-0",
    "seuilAlerte": "0",
    "description": "description-0",

    "entrepriseSociete": {"id":"0"},
    "categorie": {"id":"0"},
    "marque": {"id":"0"},
    "uniteMesure": {"id":"0"},


        "stocks": [
            {
                    "produit": {"id":"0"},
                    "depot": {"id":"0"},
                    "quantite": "0",
            },
            {
                    "produit": {"id":"0"},
                    "depot": {"id":"0"},
                    "quantite": "0",
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


  Scenario: DELETE Produit and GET all

    Given path 'reference/order-5'
    When method DELETE
    Then status 200

    * def output = response.output

    Given path ''
    When method GET
    Then status 204
    # Todo: 200 in case there is other orders, otherwise 204 if no order in DB




