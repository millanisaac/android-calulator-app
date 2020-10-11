package com.example.calculator.Operators;

import com.example.calculator.Operands.Operand;


public class ExponentialOperator extends Operator {

    @Override
    public int priority() {
        return 4;
    }

    @Override
    public Operand execute(Operand op1, Operand op2) {
        return new Operand((int)Math.pow(op1.getValue(), op2.getValue()));
    }
    @Override
    public boolean isParenthesis(){ return false;}

}
