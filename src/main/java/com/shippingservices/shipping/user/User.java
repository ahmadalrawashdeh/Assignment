package com.shippingservices.shipping.user;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * User class to identify user
 */

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class User {
    private long id; // users' ID, unique id to identify user
    private String name; // users' name
    private String email; // users' email address
}
