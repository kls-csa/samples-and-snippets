package org.khanlabschool;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    /*
    Python:

    def is_prime(n):
        # Quick check for evenness:
        if n % 2 == 0:
            return False

        # Check all odd numbers from 3 to the square root
        # of n, inclusive:
        upper_bound = math.ceil(math.sqrt(n))
        for divisor in range(3, upper_bound + 1, 2):
            if n % divisor == 0:
                return False

        return True


     JS:

     function isPrime(n) {
        // Quick check for evenness:
        if(n % 2 == 0) {
            return false;
        }

        let upperBound = Math.ceil(Math.sqrt(n));
        for(let divisor = 3; divisor <= upperBound; divisor += 2) {
            if(n % divisor == 0) {
                return false;
            }
        }

        return true;
     }
     */
    private static boolean isPrime(int n) {
        // Quick check for evenness:
        if(n % 2 == 0) {
            return false;
        }

        // Check all odd numbers from 3 to the square root
        // of n, inclusive:
        int upper_bound = (int)Math.ceil(Math.sqrt(n));
        for(int divisor = 3; divisor <= upper_bound; divisor += 2) {
            if(n % divisor == 0) {
                return false;
            }
        }

        return true;
    }


    /*
    Python:

    def get_primes(count):
        primes = [2]

        n = 3
        while len(primes) < count:
            if is_prime(n):
                primes.append(n)

            n += 2

        return primes


     JS:

     function getPrimes(count) {
        primes = [2];

        let n = 3;
        while(primes.length < count) {
            if(isPrime(n)) {
                primes.push(n);
            }

            n += 2;
        }

        return primes;
     }
     */
    private static ArrayList<Integer> getPrimes(int count) {
        ArrayList<Integer> primes = new ArrayList<Integer>();
        primes.add(2);

        int n = 3;
        while(primes.size() < count) {
            if(isPrime(n)) {
                primes.add(n);
            }

            n += 2;
        }

        return primes;
    }

    /*
    In Python, this would just be int() + input().
    JS doesn't have anything built-in for command-line input. You could use something like
    parseInt(prompt(...)), which pops up a dialog box.
     */
    private static int readInt(String prompt) {
        System.out.print(prompt + " ");

        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    /*
    The signature (its name, arguments, staticness & visibility)
    of this method is dictated by Java. Any changes, and your
    program will not compile.

    No real equivalent in Python: you just put code at the
    top-level of the file, and it runs when the script is loaded.

    In JS, kind of the same situation, or you'd add your startup
    code in a listener for one of the ready/load events.
     */
    public static void main(String[] args) {
        int n = readInt("Enter a number:");
        if(isPrime(n)) {
            System.out.format("%d is prime!", n);
        }
        else {
            System.out.format("%d is not prime.", n);
        }


//        int count = readInt("How many primes would you like?");
//        ArrayList<Integer> primes = getPrimes(count);
//
//        // Could have looped "for(int i = 0; i < primes.size(); i++)" and
//        // pulled out value at that index with primes[i], but this shows
//        // the "for(variable : collection)" syntax:
//        int i = 0;
//        for(int prime : primes) {
//            System.out.format("%d\t%d", i + 1, prime);
//            i++;
//        }
    }


    /*
    Big picture things to note:
    - Java is *obsessed* with types
        - variables, arguments, return types – all must be of an explicit type
            - "void" is the special return 'type' of a method that returns nothing, either
              by falling off the bottom of a function, or by doing "return;" with no value
        - containers are their own problem ... Java wants to know what is *in* a list, or
          the types of the keys and values in a dictionary
    - DRY to the max, perhaps even too far
    - No code can exist outside of a method in Java
    - Naming conventions:
        - lowerCamelCase for methods & variables
        - UpperCamelCase for classes
        - ALL_CAPS_SNAKE_CASE for constants

    Syntactic/nitty gritty details:
    - Braces over spaces. Whitespace is *not* significant (but you should still indent)
    - Semicolons!
    - Need the "new" keyword to make instance of a class; not just ClassName(...) like Python
    - Basic Java arrays (e.g. Integer[]) are fixed size, similar to Python's tuples
        - ArrayList<T> is the more manipulable version
        - Integer vs. int is ... a can of worms. We'll get there. Rule of thumb: is it a container? You'll
          need the capitalized version. Use the lowercase when you can.
    - There are no easy syntax for making arrays like JS & Python's [1, 2, 3].
        - FWIW, they're not very useful anyway...
        - The same goes for dictionaries (which are called Maps or Hashes or HashMaps or a hash table)
    - The main() method of the Main class is super special:
        - It must be *exactly* public static void main(String[] args)
        - Java will execute it for you when your program starts
    - Referencing other methods/properties of your self doesn't require qualification – where you would say
      "self.do_something()" in Python, you can just say "doSomething()" in Java. It will look for matching
      things on this class first.
        - We'll get to instances & classes eventually. FWIW, what is called "self" in Python is "this" in Java,
          and you don't need to explicitly list it as an argument.
    - for loops...
        - Java has the "for(initialization; condition; increment) { ... }" loop, which Python lacks
        - It also has "for(variable : collection) { ... }" for looping over a container. This is much more like
          Python's for loop, and like JS's "for(variable of collection) { ... }".
    - Even more shorthand for incrementing/decrementing:
          x++  ->  x += 1  ->  x = x + 1
          x--  ->  x -= 1  ->  x = x - 1
     */
}
