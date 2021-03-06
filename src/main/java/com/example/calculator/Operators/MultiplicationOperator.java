package com.example.calculator.Operators;

import com.example.calculator.Operands.Operand;


public class MultiplicationOperator extends Operator {

    @Override
    public int priority() {
        return 3;
    }

    @Override
    public Operand execute(Operand op1, Operand op2) {
        return new Operand(op1.getValue() * op2.getValue());
    }
    @Override
    public boolean isParenthesis(){ return false;}

}

