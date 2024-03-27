import java.util.ResourceBundle;
import java.util.concurrent.*;
import java.util.function.Supplier;

public class Java21Features {
    public static String findUser(){
        return "John Doe";
    }
    public static int fetchOrder(){
        return 1234;
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //create an executor sevrice
        ExecutorService esvc = Executors.newFixedThreadPool(2);

        Future<String> user = esvc.submit(()-> findUser());
        Future<Integer> order = esvc.submit(()-> fetchOrder());

        String theUser = user.get();
        int theOrder = order.get();

        System.out.println(theUser);
        System.out.println(theOrder);

        esvc.close();
        //The above code can be written as the below in java 21
        try(var scope = new StructuredTaskScope.ShutdownOnFailure()){
            Supplier<String> user1 = scope.fork(()-> findUser());
            Supplier<Integer> order1 = scope.fork(()-> fetchOrder());

            scope.join().throwIfFailed();

            System.out.println(user1.get());
            System.out.println(order1.get());
        }
    }
}
