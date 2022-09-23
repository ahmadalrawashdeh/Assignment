package com.shippingservices.shipping.shipment;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


/**
 * A REST API to POST orders from users.
 */

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/orders")
public class OrderController {
    private ShipmentContext shipmentContext = new ShipmentContext();
    private ShipmentService shipmentService;

    @PostMapping
    ResponseEntity<Order> postResult(@RequestBody @Valid OrderDTO orderDTO) {
        if (orderDTO.getCarrierID().toString().equalsIgnoreCase("fedex")) {
            shipmentService = new ShipmentServiceFedex();
        } else if (orderDTO.getCarrierID().toString().equalsIgnoreCase("ups")) {
            shipmentService = new ShipmentServiceUps();
        } else {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(shipmentContext.execute(shipmentService, orderDTO));
    }
}
