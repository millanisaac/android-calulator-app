package com.example.calculator.Operands;

public class Operand {
  private int value;
  public Operand( String token ) {
    value = Integer.parseInt(token);
  }

  public Operand( int value ) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public static boolean check( String token ) {
    try {
      int testDouble = Integer.parseInt(token);
    }
    catch(Exception e){
      return false;
    }
    return true;
  }
}
