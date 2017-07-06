package com.pushkaranand.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.pushkaranand.calculator.R.id.info;

public class MainActivity extends AppCompatActivity {



    private Button zero;
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button add;
    private Button subtract;
    private Button multiply;
    private Button divide;
    private Button decimal;
    private Button percentage;
    private Button ac;
    private Button back;
    private Button equals;
    private TextView choice;
    private TextView result;
    private final char ADDITION = '+';
    private final char SUBTRACTION = '-';
    private final char MULTIPLICATION = '*';
    private final char DIVISION = '/';
    private final char PERCENTAGE = '%';
    private final char EQUAL = 0;
    private double value1 = Double.NaN;
    private double value2;
    private char ACTION;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createLinks();

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice.setText(choice.getText().toString() + "0");
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice.setText(choice.getText().toString() + "1");
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice.setText(choice.getText().toString() + "2");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice.setText(choice.getText().toString() + "3");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice.setText(choice.getText().toString() + "4");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice.setText(choice.getText().toString() + "5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice.setText(choice.getText().toString() + "6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice.setText(choice.getText().toString() + "7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice.setText(choice.getText().toString() + "8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice.setText(choice.getText().toString() + "9");
            }
        });
        decimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice.setText(choice.getText().toString() + ".");
            }
        });


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = ADDITION;
                result.setText(String.valueOf(value1) + "+");
                choice.setText(null);
            }
        });
        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = SUBTRACTION;
                result.setText(String.valueOf(value1) + "-");
                choice.setText(null);
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = MULTIPLICATION;
                result.setText(String.valueOf(value1) + "x");
                choice.setText(null);
            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = DIVISION;
                result.setText(String.valueOf(value1) + "/");
                choice.setText(null);
            }
        });
        percentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                value1=value1/100;
                result.setText(String.valueOf(value1));
                choice.setText(null);
            }
        });
        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = EQUAL;
                result.setText(result.getText().toString() + String.valueOf(value2)+ "=" + String.valueOf(value1));
                choice.setText(null);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(choice.getText().length()<=1){
                    value1 = Double.NaN;
                    value2 = Double.NaN;
                    choice.setText("0");
                    result.setText(null);
                }
                else if(choice.getText().length()>=1){
                    CharSequence sequence = choice.getText().toString();
                    choice.setText(sequence.subSequence(0,sequence.length()-1));
                }

            }
        });
        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value1 = Double.NaN;
                value2 = Double.NaN;
                choice.setText("0");
                result.setText(null);
            }
        });

    }


    private void createLinks(){

        zero = (Button)findViewById(R.id.btn0);
        one = (Button)findViewById(R.id.btn1);
        two = (Button)findViewById(R.id.btn2);
        three = (Button)findViewById(R.id.btn3);
        four = (Button)findViewById(R.id.btn4);
        five = (Button)findViewById(R.id.btn5);
        six = (Button)findViewById(R.id.btn6);
        seven = (Button)findViewById(R.id.btn7);
        eight = (Button)findViewById(R.id.btn8);
        nine = (Button)findViewById(R.id.btn9);
        add = (Button)findViewById(R.id.btnadd);
        subtract = (Button)findViewById(R.id.btnsubtract);
        multiply = (Button)findViewById(R.id.btnmultiply);
        divide = (Button)findViewById(R.id.btndivide);
        decimal = (Button)findViewById(R.id.btndecimal);
        percentage = (Button)findViewById(R.id.btnpercentage);
        ac = (Button)findViewById(R.id.btnac);
        back = (Button)findViewById(R.id.btnback);
        equals = (Button)findViewById(R.id.btnequals);
        zero = (Button)findViewById(R.id.btn0);
        choice = (TextView)findViewById(R.id.tvchoice);
        result = (TextView)findViewById(R.id.tvresult);

    }

    private void compute(){

        if(!Double.isNaN(value1)){

           value2 = Double.parseDouble(choice.getText().toString());

            switch(ACTION){

                case ADDITION:
                    value1 = value1 + value2;
                    break;
                case SUBTRACTION:
                    value1 = value1 - value2;
                    break;
                case MULTIPLICATION:
                    value1 = value1 * value2;
                    break;
                case DIVISION:
                    value1 = value1 / value2;
                    break;
                case EQUAL:
                    break;

            }
        }

        else{
            value1 = Double.parseDouble(choice.getText().toString());

        }
    }
}
