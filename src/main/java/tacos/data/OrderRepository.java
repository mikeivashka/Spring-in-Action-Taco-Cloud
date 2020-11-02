package tacos.data;

import tacos.beans.Order;

public interface OrderRepository {
    Order save(Order order);
}
