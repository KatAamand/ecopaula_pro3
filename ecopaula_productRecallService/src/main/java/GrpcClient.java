import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.ecopaula.server.grpc.*;

public class GrpcClient {
    private final ManagedChannel channel;
    private final ProductRecallServiceGrpc.ProductRecallServiceBlockingStub blockingStub;

    public GrpcClient(String host, int port) {
        channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        blockingStub = ProductRecallServiceGrpc.newBlockingStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown();
    }

    public AnimalList getAnimalRegNoFromProduct(int productId) {
        ProductGrpc productToBeRecalled = ProductGrpc.newBuilder().setId(productId).build();
        return blockingStub.getAnimalsByProductNo(productToBeRecalled);
    }

    public ProductList getProductsFromAnimal(int animalId) {
        AnimalGrpc animal = AnimalGrpc.newBuilder().setId(animalId).build();
        return blockingStub.getProductsByAnimal(animal);
    }
}
