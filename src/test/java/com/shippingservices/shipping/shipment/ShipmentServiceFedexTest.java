package com.shippingservices.shipping.shipment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.BDDAssertions.then;

public class ShipmentServiceFedexTest {
    private ShipmentService shipmentService;

    @BeforeEach
    public void setUp() {
        shipmentService = new ShipmentServiceFedex();
    }

    @Test
    public void checkCorrectOrderTest() {
        // given
        OrderDTO shipDTO = new OrderDTO(12345L, 1, "John", "example@example.com", "fedex", 10, 10, 20, 50, "fedexAIR");

        // when
        Order resultOrder = shipmentService.verifyOrder(shipDTO);

        // then
        then(resultOrder.isCorrect()).isTrue();
    }

    @Test
    public void checkWrongOrderTest() {
        // given
        OrderDTO shipDTO = new OrderDTO(12345L, 1, "John", "email", "carrierID", 10, 10, 20, 50, "serviceID");

        // when
        Order resultOrder = shipmentService.verifyOrder(shipDTO);

        // then
        then(resultOrder.isCorrect()).isFalse();
    }

}
