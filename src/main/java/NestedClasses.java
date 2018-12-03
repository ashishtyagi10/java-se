public class NestedClasses {
    public static  void main(String ... args){
        outer outer = new outer();
        outer.test();
        outer.test2();
    }

}


class outer{
    int outerX = 6;
    static int outerStaticX = 5;

    void test(){
        inner inner = new inner();
        inner.display();

        staticInner staticInner = new staticInner();
        staticInner.display();
    }

    void test2(){
        inner inner = new inner();
        inner.display2();
    }

    static class staticInner{
        void display(){
            System.out.println("accessing outer static: "+outerStaticX);
        }
    }

    class inner {
        void display(){
            System.out.println("acessing out x: "+outerX);
            System.out.println("acessing out x: "+outerStaticX);
        }

        void display2(){
            test();
        }
    }
}
