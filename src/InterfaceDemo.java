public class InterfaceDemo {
    public static void main(String ... args){
        C c = new C();
        c.method1();//I am default method
        c.method2();//I am in method2
        c.method3();//method3
        c.reset();//a reset, look for the notes
    }
}


interface  A {
    default void method1(){
        System.out.println("I am default method");
    }

    default void reset(){
        System.out.println("a reset");
    }
}

interface B extends  A{
    void method2();
    default  void method3(){
        System.out.println("method3");
    };
/*super class reset method can be called from child class using super
* if we don't wants to call super then child class default method would be called*/
    default  void reset(){
        A.super.reset();
    }
}
/*two interface can not have same default method
* this will cause an exception*/
interface D{

}
class C implements B,D{
    @Override
    public void method2() {
        System.out.println("I am in method2");
    }

}
