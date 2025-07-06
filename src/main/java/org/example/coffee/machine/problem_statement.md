Write the working code to create a working coffee machine. Here are the desired features:

It will be serving some beverages.

Each beverage will be made using some ingredients.

Assume time to prepare a beverage is the same for all cases.

The quantity of ingredients used for each beverage can vary. Also, the same ingredient (ex: water) can be used for multiple beverages.

There would be N (N is an integer) outlet from which beverages can be served.

For N = 2 [ 2 outlets in a machine ]

For N = 3 [ 3 outlets in a machine ]

Maximum N beverages can be served in parallel.

Any beverage can be served only if all the ingredients are available in terms of quantity.

There would be an indicator that would show which all ingredients are running low. We need some methods to refill them.

Please provide functional integration test cases for maximum coverage.

Example:
Consider Chai Point machine which serves these drinks:

ginger tea
elaichi tea
coffee
hot milk
hot water
The machine has N outlets for serving these drinks. Here is the composition for each drink:

ginger tea:
hot water 50 ml
hot milk 10 ml
tea leaves syrup 10 ml
ginger syrup 5 ml
sugar syrup 10 ml
elaichi tea:
hot water 50 ml
hot milk 10 ml
tea leaves syrup 10 ml
elaichi syrup 5 ml
sugar syrup 10 ml
coffee:
hot water 50 ml
hot milk 10 ml
coffee syrup 10 ml
sugar syrup 10 ml
hot milk:
milk 50 ml
hot water
water 50 ml
Note: Since there are N outlets, N people can take beverages at the same time.

Input Test Json:

{
"machine": {
"outlets": {
"count_n": 4
},
"total_items_quantity": {
"hot_water": 500,
"hot_milk": 500,
"ginger_syrup": 100,
"sugar_syrup": 100,
"tea_leaves_syrup": 100
},
"beverages": {
"hot_tea": {
"hot_water": 200,
"hot_milk": 100,
"ginger_syrup": 10,
"sugar_syrup": 10,
"tea_leaves_syrup": 30
},
"hot_coffee": {
"hot_water": 100,
"ginger_syrup": 30,
"hot_milk": 400,
"sugar_syrup": 50,
"tea_leaves_syrup": 30
},
"black_tea": {
"hot_water": 300,
"ginger_syrup": 30,
"sugar_syrup": 50,
"tea_leaves_syrup": 30
},
"green_tea": {
"hot_water": 100,
"ginger_syrup": 30,
"sugar_syrup": 50,
"green_mixture": 30
},
}
}
}
Expected Output:
This input can have multiple outputs. Output 1:

hot_tea is prepared
hot_coffee is prepared
green_tea cannot be prepared because green_mixture is not available
black_tea cannot be prepared because item hot_water is not sufficient
Or Output 2:

hot_tea is prepared
black_tea is prepared
green_tea cannot be prepared because green_mixture is not available
hot_coffee cannot be prepared because item hot_water is not sufficient
Or Output 3:

hot_coffee is prepared
black_tea is prepared
green_tea cannot be prepared because green_mixture is not available
hot_tea cannot be prepared because item hot_water is not sufficient
Scoring Criteria / Expectation
To simplify the problem – we will exclude the following issues from the scope:

The solution does not have to scale out. We only need to design a solution to run on a single machine.
This machine can be assumed to have access to large high performance and reliable file systems to store the objects in.
This machine can be assumed to have multiple CPUs
The solution does not have to solve storage reliability issues (assume that the underlying file system is reliable).
Please don’t expose any API, we need a functional test case.
Submission:
Please submit the working code. We will be running test cases provided by you.
Express the design/algorithm as part of the comment blocks around the code. Please take care of the readability part of it.
We are looking for the following: a) Good design (an efficient, correct, and simple way to solve this problem). b) Correct implementation of the design.
You can choose any languages you are comfortable in.
Total Duration for the assignment is 2 hours and 30 mins. Try to give 30 mins for functional integration test cases.