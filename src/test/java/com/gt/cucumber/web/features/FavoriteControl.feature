Feature: FavoriteControl

  Scenario: Add to Favorites

              Given User navigate to homepage
              And User login email as "xxx" and password as "xxx"
              And User navigate to Perfume-Deodorant under the Cosmetic-Personal Care tab
              And User search for "Lacoste" in Brand filter
              And User select ‘Lacoste’
              And User click sevennth product on the search result page
              And User add product to the ‘Favorites’
              And User navigate to Favorites
              Then User should be see the product title is the same as with the product details page