package com.shippingservices.shipping.shipment;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * A REST API to GET new shipment with unique id
 */

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/shipments")
public class ShipmentCarrierController {

    private final ShipmentGeneratorService shipmentGeneratorService;

    @GetMapping("/new")
    ShipmentCarrier getNewShipment() {
        ShipmentCarrier shipmentCarrier = shipmentGeneratorService.newShipment();
        log.info("Generating a new shipment with new unique id: {}", shipmentCarrier);
        return shipmentCarrier;
    }
}
