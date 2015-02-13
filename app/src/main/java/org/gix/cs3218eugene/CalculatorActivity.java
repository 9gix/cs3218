package org.gix.cs3218eugene;

/**
 * Created by Eugene on 1/2/2015.
 */

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class CalculatorActivity extends ActionBarActivity {

    private boolean decimalPressed;
    private int decimalPlace;
    private int maxDecimalPlaces = 6;
    private float currentNumber;
    private TextView calculatorDisplay;
    private float result;
    private String currentOperator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        result = 0;
        currentOperator = "";
        calculatorDisplay = (TextView) findViewById(R.id.calculatorDisplay);
        currentNumber = 0;
        decimalPressed = false;
        decimalPlace = 0;
    }

    public void dotOnClick(View view){
        decimalPressed = true;
        decimalPlace = 0;
    }

    public void digitsOnClick(View view){
        float numberPressed = Float.parseFloat(((Button) view).getText().toString());
        if (decimalPressed) {
            decimalPlace++;
            if (decimalPlace < maxDecimalPlaces) {
                float decimals = (float) (numberPressed / Math.pow(10.0, decimalPlace));
                currentNumber = currentNumber + decimals;
                String displayStr = String.format("%." + decimalPlace + "f", currentNumber);
                calculatorDisplay.setText(displayStr);
            }
        } else  {
                currentNumber = currentNumber * 10 + numberPressed;
                calculatorDisplay.setText(String.valueOf((int) currentNumber));
        }

        if (currentOperator.equals("=")) {
            result = currentNumber;
        }

    }

    public void operatorOnClick(View view){
        if (currentOperator.equals("")){
            result = currentNumber;
        } else if(currentOperator.equals(getString(R.string.plus_btn))){
            result += currentNumber;
        } else if (currentOperator.equals(getString(R.string.minus_btn))){
            result -= currentNumber;
        } else if (currentOperator.equals(getString(R.string.multiply_btn))){
            result *= currentNumber;
        } else if (currentOperator.equals(getString(R.string.divide_btn))){
            result /= currentNumber;
        }

        currentOperator = ((Button) view).getText().toString();

        if (currentOperator.equals("=")){
            calculatorDisplay.setText(String.valueOf(result));
        } else {
            String displayStr = String.format("%." + decimalPlace + "f", result);
            calculatorDisplay.setText(displayStr);
        }

        currentNumber = 0;
        decimalPressed = false;
        decimalPlace = 0;
    }

    public void sinOnClick(View view){
        result = (float) Math.sin(Math.toRadians(currentNumber));
        calculatorDisplay.setText(String.valueOf(result));
        currentNumber = result;
        decimalPressed = false;
        decimalPlace = 0;
    }

    public void cosOnClick(View view){
        result = (float) Math.cos(Math.toRadians(currentNumber));
        calculatorDisplay.setText(String.valueOf(result));
        currentNumber = result;
        decimalPressed = false;
        decimalPlace = 0;
    }

    public void sqrtOnClick(View view){
        result = (float) Math.sqrt(currentNumber);
        calculatorDisplay.setText(String.valueOf(result));
        currentNumber = result;
        decimalPressed = false;
        decimalPlace = 0;
    }

    public void tanOnClick(View view){
        result = (float) Math.tan(Math.toRadians(currentNumber));
        calculatorDisplay.setText(String.valueOf(result));
        currentNumber = result;
        decimalPressed = false;
        decimalPlace = 0;
    }

    public void logOnClick(View view){
        result = (float) Math.log(currentNumber);
        calculatorDisplay.setText(String.valueOf(result));
        currentNumber = result;
        decimalPressed = false;
        decimalPlace = 0;
    }

    public void clear(View view){

        decimalPressed = false;
        decimalPlace = 0;
        currentNumber = 0;
        calculatorDisplay.setText(String.valueOf(currentNumber));
    }

    public void clearAll(View view){
        decimalPressed = false;
        decimalPlace = 0;
        currentNumber = 0;
        currentOperator = "";
        result = 0;
        calculatorDisplay.setText(String.valueOf(result));
    }


}
