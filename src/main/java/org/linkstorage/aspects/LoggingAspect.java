package org.linkstorage.aspects;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author Nabeel Ali Memon
 */

@Component
@Aspect
public class LoggingAspect {
  //Pointcut definition for all repository transactions that get entities
  @Pointcut("execution(* org.linkstorage.repository.*.get*(..))")
  public void getterTransaction() {}

  //Pointcut definition for all repository transactions that add entities
  @Pointcut("execution(* org.linkstorage.repository.*.add*(..))")
  public void adderTransaction() {}

  //For common Advice on both Pointcuts we combine them to make a single Pointcut
  @Pointcut("adderTransaction() || getterTransaction()")
  public void adderOrGetterTransaction() {}

  //Advice that executes before an Adder or Getter Transaction Join Point is called
  @Before("adderOrGetterTransaction()")
  public void beforeTransaction() {
    System.out.println("------------------------------------");
    System.out.println("--------Beginning transaction-------");
    System.out.println("------------------------------------");
  }

  @AfterThrowing(pointcut = "adderOrGetterTransaction()", throwing = "throwable")
  public void adderOrGetterThrewException(Throwable throwable) {
    throw new RuntimeException("Transaction Unsuccessful. "+throwable.getMessage());
  }
  //Advice that executes after an Adder Transaction Join Point is executed
  @After("adderTransaction()")
  public void afterAdderTransaction() {
    System.out.println("-------Ending Adder Transaction-----");
  }

  //Advice that executes after a Getter Transaction Join Point is executed
  @AfterReturning(pointcut = "getterTransaction()", returning = "retVal")
  public void afterGetterTransaction(Object retVal) {
    System.out.println("Transaction returned value: "+ retVal.toString());
  }
}