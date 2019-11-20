package watchDir;

public class Palindrom {
    public static boolean isPalin(int n){
        char[] val = (""+n).toCharArray();
        for(int i=0; i<val.length; i++){
            if (val[i] != val[val.length-i -1]){
                return false;
            }
        }
        return  true;
    }

    public static void main(String ... args){
        Palindrom palindrom = new Palindrom();
        for(int i=999 ; i> 100 ; i--){
            for (int j = 999 ; j>100; j--){
                int mul = i*j;
                if (isPalin(mul)){
                    System.out.printf("%d * %d = %d ", i, j, mul);
                    return;
                }
            }
        }
    }
}
