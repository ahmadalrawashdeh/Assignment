package com.shippingservices.shipping.shipment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.BDDAssertions.then;

public class ShipmentServiceUpsTest {
    private ShipmentService shipmentService;

    @BeforeEach
    public void setUp() {
        shipmentService = new ShipmentServiceUps();
    }

    @Test
    public void checkCorrectOrderTest() {
        OrderDTO shipDTO = new OrderDTO(12345L, 1, "John", "example@example.com", "ups", 10, 10, 20, 50, "UPSExpress");

        Order resultOrder = shipmentService.verifyOrder(shipDTO);

        then(resultOrder.isCorrect()).isTrue();
    }

    @Test
    public void checkWrongOrderTest() {
        OrderDTO shipDTO = new OrderDTO(12345L, 1, "John", "email", "carrierID", 10, 10, 20, 50, "serviceID");

        Order resultOrder = shipmentService.verifyOrder(shipDTO);

        then(resultOrder.isCorrect()).isFalse();
    }

}
