package com.shippingservices.shipping.shipment;

import com.shippingservices.shipping.user.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@ExtendWith(SpringExtension.class)
@AutoConfigureJsonTesters
@WebMvcTest(OrderController.class)
public class OrderControllerTest {

    @MockBean
    private ShipmentService shipmentService;

    @Autowired
    private MockMvc mvc;

    @Autowired
    private JacksonTester<OrderDTO> jsonRequestOrder;

    @Autowired
    private JacksonTester<Order> jsonResultOrder;

    @Test
    void postValidResult() throws Exception {

        // given
        User user = new User(1,"John", "example@example.com");
        ShipmentGeneratorService shipmentGeneratorService = new ShipmentGeneratorServiceImpl();
        ShipmentCarrier shipmentCarrier = shipmentGeneratorService.newShipment();
        long orderId = shipmentCarrier.getId();

        OrderDTO orderDTO = new OrderDTO(orderId,
                user.getId(),
                user.getName(),
                user.getEmail(),
                "fedex",
                10,
                20,
                30,
                40,
                "fedexAIR"
        );

        Order expectedOrder = new Order(orderId,
                user.getId(),
                user.getEmail(),
                orderDTO.getCarrierID().toUpperCase(),
                10,
                20,
                30,
                40,
                orderDTO.getServiceID().toUpperCase(),
                true
        );
        given(shipmentService
                .verifyOrder(eq(orderDTO)))
                .willReturn(expectedOrder);

        // when
        MockHttpServletResponse response = mvc.perform(
                post("/orders").contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequestOrder.write(orderDTO).getJson()))
                .andReturn().getResponse();

        // then
        then(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        then(response.getContentAsString()).isEqualTo(
                jsonResultOrder.write(
                        expectedOrder
                ).getJson());
    }

    @Test
    void postInvalidResult() throws Exception {

        // given an order with invalid data
        OrderDTO orderDTO = new OrderDTO(12345L,
                0,
                "",
                "",
                "",
                -10,
                -20,
                -30,
                -40,
                ""
        );

        // when
        MockHttpServletResponse response = mvc.perform(
                post("/orders").contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequestOrder.write(orderDTO).getJson()))
                .andReturn().getResponse();

        // then
        then(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());

    }


}
