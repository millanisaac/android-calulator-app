package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.Array;

public class MainActivity extends AppCompatActivity {
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button zero;
    private Button plus;
    private Button clear;
    private Button times;
    private Button divided;
    private Button equals;
    private Button power;
    private Button minus;
    private Button left;
    private Button right;
    private Button back;
    private TextView result;
    private Evaluator evaluator;
    //private Button[] buttons = new Button(20) ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUIView();
        evaluator = new Evaluator();
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText()+ "0");
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText()+ "1");
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText()+ "2");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText()+ "3");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText()+ "4");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText()+ "5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText()+ "6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText()+ "7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText()+ "8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText()+ "9");
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText()+ "-");
            }
        });
        power.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText()+ "^");
            }
        });
        divided.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText()+ "/");
            }
        });
        times.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText()+ "*");
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText("");
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText()+ "+");
            }
        });
        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int answer = evaluator.eval((String) result.getText());
                    result.setText(Integer.toString(answer));
                }catch(Exception e) {
                    result.setText("");
                }
                }

        });
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText()+ "(");
            }
        });
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText()+ ")");
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String results = (String) result.getText();
                results = results.substring(0,result.getText().length()-1);
                result.setText(results);
            }
        });
    }

    private void setupUIView() {
     for(int i = 0; i < 20; i++){

            one = findViewById(R.id.One);
            two = findViewById(R.id.Two);
            three = findViewById(R.id.Three);
            four = findViewById(R.id.Four);
            five = findViewById(R.id.Five);
            six = findViewById(R.id.Six);
            seven = findViewById(R.id.Seven);
            eight = findViewById(R.id.Eight);
            nine = findViewById(R.id.Nine);
            zero = findViewById(R.id.Zero);
            plus = findViewById(R.id.Plus);
            clear = findViewById(R.id.C);
            times = findViewById(R.id.Multiplication);
            divided = findViewById(R.id.Divide);
            equals = findViewById(R.id.Equals);
            power = findViewById(R.id.Exponent);
            minus = findViewById(R.id.Minus);
            result = findViewById(R.id.textView);
            right = findViewById(R.id.Right);
            left = findViewById(R.id.Left);
            back = findViewById(R.id.back);
        }

    }

}
