package ArrayLlist;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class TestingArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(30,10,20));
        numbers.add(40);
        numbers.add(50);
        numbers.add(60);
        System.out.println(numbers);


        numbers.trimToSize();


        //Iterating over Elements
        for (int i = 0; i < numbers.size(); i++){
            int element = numbers.get(i);
            System.out.println(element);
        }

        //Iterating using enhanced

        for (int item : numbers){
            System.out.println(item);
        }

        //[10, 20, 30, 40] ==> 10, 20, 30 ,40

        numbers.stream().forEach(element -> {
            System.out.println(element);
        });

        ArrayList<String> namesOfStudents = new ArrayList<>(Arrays.asList("Scott", "Raymond", "Lauren"));
        namesOfStudents.stream().forEach(names -> {
            String namesInCaps = names.toUpperCase();
            System.out.println(namesInCaps);
        } );

        //Iterator traversal
        Iterator<Integer> it = numbers.iterator();
        while (it.hasNext()){
            int el = it.next();
            System.out.println(el);
        }

    }
}
