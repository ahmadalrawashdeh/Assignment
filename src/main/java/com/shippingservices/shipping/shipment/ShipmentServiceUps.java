package com.shippingservices.shipping.shipment;

import com.shippingservices.shipping.user.User;

import org.springframework.stereotype.Service;

@Service
public class ShipmentServiceUps implements ShipmentService {
    @Override
    public Order verifyOrder(OrderDTO orderDTO) {
        boolean isCorrect = (orderDTO.getCarrierID().toString().equalsIgnoreCase("ups")
                &&
                (orderDTO.getServiceID().toString().equalsIgnoreCase("UPSExpress")
                        || orderDTO.getServiceID().toString().equalsIgnoreCase("UPS2DAY"))
        );

        long orderId = orderDTO.getId() == 0? 1 : orderDTO.getId();
        long userId = orderDTO.getUserId() == 0? 1 : orderDTO.getUserId();
        String name = orderDTO.getName() == null? "Example" : orderDTO.getName();
        String email = orderDTO.getEmail() == null? "example@example.com" : orderDTO.getEmail();
        User user = new User(userId, name, email);

        Order checkedOrder = new Order(orderId,
                user.getId(),
                user.getEmail(),
                orderDTO.getCarrierID().toString().toUpperCase(),
                orderDTO.getWidth(),
                orderDTO.getLength(),
                orderDTO.getHeight(),
                orderDTO.getWeight(),
                orderDTO.getServiceID().toString().toUpperCase(),
                isCorrect
        );
        return checkedOrder;
    }
}
