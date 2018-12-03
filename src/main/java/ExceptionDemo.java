public class ExceptionDemo {
    public static void main(String ... args){
//    this will cause negative size exception
//    int [] sample = new int[-2];
//    System.out.println(sample);

        ChainedDemo demo = new ChainedDemo();
        demo.demo();
    }
}

/* chained exception - exception can be chained together to reach the root cause
*  arithmetic exception might happening due to null pointer */

class ChainedDemo{
    void demo(){
        NullPointerException e = new NullPointerException("exception: ");
        e.initCause(new ArithmeticException("cause"));
        throw e;
    }
}