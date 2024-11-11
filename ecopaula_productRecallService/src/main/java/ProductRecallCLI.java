import java.util.Scanner;
import org.ecopaula.server.grpc.*;

public class ProductRecallCLI {
    private final GrpcClient grpcClient; 
    private final Scanner scanner;

    public ProductRecallCLI(String host, int port) {
        grpcClient = new GrpcClient(host, port);
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Welcome to the Product Recall Service");
        boolean terminate = false;
        
        while (!terminate) {
            System.out.println("\nPlease select an option:");
            System.out.println("1. Get animal registration no. from ProductId");
            System.out.println("2. Get Products from AnimalId");
            System.out.println("3. Exit program");
            
            int option = Integer.parseInt(scanner.nextLine());
            
            switch (option) {
                case 1 -> getAnimalsFromProduct(); 
                case 2 -> getProductsFromAnimal(); 
                case 3 -> terminate = true;
                default -> System.out.println("Invalid option, please try again");
            }
        }
        
        scanner.close();
        shutdown(); 
    }

    private void getProductsFromAnimal() {
        System.out.println("Enter animalId: ");
        int animalId = Integer.parseInt(scanner.nextLine());

        try {
             ProductList listOfProductsFromAnimal = grpcClient.getProductsFromAnimal(animalId);
             listOfProductsFromAnimal.getProductsList().forEach(product ->
                     System.out.println("Product ID: " + product.getId() + ", Description: " + product.getDescription())
             );
        } catch (Exception e) {
            System.out.println("Error retrieving product data: " + e.getMessage());
        }
    }

    private void getAnimalsFromProduct() {
        System.out.println("Enter productId: ");
        int productId = Integer.parseInt(scanner.nextLine());

        try {
            AnimalList listOfAnimalsInProduct = grpcClient.getAnimalRegNoFromProduct(productId);
            listOfAnimalsInProduct.getAnimalsList().forEach(animal ->
                    System.out.println("Animal reg.no.: " + animal.getId())
            );
        } catch (Exception e) {
            System.out.println("Error retrieving animal data: " + e.getMessage());
        }
    }

    private void shutdown() {
        try {
            grpcClient.shutdown();
            System.out.println("Client shutdown successfully.");
        } catch (InterruptedException e) {
            System.out.println("Error shutting down client: " + e.getMessage());
        }
    }
}
