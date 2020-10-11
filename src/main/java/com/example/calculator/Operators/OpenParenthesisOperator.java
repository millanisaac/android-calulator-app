package com.example.calculator.Operators;

import com.example.calculator.Operands.Operand;

public class OpenParenthesisOperator extends Operator {

    @Override
    public int priority() {
        return 1;
    }

    @Override
    public Operand execute(Operand op1, Operand op2) {
        return new Operand(-1);
    }
    @Override
    public boolean isParenthesis(){ return true;}

}

