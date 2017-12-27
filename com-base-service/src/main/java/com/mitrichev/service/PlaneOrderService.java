package com.mitrichev.service;

import org.springframework.stereotype.Service;

/**
 * 2017/12/28 上午12:09
 *
 * @author 梅长苏
 * @version v2
 */
public interface PlaneOrderService {

  void createOrder(String flightno);

  Integer getOrderByNo(String flightno);

  Integer getAllPersons();

}
