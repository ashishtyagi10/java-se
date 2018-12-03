public class Factorial {

    public int factorial(int n){
        if (n <= 0) throw new IllegalArgumentException("wrong argument to calculate factorial");
        if(n == 1) return n;
        return factorial(n-1)*n;
    }

    public static void main(String ... args){
        Factorial first = new Factorial();
        System.out.println(first.factorial(5));
        System.out.println(first.factorial(-1));
        System.out.println(first.factorial(4));
    }
}
