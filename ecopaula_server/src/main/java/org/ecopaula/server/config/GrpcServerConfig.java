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

    private ProductRecallServiceImpl productRecallService;

    public GrpcServerConfig(ProductRecallServiceImpl productRecallService) {
        this.productRecallService = productRecallService;
    }
    
    @PostConstruct
    public void start() throws IOException {
        server = ServerBuilder.forPort(9095).addService(productRecallService).build().start();

        System.out.println("grpc server started on port 9090");
    
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
    }
}
