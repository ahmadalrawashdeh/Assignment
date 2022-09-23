package com.shippingservices.shipping.shipment;

public interface ShipmentService {

    /**
     * verifies orders. The order is correct if both carrierID and serviceID are consistent,
     * true if serviceID equal {fedexAIR, fedexGround} when carrierID equal {fedex}
     * or if serviceID equal {UPSExpress, UPS2DAY} when carrierID equal {ups},
     * and false otherwise
     *
     * @param orderDTO
     * @return  Order object
     */
    Order verifyOrder (OrderDTO orderDTO);
}
