package tacos.data;

import org.aspectj.weaver.ast.Or;
import org.springframework.data.repository.CrudRepository;
import tacos.beans.Order;

import java.util.Date;
import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {
    List<Order> findByZip(String zip);
    List<Order> readOrderByZipAndPlacedAtBetween(String zip, Date startDate, Date endDate);
}
