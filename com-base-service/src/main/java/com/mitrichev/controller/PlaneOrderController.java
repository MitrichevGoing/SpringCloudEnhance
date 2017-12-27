package com.mitrichev.controller;

import com.mitrichev.service.PlaneOrderService;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 梅长苏
 * @version v2 2017/12/28 上午12:30
 */
@RestController
@RequestMapping("/plane-orders")
public class PlaneOrderController {

  @Resource
  private PlaneOrderService orderService;

  @GetMapping("/{flightno}")
  public String saveOrder(@PathVariable String flightno){
    orderService.createOrder(flightno);
    return "下单成功";
  }

  @GetMapping("/count")
  public String count(){
    Integer count = orderService.getOrderByNo("MU345");
    Integer allPersons = orderService.getAllPersons();
    return String.format("<h1>MU345 总票数10000 余票: %s 总下单人数:%s</h1>", count, allPersons);
  }

}
