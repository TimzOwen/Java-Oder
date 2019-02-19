package com.example.coffeeoder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    public   int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     *
     * @param view adds up the quantity of the + btn;
     */
    public void topUpCoffee(View view)
    {
        quantity += 1;
        displayQuantity(quantity);
    }

    /**
     *
     * This method is called when the Minus  button is clicked
     */
    public void dropCoffee(View view)
    {
        quantity -= 1;
        displayQuantity(quantity);


    }

    /**
     *
     * This method is called when the submit button is clicked
     */
    public void submitOder(View view)

    {
        EditText etName = (EditText)findViewById(R.id.et_Name);
        CheckBox cbWhippedCream = (CheckBox)findViewById(R.id.cb_whipped_cream);
        CheckBox cbChocolate = (CheckBox)findViewById(R.id.cb_chocolate);
          boolean hasChocolate = cbChocolate.isChecked();
          boolean hasWhippedcream = cbWhippedCream.isChecked();
          String userName=etName.getText().toString();
        int price = calculatePrice();
       displayMessage(createOderSummary(userName,price, hasWhippedcream, hasChocolate));

    }

    /**
     * method to put all the summary to the text
     * @return oder summary of the oder of the coffee;
     */
    public  String createOderSummary(String username,int price, boolean whippedCream, boolean chocolate)
    {

        String message = "Name: " + username;
               message += "\nHas  Whipped Cream ?: " + whippedCream;
               message += "\nHas Chocolate ? : " + chocolate;
               message +=  "\nQuantity: " + quantity;
               message +="\nTotal: $" + price;
               message +="\nThank you!";
               return message;
    }

    /**
     *
     * calculate the price of the coffee
     */

    public int calculatePrice()
    {
       return quantity * 5;
    }

    /**
     *
     * This method is called when the submit, + and - button is clicked
     */

    public void displayQuantity(int number)
    {

        TextView quantityTextview = (TextView) findViewById(R.id.tv_Quantity);

        quantityTextview.setText("" + number);

    }

    /**
     *
     * This method is called when submit button is clicked to display the String
     * depending on te quantity
     */
    public void displayMessage(String summary)
    {
        TextView oderSummary = (TextView)findViewById(R.id.tv_oder_summary);
        oderSummary.setText(summary);
    }



}
