​Approach to solve it in logarithm of the exponent time.

#### Recursive approach (top down):
Idea is simple: Given the exponent, you either divide the exponent by 2 if its even or subtract by 1 if the its odd.

1. Base case is if the exponent is 0. Then answer is 1. No matter what the base is.
2. if the exponent is even then calculate the result with exponent reduced by half. Whatever result is obtained simple square it.
3. Else if the exponent is odd then calculate the result with exponent reduced by 1 and multiply it with base and return.

Take for example base = 2, exponent is 7.
exponents:              7              6           5       4       3           2               1       0
result [ -> ]:         (6)*2         (3)*(3)      (X)     (X)   (2)*2        (1)*(1)          (0)*2    1   
                      64*2=128   <-  8*8 = 64     <--------    4*2 = 8       2*2 = 4   <-     1*2=2   <--   


legend: 
(k) means the result obtained for exponent as 'k'
[ -> ] direction of movement of recursive function.


#### Iterative approach (bottom up):
Lets understand the approach by an example...
Lets take base as 2 and exponent as 15.
### Also remember a fact: whenever we double the exponent, we are effectively squaring the base.

Starting with exponent value as 1 we can continue to double it until we reach 15 or smaller.

1. 1 -> 2 -> 2*2 (4) -> 4*2 (8) (this is where we stop because 8*2 (16) is greater than 15)
2. we reduce the target exponent 15 by what we have reached which is: 8. Residue exponent is 7

3. Repeat step 1 but this time target exponent to reach is 7 or just smaller.
4. 1 -> 2 -> 4 (this is where we stop because 4*2 > 7)
5. We reduce the target exponent 7 by what we have reached, which is: 4. Residue exponent is 3

6. Repeat step 1 but this time target exponent to reach is 3 or just smaller.
7. 1 -> 2 (this is where we stop because 2*2 > 3)
8. reduce the target exponent 3 by 2. Residue exponent is 1.

9. Repeat step 1 but this time target exponent to reach is 1 or just smaller.
10. 1 (this is where we stop because 1*2 > 1)
11. reduce the target exponent 1 by 1. Residue exponent is 0.
12. This is where we stop.

If you observe from steps 2, 4, 7 and 11. is that we have following exponent values:

8 + 4 + 2 + 1 = 15. These are nothing but sum of exponents. 
If the "base-number-raised-to-the-power-of-these-exponents" are multiplied together then the exponents get added.
i.e., 2^8 * 2^4 * 2^2 * 2^1 = 2^(8 + 4 + 2 + 1) = 2^15 

Legend:
x^y: x raised to the power of y
