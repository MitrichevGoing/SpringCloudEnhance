package com.mitrichev.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author 梅长苏
 * @version v2 2017/12/28 上午12:14
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class PlaneOrderModel {

  private String flightNumber;

  private Integer tickets;

}
