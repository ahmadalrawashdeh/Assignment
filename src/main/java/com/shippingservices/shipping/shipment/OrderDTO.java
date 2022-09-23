package com.shippingservices.shipping.shipment;

import lombok.Value;

import javax.validation.constraints.*;

/**
 * Order from user
 */
@Value
public class OrderDTO {

    //@NotNull(message = "Shipment order ID cannot be null.") @Positive(message = "Shipment order ID must be positive integer greater than zero.")
    private long id; // shipment order ID

    //@NotNull(message = "User ID cannot be null.") @Positive(message = "User ID must be positive integer greater than zero.")
    private long userId; // users' ID

    //@NotBlank(message = "Please enter your name. Name field can't be blank.")
    private String name; // users' name

    //@NotNull(message = "Email address cannot be null.") @Email(message = "Please enter a valid email address!")
    private String email; // users' email address

    @Pattern(regexp = "fedex|ups", flags = Pattern.Flag.CASE_INSENSITIVE, message = "Please enter a valid carrierID, you can choose between: Fedex or UPS.")
    private String carrierID; // valid carrierID's: {fedex, ups}

    @Positive(message = "Width must be positive integer greater than zero.")
    private double width; // in cm (fedex) or inch (ups)
    @Positive(message = "Length must be positive integer greater than zero.")
    private double length; // in cm (fedex) or inch (ups)
    @Positive(message = "Height must be positive integer greater than zero.")
    private double height; // in cm (fedex) or inch (ups)
    @Positive(message = "Weight must be positive integer greater than zero.")
    private double weight; // in cm (fedex) or pound (ups)

    @Pattern(regexp = "fedexAIR|fedexGround|UPSExpress|UPS2DAY", flags = Pattern.Flag.CASE_INSENSITIVE, message = "Please enter a valid serviceID, you can choose between: FedexAIR, FedexGround, UPSExpress, or UPS2DAY.")
    private String serviceID; // valid serviceID's: {fedexAIR, fedexGround, UPSExpress, UPS2DAY}
}

