### Factorization

Using a combination of the sieve of eratosthenes and reusing of the already known prime numbers
for the prime-finding produces somewhat ok results, however going beyond (2^54)-1 is too much
for the java heap space, as I believe the arrays are then getting too big.
I've also experimented with BigInteger, however, the syntax and the incompatibility with 
the existing functions were simply breaking it all.  
I've made several iterations of the program, of which in the end this is the best result I can
produce. Specifically erathosthenes using arrays has improved the prime calculation massively,
however, using other structures such as ArrayList slow it down more than it benefits.
Introducing another check into the factorization, namely checking whether the factorization
is complete (checking if the detected factors already match the initial number) introduces
some randomness in the duration of the calculation, as the smaller the prime numbers
composing the number are, the faster the calculation will be, going as low as 
6 ms for 54 bits, but being fairly high with 95 ms for 53 bits.

##############################################  
Number to factor: 4503599627370495, 52 bits  
The calculation of prime numbers took 1089 ms  
The prime factors are [3, 5, 53, 157, 1613, 2731, 8191]  
The calculation of the factors took 0 ms  
##############################################  
##############################################  
Number to factor: 9007199254740991, 53 bits  
The calculation of prime numbers took 1820 ms  
The prime factors are [6361, 69431, 20394401]  
The calculation of the factors took 95 ms  
##############################################  
##############################################  
Number to factor: 18014398509481983, 54 bits  
The calculation of prime numbers took 2194 ms  
The prime factors are [3, 3, 3, 3, 7, 19, 73, 87211, 262657]  
The calculation of the factors took 6 ms  
##############################################  