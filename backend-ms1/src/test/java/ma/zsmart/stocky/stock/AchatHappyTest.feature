Feature: Achat

  Background:
    * url 'http://localhost:8036/api/admin/achat/'


  Scenario: POST Achat and GET it by ID
    * def postBody =
    """
    {
    "montantHt": "0",
    "tauxTva": "0",
    "montantTva": "0",
    "montantTtc": "0",
    "description": "description-0",

    "entrepriseSociete": {"id":"0"},
    "fournisseur": {"id":"0"},
    "etatAchat": {"id":"0"},


        "achatItems": [
            {
                    "barCode": "barCode-0",
                    "footerBarCode": "footerBarCode-0",
                    "produit": {"id":"0"},
                    "quantite": "0",
                    "quantiteAvoir": "0",
                    "quantiteDisponible": "0",
                    "remise": "0",
                    "prixUttc": "0",
                    "prixUht": "0",
                    "montantHt": "0",
                    "montantTtc": "0",
                    "achat": {"id":"0"},
                    "depot": {"id":"0"},
            },
            {
                    "barCode": "barCode-0",
                    "footerBarCode": "footerBarCode-0",
                    "produit": {"id":"0"},
                    "quantite": "0",
                    "quantiteAvoir": "0",
                    "quantiteDisponible": "0",
                    "remise": "0",
                    "prixUttc": "0",
                    "prixUht": "0",
                    "montantHt": "0",
                    "montantTtc": "0",
                    "achat": {"id":"0"},
                    "depot": {"id":"0"},
            }
        ]
        "avoirs": [
            {
                    "entrepriseSociete": {"id":"0"},
                    "montant": "0",
                    "achat": {"id":"0"},
            },
            {
                    "entrepriseSociete": {"id":"0"},
                    "montant": "0",
                    "achat": {"id":"0"},
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


  Scenario: DELETE Achat and GET all

    Given path 'reference/order-5'
    When method DELETE
    Then status 200

    * def output = response.output

    Given path ''
    When method GET
    Then status 204
    # Todo: 200 in case there is other orders, otherwise 204 if no order in DB




