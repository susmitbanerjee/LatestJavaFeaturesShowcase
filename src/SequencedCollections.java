import java.util.ArrayList;

public class SequencedCollections {
    public static void main(String[] args) {

        ArrayList<Integer> arrayListYear = new ArrayList<>();
        arrayListYear.add(2023);
        System.out.println(arrayListYear);

        arrayListYear.addFirst(2022);
        System.out.println(arrayListYear);

        arrayListYear.addLast(2024);
        System.out.println(arrayListYear);

        System.out.println(arrayListYear.getFirst());
        System.out.println(arrayListYear.getLast());
        System.out.println(arrayListYear.reversed());

        arrayListYear.removeFirst();
        System.out.println(arrayListYear);

        arrayListYear.removeLast();
        System.out.println(arrayListYear);
    }
}
