package com.example.calculator.Operators;


import com.example.calculator.Operands.Operand;

import java.util.HashMap;

public abstract class Operator {
  public static HashMap<String, Operator> operators = new HashMap<String, Operator>();
    static {
      operators.put("+", new AdditionOperator());
      operators.put("-", new SubtractionOperator());
      operators.put("*", new MultiplicationOperator());
      operators.put("/", new DivisionOperator());
      operators.put("^", new ExponentialOperator());
      operators.put("(", new OpenParenthesisOperator());
      operators.put(")", new ClosedParnethesisOperator());
    }
  public static Operator get(String token) {
    return operators.get(token);
  }
  // The Operator class should contain an instance of a HashMap
  // This map will use keys as the tokens we're interested in,
  // and values will be instances of the Operators.

  // Example:
  // Where does this declaration go? What should its access level be?
  // Class or instance variable? Is this the right declaration?
  // HashMap operators = new HashMap();
  // operators.put( "+", new AdditionOperator() );
  // operators.put( "-", new SubtractionOperator() );

  public abstract int priority();
  public abstract Operand execute(Operand op1, Operand op2 );
  public abstract boolean isParenthesis();

  public static boolean check( String token ) {

      return operators.containsKey(token);
  }
}
