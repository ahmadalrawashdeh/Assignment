package com.shippingservices.shipping.shipment;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * Order from {@link com.shippingservices.shipping.user.User} for a shipment.
 */

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Order {

    private long id; // shipment order ID
    private long userId; // users' ID
    private String email; // users' email address

    private String carrierID; // valid carrierID's: {fedex, ups}
    private double width; // in cm (fedex) or inch (ups)
    private double length; // in cm (fedex) or inch (ups)
    private double height; // in cm (fedex) or inch (ups)
    private double weight; // in cm (fedex) or inch (ups)
    private String serviceID; // valid serviceID's: {fedexAIR, fedexGround, UPSExpress, UPS2DAY}

    /*  correct carrierID and serviceID,
     *  true if serviceID equal {fedexAIR, fedexGround} when carrierID equal {fedex}
     *  or if serviceID equal {UPSExpress, UPS2DAY} when carrierID equal {ups}
     *  and false otherwise
     */
    private boolean correct;
}
