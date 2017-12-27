package com.mitrichev.service.impl;

import com.mitrichev.exception.PlaneOrderException;
import com.mitrichev.service.PlaneOrderService;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author 梅长苏
 * @version v2 2017/12/28 上午12:11
 */
@Service
public class PlaneOrderServiceImpl implements PlaneOrderService {

  private Logger logger = LoggerFactory.getLogger(getClass());

  static Map<String, Integer> planes;
  static Map<String, String> persons;

  static {
    planes = new HashMap<>();
    persons = new HashMap<>();
    planes.put("MU345",10000);
  }


  @Override
  public synchronized void createOrder(String flightno) {
    //1.查库存
    Integer count = planes.get(flightno);
    if(count == 0){
      throw new PlaneOrderException("机票已售完");
    }
    //2.下单
    String uuid = UUID.randomUUID().toString();
    persons.put(uuid, flightno);
    //3.减库存
    count = count -1;
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {
      logger.error("下单失败 error:{}", e.getMessage());
    }
    //4.更新库存
    planes.put(flightno, count);

    logger.info("下单成功，UUID: {}，flightno:{}, 库存：{}",uuid, flightno, count);
  }

  @Override
  public Integer getOrderByNo(String flightno) {
    return planes.get(flightno);
  }

  @Override
  public Integer getAllPersons() {
    return persons.size();
  }
}
