package com.shippingservices.shipping.shipment;

import org.springframework.stereotype.Service;

@Service
public class ShipmentGeneratorServiceImpl implements ShipmentGeneratorService {

    private long counter = 0;

    ShipmentGeneratorServiceImpl() {
        this.counter++;
    }

    private long increaseCounter() {
        return counter++;
    }

    @Override
    public ShipmentCarrier newShipment() {
        return new ShipmentCarrier(
                increaseCounter(),
                "Please choose between: Fedex or UPS",
                0.0,
                0.0,
                0.0,
                0.0,
                "Please choose between: FedexAIR, FedexGround, UPSExpress, or UPS2DAY"
        );
    }
}
