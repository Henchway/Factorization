### Factorization

Using a combination of the sieve of eratosthenes and reusing of the already known prime numbers
for the prime-finding produces somewhat ok results, however going beyond (2^54)-1 is too much
for the java heap space, as I believe the array is then getting too big.
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
Update: Optimizing some more and giving the JVM some more memory for the array, I'm able to go up to 
58 bits, but at this point, there's likely no further improvement possible.

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
##############################################  
Number to factor: 144115188075855871, 57 bits  
The calculation of prime numbers took 5231 ms  
The prime factors are [7, 32377, 524287, 1212847]  
The calculation of the factors took 18 ms  
##############################################  
##############################################  
Number to factor: 288230376151711743, 58 bits  
The calculation of prime numbers took 9379 ms  
The prime factors are [3, 59, 233, 1103, 2089, 3033169]  
The calculation of the factors took 19 ms  
##############################################  