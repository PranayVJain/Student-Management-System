package com.sms.studentmanager.service;

import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.stereotype.Component;

@Component
public class SequenceKeyGenerator implements KeyGenerator {

  private final AtomicInteger value = new AtomicInteger(1);

  @Override
  public int getNext() {
    return value.getAndIncrement();
  }
}