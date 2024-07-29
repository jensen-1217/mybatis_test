import com.jensen.dao.OrderMapper;
import com.jensen.pojo.Order;
import com.jensen.pojo.OrderItem;
import com.jensen.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class OrderMapperTest {

    @Test
    public void testAddOrder(){
        SqlSession sqlSession = MyBatisUtil.openSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        Order order = new Order();
        order.setPayment(10000.0);
        order.setStatus(1);
        order.setPaymentType(2);
        int count1 = orderMapper.addOrder(order);

        OrderItem orderItem = new OrderItem();
        orderItem.setOrderId(order.getId());
        orderItem.setGoodsName("小米");
        orderItem.setGoodsPrice(1000);
        orderItem.setCount("10");
        int count2 = orderMapper.addOrderItem(orderItem);

        if (count1>0 && count2>0){
            MyBatisUtil.closeSqlSession(sqlSession);
            System.out.println("订单生成完成！");
        }
    }

}
