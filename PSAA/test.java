

public class test {
    private static void recursivelyTest(int n) {

        if (n == 0){return;}
        System.out.println(n);
        recursivelyTest(n-1);
        try {
            // Pause for 2000 milliseconds (2 seconds)
            Thread.sleep(0);
        } catch (InterruptedException e) {
            // Handle the exception if the thread is interrupted
            System.out.println("Sleep was interrupted.");
        }
        System.out.println("ceka me");
    }

    public static void main(String[] args) {
        recursivelyTest(200);

    }

}
