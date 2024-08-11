Feature: product added to cart

  Scenario: product added to cart

    When I go to the page
    Then the home page is visible
    And accept cookies

    Given the top menu is visible
    When I select the Devices tab from the top menu
    Then drop-down list visible on the page

    Given no subscription section of the top menu is visible
    When I click smartphones in the no subscription section
    Then a list of smartphones visible on the website

    When I click on the first item on the list
    Then product page is visible
    And get Starting price
    And get Monthly Installment

    When I add the product to the cart
    Then your cart page is visible
    And The Starting price amount equals the amount on the previous page
    And The Monthly Installment amount is the same as the amount on the previous page

    Given the product has been added to the cart
    When I go to the home page
    Then in the upper right corner there is a basket icon with the number of products in the basket