Feature: Tricentis Shopping Cart Automation
 
Scenario Outline: Search and add a product to the shopping cart
Given the user navigates to the Tricentis homepage
When the user enters the product "<ProductName>" in the search bar
And clicks on the search button
And clicks the Add to Cart button for the product
Then a success message should be displayed
 
Examples:
| ProductName |
| 14.1-inch Laptop |