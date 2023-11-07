Feature: VenteItem

  Background:
    * url 'http://localhost:8036/api/admin/venteItem/'


  Scenario: POST Vente item and GET it by ID
    * def postBody =
    """
    {
    "barCode": "barCode-0",
    "quantite": "0",
    "quantiteAvoir": "0",
    "quantiteVendue": "0",
    "remise": "0",
    "prixUttc": "0",
    "prixUht": "0",
    "montantHt": "0",
    "montantTtc": "0",

    "produit": {"id":"0"},
    "vente": {"id":"0"},
    "depot": {"id":"0"},



    """
    Given path ''
    And request postBody
    When method POST
    Then status 201

    * def output = response.output

    Given path 'id', output.id
    When method GET
    Then status 200


  Scenario: DELETE Vente item and GET all

    Given path 'reference/order-5'
    When method DELETE
    Then status 200

    * def output = response.output

    Given path ''
    When method GET
    Then status 204
    # Todo: 200 in case there is other orders, otherwise 204 if no order in DB




