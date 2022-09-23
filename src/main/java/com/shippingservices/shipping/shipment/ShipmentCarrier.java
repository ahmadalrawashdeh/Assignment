package com.shippingservices.shipping.shipment;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * This class represent a shipment carrier
 */

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class ShipmentCarrier {
    private long id; // shipment order ID, unique ID to identify order starting from 1
    private String carrierID; // valid carrierID's: {fedexAIR, fedexGround}
    private double width; // in cm (fedex) or inch (ups)
    private double length; // in cm (fedex) or inch (ups)
    private double height; // in cm (fedex) or inch (ups)
    private double weight; // in cm (fedex) or inch (ups)
    private String serviceID; // valid serviceID's: {fedexAIR, fedexGround, UPSExpress, UPS2DAY}
}

