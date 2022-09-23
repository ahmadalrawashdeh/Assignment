package com.shippingservices.shipping.shipment;

public interface ShipmentGeneratorService {
    /**
     * @return a new generated shipment with new ID
     */
    ShipmentCarrier newShipment();
}
