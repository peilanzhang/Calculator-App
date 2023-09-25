package com.cs407.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public EditText num1, num2;
    int num1_int, num2_int;

    /*
    * This method retrieves the given EditText numbers that will be used to do our calculations
    */
    public boolean getNum() {
        num1 = (EditText) findViewById(R.id.InputText1);
        num2 = (EditText) findViewById(R.id.InputText2);
        String num1_str = num1.getText().toString();
        String num2_str = num2.getText().toString();

        try {
            num1_int = Integer.parseInt(num1_str);
            num2_int = Integer.parseInt(num2_str);
        } catch (NumberFormatException e) {
            // Handle the case where input is not a valid integer.
            Toast.makeText(this, "Invalid input. Please enter valid numbers.", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(num1.equals("Please enter value 1") && num2.equals(null))
            {
            String result = "Please enter value 2";
            num2.setText(result);
            return false;
        }
        if(num1.equals(null) && num2.equals("Please enter value 2"))
        {
            String result = "Please enter value 1";
            num2.setText(result);
            return false;
        }
        if(num1.equals("Please enter value 1") || num2.equals("Please enter value 2"))
        {
            return false;
        }

        if((!num1.equals(null) && num2.equals(null))|| (!num1.equals("") && num2.equals("")) ){

            String result = "Please enter value 2";

            num2.setText(result);
            return false;
        }
        if((num1.equals(null) && !num2.equals(null))|| (num1.equals("") && !num2.equals("")) ){
            //checkAndClear();
            String result = "Please enter value 1";
            num2.setText(result);
            return false;
        }
        if((num1.equals(null) && num2.equals(null))|| (num1.equals("") && num2.equals("")) ){
            //checkAndClear();
            String result1 = "Please enter value 1";
            num2.setText(result1);
            String result2 = "Please enter value 2";
            num2.setText(result2);
            return false;
        }

        else {
            // converting string to int.
            num1_int = Integer.parseInt(num1_str);

            // converting string to int.
            num2_int = Integer.parseInt(num2_str);
        }
        return true;
    }

    /*
    * If the addition button is clicked on
    */
    public void add(View view) {
        if (getNum()) {
            int result = num1_int + num2_int;
            goToActivity(result);
        }
    }

    /*
     * If the subtraction button is clicked on
     */
    public void sub(View view) {
        if (getNum()) {
            int difference = num1_int - num2_int;
            goToActivity(difference);
        }
    }

    /*
     * If the multiplication button is clicked on
     */
    public void mult(View view) {
        if (getNum()) {
            int product = num1_int * num2_int;
            goToActivity(product);
        }
    }

    /*
     * If the division button is clicked on
     */
    public void div(View view) {
        if (getNum()) {
            if (num2_int == 0) {
                // Handle division by zero
                Toast.makeText(this, "Division by zero is not allowed.", Toast.LENGTH_SHORT).show();
            }
            else {
                int quotient = num1_int / num2_int;
                goToActivity(quotient);
            }
        }
    }

    /*
    * Brings us to a new page that will display the results
    */
    public void goToActivity(Integer result) {
        Intent intent = new Intent(this, CalculatorActivity.class);
        intent.putExtra("message", result);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}