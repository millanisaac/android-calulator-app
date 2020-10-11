package com.example.calculator;

import android.content.Context;
import android.view.View;
import android.widget.Button;

import com.example.calculator.Operands.Operand;
import com.example.calculator.Operators.Operator;

public class CalculatorButton extends androidx.appcompat.widget.AppCompatButton {
    public CalculatorButton(Context calculatorText ){
        super(calculatorText);
    }



    public boolean isOperand(){
        return Operand.check((String) super.getText());
    }
    public boolean isOperator(){
        return Operator.check((String) super.getText());
    }
}
