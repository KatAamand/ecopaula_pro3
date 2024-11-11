package org.ecopaula.server.config;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import jakarta.annotation.PostConstruct;
import org.ecopaula.server.grpc.ProductRecallServiceImpl;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PreDestroy;
import java.io.IOException;

@Configuration
public class GrpcServerConfig {
    private Server server;
    private final ProductRecallServiceImpl productRecallService;

    public GrpcServerConfig(ProductRecallServiceImpl productRecallService) {
        this.productRecallService = productRecallService;
    }
    
    @PostConstruct
    public void start() throws IOException {
        server = ServerBuilder.forPort(9095).addService(productRecallService).build().start();

        System.out.println("grpc server started on port 9095");
    
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("shutting down gRPC server");
            stopGrpcServer();
            System.out.println("server shut down");
        })); 
    }

    @PreDestroy
    private void stopGrpcServer() {
        if (server != null) {
            server.shutdown();
        }

        try {
            // Wait up to 5 seconds for the server to terminate gracefully
            if (!server.awaitTermination(3, java.util.concurrent.TimeUnit.SECONDS)) {
                System.out.println("Forcing gRPC server shutdown...");
                server.shutdownNow(); // Force shutdown if not completed in 5 seconds
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted while waiting for gRPC server to shut down, forcing shutdown now.");
            server.shutdownNow();
        }

        System.out.println("gRPC server shutdown complete.");
    }
}
