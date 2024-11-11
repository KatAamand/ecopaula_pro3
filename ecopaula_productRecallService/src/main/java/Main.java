public class Main {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 9090;

        ProductRecallCLI cli = new ProductRecallCLI(host, port);

        cli.start();
    }
}
