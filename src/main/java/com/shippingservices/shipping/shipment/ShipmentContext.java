package com.shippingservices.shipping.shipment;

public class ShipmentContext {
    public Order execute(ShipmentService shipmentService, OrderDTO orderDTO) {
        return shipmentService.verifyOrder(orderDTO);
    }
}
