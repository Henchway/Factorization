### Factorization

After a lot of changes, adaptions, improvements, deteriorations, I ended up using the following combination:    
- Sieve of eratosthenes  
- reusing of known prime numbers  
- max to-be-factored number of 2^32+1 (due to the integer restrictions)  
For better results and specifically using a larger range of numbers, a specialized construct is necessary to leave the realm of signed integer.
Alternatively, I've also built the version not using the sieve at all, which will then only limit me to 2^32 prime numbers, but it's far worse performing.
  
##############################################  
Number to factor: 2147483649, 31 bits  
The calculation of prime numbers took 2229 ms  
The prime factors are [3, 715827883]  
The calculation of the factors took 1540 ms  
##############################################  
  