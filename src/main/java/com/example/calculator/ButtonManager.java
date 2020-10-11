package com.example.calculator;

import com.example.calculator.CalculatorButton;
import com.example.calculator.Evaluator;

public class ButtonManager {
    private static Evaluator evaluator = new Evaluator();
    private static String expression = "";
    private static void addToExpression( String input ){
        expression +=input;
    }
    private static String evaluateExpression(){
        String answer = Integer.toString( evaluator.eval(expression) );
        clearExpression();
        return answer;
    }
    private static void clearExpression(){
        expression = "";
    }
    public static String receiveButtonCommand( CalculatorButton button ){
        if( button.isOperand() || button.isOperator()) {
           addToExpression((String) button.getText());
           return expression;
        }
        else if ( button.getText().equals("=") ){
            String answer;
            answer = evaluateExpression();
            clearExpression();
            addToExpression(answer);
            return answer;
        }
        clearExpression();
        return "";
    }
}


