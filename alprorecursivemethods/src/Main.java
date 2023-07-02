public class Main {
    public static void main(String[] args){
        System.out.println(powerIterative(2,-1));
    }

     public static long fibonacciRecursive(int n) {
        //TODO: Implementiere rekursive Methode, die n-te Fibonaccizahl ausgibt
         System.out.println(n);
         if(n == 0)
         {
             return 0;
         }
         else if(n == 1 || n == 2)
         {
             return 1;
         }
         else
         {
             return fibonacciRecursive(n-1) + fibonacciRecursive(n-2);
         }


    }

    public static long facultyRecursive(int n) {
        //TODO: Implementiere rekursive Methode, die n! berechnet
        if( n == 1 || n == 0)
        {
            return 1;
        }
        else
        {
            return facultyRecursive(n-1) * n;
        }

    }

    public static double powerRecursive(double a, int n) {
        //TODO: Implementiere rekursive Methode die a mit n potenziert
        //Benutze dabei das Prinzip aus Part 2 Aufgabe 1
        if( a == 0)
        {
            return 0;
        }
        else if(a == 1 || n == 0)
        {
            return 1;
        }
        if(n == 1)
        {
            return a;
        }
        else if(n<0){
            n *= -1;
            System.out.println(a);
            System.out.println(n);
            return 1/(powerRecursive(a,n  -1) * a);

        }
        else
        {
            return powerRecursive(a,n -1) * a;
        }

    }

    public static double powerIterative(double a, int n) {
        //TODO: Implementiere iterative Methode die a mit n potenziert
        //Benutze dabei das Prinzip aus Part 2 Aufgabe 1

        if(n > 0) {
            for(int i = 0; i < n -1;i++)
            {
                a *= a;
            }
            return a;
        }
        else if(n == 0)
        {
            return 1;
        }
        else{
            for(int i = 0; i > n + 1;i--)
            {
                a *= a;
            }
            return 1/a;
        }

    }
}
