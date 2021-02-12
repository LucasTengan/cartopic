package com.teste.kafka.producer.controller;

import lombok.Builder;
import lombok.Data;

@Data   // Serializando um objeto com Lombok, no lugar de enviar como string
@Builder
public class CarDTO {

    private String id;
    private String model;
    private String color;
}
