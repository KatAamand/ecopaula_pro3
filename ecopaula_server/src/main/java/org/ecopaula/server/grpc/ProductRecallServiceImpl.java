package org.ecopaula.server.grpc;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.ecopaula.server.*;
import org.ecopaula.server.dto.AnimalDTO;
import org.ecopaula.server.dto.ProductDTO;
import org.ecopaula.server.service.AnimalService;
import org.ecopaula.server.service.ProductService;


import java.util.List;
import java.util.stream.Collectors;

@GrpcService
public class ProductRecallServiceImpl extends ProductRecallServiceGrpc.ProductRecallServiceImplBase {

    private AnimalService animalService;
    private ProductService productService;

    public ProductRecallServiceImpl(AnimalService animalService, ProductService productService) {
        this.animalService = animalService;
        this.productService = productService;
    }

    @Override
    public void getAnimalsByProductNo(ProductGrpc request, StreamObserver<AnimalList> responseObserver) {
        List<AnimalDTO> animals = animalService.getAnimalsByProductId(request.getId());

        List<AnimalGrpc> grpcAnimals = animals.stream().map(GrpcConverter::toGrpcAnimal).collect(Collectors.toList());

        AnimalList response = AnimalList.newBuilder().addAllAnimals(grpcAnimals).build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getProductsByAnimal(AnimalGrpc request, StreamObserver<ProductList> responseObserver) {
        List<ProductDTO> products = productService.getProductByAnimalId(request.getId());

        List<ProductGrpc> grpcProducts = products.stream().map(GrpcConverter::toGrpcProduct).collect(Collectors.toList());

        ProductList response = ProductList.newBuilder().addAllProducts(grpcProducts).build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}

