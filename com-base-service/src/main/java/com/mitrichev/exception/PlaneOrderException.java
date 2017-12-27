package com.mitrichev.exception;

/**
 * @author 梅长苏
 * @version v2 2017/12/28 上午12:21
 */
public class PlaneOrderException extends RuntimeException{

  private String msg;

  private Integer code;

  public PlaneOrderException(){}

  public PlaneOrderException(String msg){
    super(msg);
    this.msg = msg;
  }

  public PlaneOrderException(String msg, Integer code){
    super(msg);
    this.msg = msg;
    this.code = code;
  }

}
