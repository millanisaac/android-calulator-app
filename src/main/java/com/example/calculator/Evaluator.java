package com.example.calculator;

import java.util.*;

import com.example.calculator.Operands.Operand;
import com.example.calculator.Operators.Operator;
public class Evaluator {
  private Stack<Operand> operandStack;
  private Stack<Operator> operatorStack;

  private StringTokenizer tokenizer;
  private static final String DELIMITERS = "+-*^/() ";

  public Evaluator() {
    operandStack = new Stack<>();
    operatorStack = new Stack<>();
  }

  public int eval(String expression) {
    String token;

    // The 3rd argument is true to indicate that the delimiters should be used
    // as tokens, too. But, we'll need to remember to filter out spaces.
    this.tokenizer = new StringTokenizer(expression, DELIMITERS, true);

    // initialize operator stack - necessary with operator priority schema
    // the priority of any operator in the operator stack other than
    // the usual mathematical operators - "+-*/" - should be less than the priority
    // of the usual operators

    while (this.tokenizer.hasMoreTokens()) {
      // filter out spaces
      if (!(token = this.tokenizer.nextToken()).equals(" ")) {
        // check if token is an operand
        if (Operand.check(token)) {
          operandStack.push(new Operand(token));
        }
        else {
          if (!Operator.check(token)) {
            System.out.println("*****invalid token******");
            System.exit(1);
          }
          Operator newOperator =  Operator.get(token);
          //if Operator is Open parenthesis it automatically gets put into the operator stack else it follows the algorithm
          if ( !token.equals("(") ) {
            //processes all the equation that is between "(" and ")" and then pops "(" out of the stack
            if ( token.equals(")") ) {
              while ( (!operatorStack.isEmpty() && operatorStack.peek().priority() >= newOperator.priority()) && !operatorStack.peek().isParenthesis() ) {
                processEquation(operandStack, operatorStack);
              }
              operatorStack.pop();
            }
            else {
              //if operator follows the oder of operation then the equation will calculate until it
              while ( !operatorStack.isEmpty() && operatorStack.peek().priority() >= newOperator.priority() && !operatorStack.peek().isParenthesis() ) {
                processEquation(operandStack, operatorStack);
              }
            }
          }
          if ( !token.equals(")") ) /*makes sure that the ")" never gets put into the stack*/ {
            operatorStack.push(newOperator);
          }
        }
      }
    }
    //now the whole string has been put into is respected stack now it is time to evaluate the whole expression
    while ( !operatorStack.isEmpty() ) {
      processEquation(operandStack, operatorStack);
    }
    return operandStack.pop().getValue();




  }
  private void processEquation(Stack<Operand> operandStack, Stack<Operator> operatorStack ){
    // note that when we eval the expression 1 - 2 we will
    // push the 1 then the 2 and then do the subtraction operation
    // This means that the first number to be popped is the
    // second operand, not the first operand - see the following code
    Operator oldOperator = operatorStack.pop();
    Operand operand2 = operandStack.pop();
    Operand operand1 = operandStack.pop();
    operandStack.push(oldOperator.execute(operand1, operand2));
  }
}
