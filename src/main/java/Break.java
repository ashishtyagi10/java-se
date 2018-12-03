/*
* demonstration of break, break actually break out of that block or loop
* */
public class Break {
    public static void main(String ... args){
        boolean t = true;
         first:{
            second:{
             third:{
                print("before the break");
                if(t) break second;
                print("this will not execute");
             }
             print("this won't either");
            }
            print("this will after second block");
         }
    }

    private static void print(String args) {
        System.out.println(args);
    }
}
