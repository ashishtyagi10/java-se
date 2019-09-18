import java.util.ArrayList;
import java.util.List;

public class StreamUsage {
    public static void main(String ... args){
        List<String> stringList = new ArrayList<>();
        initializeStringList(stringList);
        System.out.println(stringList);
        stringList.stream().filter(s -> s.startsWith("c")).map(String::toUpperCase).sorted().forEach(System.out::println);
        stringList.stream().findFirst().ifPresent(System.out::println);
    }

    private static void initializeStringList(List<String> stringList) {
        for(int i=0;i<10;i++){
           stringList.add("a"+i);
           stringList.add("c"+i);
        }
    }
}
