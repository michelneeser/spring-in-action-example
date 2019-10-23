package com.michelneeser.tacos.data;

import com.michelneeser.tacos.Order;

public interface OrderRepository {

    Order save(Order order);

}