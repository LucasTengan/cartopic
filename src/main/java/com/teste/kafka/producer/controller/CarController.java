package com.teste.kafka.producer.controller;

import com.teste.kafka.producer.producer.CarProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarProducer carProducer;    // injetamos o criador de mensagens do carProducer

    @PostMapping
    public ResponseEntity<CarDTO> create(@RequestBody CarDTO carDTO) {  // com o requestbody informamos que os dados vem do corpo da requisição (um formulario)
        CarDTO car = CarDTO.builder().id(UUID.randomUUID().toString()).color(carDTO.getColor()).model(carDTO.getModel()).build();
        carProducer.send(car);

        return ResponseEntity.status(HttpStatus.CREATED).body(car);
    }
}
