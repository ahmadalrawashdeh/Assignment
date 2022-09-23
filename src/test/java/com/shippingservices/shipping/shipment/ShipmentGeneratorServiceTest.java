package com.shippingservices.shipping.shipment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.BDDAssertions.then;

@ExtendWith(MockitoExtension.class)
public class ShipmentGeneratorServiceTest {

    private ShipmentGeneratorService shipmentGeneratorService;

    @BeforeEach
    public void setUp() {
        shipmentGeneratorService = new ShipmentGeneratorServiceImpl();
    }

    @Test
    public void generateNewShipment() {

        // when we generate new shipment
        ShipmentCarrier shipmentCarrier = shipmentGeneratorService.newShipment();

        // then the shipment contains new unique id starting from 1
        then(shipmentCarrier).isEqualTo(new ShipmentCarrier(
                1,
                "Please choose between: Fedex or UPS",
                0.0,
                0.0,
                0.0,
                0.0,
                "Please choose between: FedexAIR, FedexGround, UPSExpress, or UPS2DAY")
        );
    }

}
