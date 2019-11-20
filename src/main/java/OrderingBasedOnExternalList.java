import org.apache.commons.lang3.RandomStringUtils;

import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OrderingBasedOnExternalList {
    public static void main(String ... args){
        List<Customer> customerList = new ArrayList<>();
        List<Integer> expectedOrder = new ArrayList<>();
        for (int i=0;i<10;i++){
            Customer customer = new Customer(i);
            customer.setName(getRandomName());
            customer.setPay(getRandomPay());
            customerList.add(customer);
        }
        System.out.println("original customer list: "+customerList.toString());
        expectedOrder.add(3);
        List<Customer> sortedList = sortListBasedOnOrder (customerList, expectedOrder);
        System.out.println("sorted customer list: 1 :  "+sortedList.toString());

        expectedOrder.add(2);
        sortedList = sortListBasedOnOrder(customerList,expectedOrder);
        System.out.println("sorted customer list: 2 : "+sortedList.toString());

        expectedOrder.add(4);
        sortedList = sortListBasedOnOrder(customerList,expectedOrder);
        System.out.println("sorted customer list: 3 : "+sortedList.toString());

    }

    private static List<Customer> sortListBasedOnOrder(List<Customer> customerList, List<Integer> expectedOrder) {
        List<Customer> sortedList = new ArrayList<>();
        Map<Integer, Customer> customerMap = customerList.stream().collect(Collectors.toMap(Customer::getId, Function.identity()));
        for(Integer order:expectedOrder){
            if(customerMap.containsKey(order))
                sortedList.add(customerMap.get(order));
        }
        return sortedList;
    }

    private static Double getRandomPay() {
        return ThreadLocalRandom.current().nextDouble(90,100);
    }

    private static String getRandomName() {
        String source ="ABCDEFGHIJKLMNOPQRSTWXYZ";
        SecureRandom secureRandom = new SecureRandom();
        int capacity = 9;
        StringBuilder sb = new StringBuilder(capacity);
        for(int i = 0; i< capacity; i++)
            sb.append(source.charAt(secureRandom.nextInt(source.length())));
        return sb.toString();
    }

    private static class Customer {
        Integer id;
        Double pay;
        String name;
        public Customer(Integer i) {
            this.id = i;
        }

        public void setPay(Double pay) {
            this.pay = pay;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getId() {
            return id;
        }

        @Override
        public String toString() {
            return "Customer{" +
                    "id=" + id +
                    ", pay=" + pay +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
