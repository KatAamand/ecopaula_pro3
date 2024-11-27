package org.ecopaula.server.grpc;

import com.google.protobuf.Timestamp;
import dto.AnimalDTO;
import dto.ProductDTO;
import jakarta.persistence.Converter;
import entity.Origin;

import java.time.Instant;
import java.util.Date;

@Converter
public class GrpcConverter {
    public static ProductGrpc toGrpcProduct(ProductDTO productDTO) {
        return ProductGrpc.newBuilder()
                .setId(productDTO.getId())
                .setDescription(productDTO.getDescription())
                .build();
    }

    public static ProductDTO toProductDTO(ProductGrpc productGrpc) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(productGrpc.getId());
        productDTO.setDescription(productGrpc.getDescription());
        return productDTO;
    }

    public static AnimalGrpc toGrpcAnimal(AnimalDTO animalDTO) {
        return AnimalGrpc.newBuilder()
                .setId(animalDTO.getId())
                .setWeight(animalDTO.getWeight())
                .setOrigin(toGrpcOrigin(animalDTO.getOrigin()))
                .setRegistrationDate(toGrpcTimestamp(animalDTO.getRegistrationDate()))
                .build();
    }

    private static Timestamp toGrpcTimestamp(Date registrationDate) {
        Instant instant = registrationDate.toInstant();
        return Timestamp.newBuilder()
                .setSeconds(instant.getEpochSecond())
                .setNanos(instant.getNano())
                .build();
    }

    private static Date toDate(Timestamp timestamp) {
        return Date.from(Instant.ofEpochSecond(timestamp.getSeconds(), timestamp.getNanos()));
    }

    public static OriginGrpc toGrpcOrigin(Origin origin) {
        return OriginGrpc.newBuilder()
                .setId(origin.getId())
                .setNameOfFarm(origin.getName_of_farm())
                .build();
    }

}
