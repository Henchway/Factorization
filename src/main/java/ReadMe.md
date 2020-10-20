### Factorization

After a lot of changes, adaptions, improvements, deteriorations, I ended up using the following combination:    
- Sieve of eratosthenes  
- reusing of known prime numbers  
- max to-be-factored number of 2^32+1 (due to the integer restrictions)  
For better results and specifically using a larger range of numbers, a specialized construct is necessary to leave the realm of signed integer.
Alternatively, I've also built two other versions (see uploads):
- one version not using the sieve at all, which will then only limit me to 2^32 prime numbers, but it's far worse performing
- one version which doesn't calculate prime numbers at all, but factorizes 'on demand', there it depends strongly on the size of the
prime numbers, as ANY number is checked up until the input number is factored. This version can be very fast and efficient, however that is simply a matter of luck, furthermore
this version allows numbers up to Long.MAX_VALUE. I've added an example below.

Produced with the Sieve implementation:
##############################################  
Number to factor: 2147483649, 31 bits  
The calculation of prime numbers took 2229 ms  
The prime factors are [3, 715827883]  
The calculation of the factors took 1540 ms  
##############################################  

Without checking the primes prior (2^64 -1):  
##############################################  
Number to factor: 9223372036854775806, 64 bits  
The prime factors are [2, 3, 715827883, 2147483647]  
The calculation of the factors took 34923 ms  
##############################################  