package eecs40.assignment2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



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
    private TextView outputNumber;
    private Button clear;
    private Button delete;
    private Button add;
    private Button subtract;
    private Button multiply;
    private Button divide;
    private Button equal;
    private Button percentage;
    private Button decimal;
    private float numberOne;
    private float numberTwo;


    enum Operation{
        ADD, SUBTRACT, MULTIPLY, DIVIDE, NONE;
    }

    private int reset = 1;
    private int continueEqual = 0;
    private Operation operation = Operation.NONE;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupButtons();

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNumber("1");


            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNumber("2");

            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNumber("3");

            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNumber("4");

            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNumber("5");

            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNumber("6");

            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNumber("7");

            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNumber("8");

            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNumber("9");

            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNumber("0");

            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                outputNumber.setText("0");
                operation = Operation.NONE;
                numberOne = 0;
                numberTwo = 0;
                reset = 1;
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!outputNumber.getText().toString().equals("")) {
                    backSpace();
                }
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOperation(Operation.ADD);
            }
        });

        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOperation(Operation.SUBTRACT);
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOperation(Operation.MULTIPLY);
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOperation(Operation.DIVIDE);
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(operation){
                    case NONE:
                        inputNumber(outputNumber.getText().toString());
                        break;
                    case ADD:
                        setnumberTwo();
                        numberOne = numberOne + numberTwo;
                        break;
                    case SUBTRACT:
                        setnumberTwo();
                        numberOne = numberOne - numberTwo;
                        break;
                    case MULTIPLY:
                        setnumberTwo();
                        numberOne = numberOne * numberTwo;
                        break;
                    case DIVIDE:
                        setnumberTwo();
                        numberOne = numberOne / numberTwo;


                }
                reset = 1;
                displayNumber(numberOne);
            }
        });

        percentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOperation(Operation.NONE);
                setnumberTwo();
                numberOne = numberOne/100;
                reset = 1;
                displayNumber(numberOne);
            }
        });

        decimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (outputNumber.getText().toString().indexOf(".") == - 1 || reset == 1){
                    inputNumber(".");
                }

            }
        });


    }

    private void backSpace(){
        outputNumber.setText(outputNumber.getText().toString().substring(0, outputNumber.getText().toString().length()-1));
    }

    private void setOperation(Operation holdOp){

        if(!outputNumber.getText().toString().equals("")) {
            continueEqual = 1;
            reset = 1;
            numberOne = Float.parseFloat(outputNumber.getText().toString());
            operation = holdOp;
        }
    }

    private void setnumberTwo(){
        if (continueEqual == 1) {
            continueEqual = 0;
            numberTwo = Float.parseFloat(outputNumber.getText().toString());
        }
    }

    private void inputNumber(String x){
        if(reset == 1) {
            outputNumber.setText("");
            reset = 0;
            if(x.equals(".")){
                outputNumber.setText("0");
            }
        }
            outputNumber.setText(outputNumber.getText().toString() + x);
    }

    private void displayNumber(float holdNumber){
        if(holdNumber < 999999999 && holdNumber%1== 0 && holdNumber>-999999999){
            outputNumber.setText(Integer.toString(Math.round(holdNumber)));
        }
        else {
            outputNumber.setText(Float.toString(holdNumber));
        }
    }


    private void setupButtons(){

        one = (Button)findViewById(R.id.Number1);
        two = (Button)findViewById(R.id.Number2);
        three = (Button)findViewById(R.id.Number3);
        four = (Button)findViewById(R.id.Number4);
        five = (Button)findViewById(R.id.Number5);
        six = (Button)findViewById(R.id.Number6);
        seven = (Button)findViewById(R.id.Number7);
        eight = (Button)findViewById(R.id.Number8);
        nine = (Button)findViewById(R.id.Number9);
        zero = (Button)findViewById(R.id.Number0);
        outputNumber = (TextView)findViewById(R.id.Number);
        clear = (Button)findViewById(R.id.Clear);
        delete = (Button)findViewById(R.id.Delete);
        add = (Button)findViewById(R.id.Add);
        subtract = (Button)findViewById(R.id.Subtract);
        multiply = (Button)findViewById(R.id.Multiply);
        divide = (Button)findViewById(R.id.Divide);
        equal = (Button)findViewById(R.id.Equal);
        percentage = (Button)findViewById(R.id.Percentage);
        decimal = (Button)findViewById(R.id.Decimal);
    }
}
