package com.example.android.justjava2;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int quantity = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public  void submitOrder(View view){
       // int quantity = 5;
       // display(quantity);
        //displayPrice(quantity*5);
        int price = calculatePrice();
        String priceMessage = createOrderSummary(price);
        displayMessage(priceMessage);
        // or int price = calculatePrice();
        //dispalyMessage(createOrderSummary(price))


    }

    /**
     * Calculates the price of the order.
     * @return  total price
     */

    private int calculatePrice(){
       return quantity * 5;
    }

    /**
     * Create the summary of Orders
     * @param price of the order
     * @return Text summary
     */
    private String createOrderSummary(int price){
        String priceMessage = "Name : H" ;
        priceMessage += "\n Quantity :" + quantity ;
        priceMessage += "\nTotal : " + price +"$";
        priceMessage += "\nThank you";
        return priceMessage;

    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setTextSize(20);
        orderSummaryTextView.setTextColor(Color.RED);
        orderSummaryTextView.setText(message);

    }
//  this method git user input in editText and convert it to integer and checck if input is right and make quantity = user input

    public void userInputQuantity (View view){
        EditText num = (EditText) findViewById(R.id.user_input_qun) ;
        if (num.getText().toString().length() > 0)
        {
            int val = Integer.parseInt( num.getText().toString() );
            if(val > 10)
                Toast.makeText(getApplicationContext(), "Enter a value between 0 and 10!", Toast.LENGTH_SHORT).show();
            else
            if(val<0)
                Toast.makeText(getApplicationContext(), "Enter a value between 0 and 10!", Toast.LENGTH_SHORT).show();
            else
            if(val >= 0 && val <=10)
            {
                quantity = val;
                displayQuantity(val);
                TextView quantityTextView = (TextView)findViewById(R.id.quantity_text_view);
            }
        }
        else
        {
            // HANDLE EMPTY VALUE HERE
            Toast.makeText(getApplicationContext(), "Enter a value between 0 and 10!", Toast.LENGTH_SHORT).show();
        }
//        int val = Integer.parseInt( num.getText().toString() );
//        quantity = val;
//        displayQuantity(val);
    }
//    public  void input(View view){
//        EditText userInput = (EditText) findViewById(R.id.user_input_qun);
//        int val = Integer.parseInt( userInput.getText().toString() );
//        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
//        quantityTextView.setText(""+ val);
//        quantity = Integer.parseInt((quantityTextView.getText().toString()));
//        displayQuantity(quantity);
//
//    }

    public void increment(View view){
        InputMethodManager inputManager =
                (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(
                this.getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
        if (quantity== 100){
            //SHOW AN ERROR MASSAGE AS A TOAST
            Toast.makeText(getApplicationContext(),"YOU REACH MAXIMUM QUANTITY",Toast.LENGTH_SHORT).show();
            //EXIT THIS METHOD EARLY COZ NOTHING LEFT TO TO DO
            return;
        }else
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    public void decrement(View view){
        InputMethodManager inputManager =
                (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(
                this.getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
        if (quantity == 1) {
            //SHOW AN ERROR MASSAGE AS A TOAST
            Toast.makeText(getApplicationContext(),"YOU REACH MINIMUM QUANTITY",Toast.LENGTH_SHORT).show();
            //EXIT THIS METHOD EARLY COZ NOTHING LEFT TO TO DO
            //Change button color to red
//            Button decrement = (Button)findViewById(R.id.decrement);
//            decrement.setBackgroundColor(Color.RED);
            return;
        }else
            quantity = quantity - 1;
        displayQuantity(quantity);
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int numberOfCoffees){
        TextView quantityTextView = (TextView)findViewById(R.id.quantity_text_view);
        if (numberOfCoffees <= 0 ){
            Toast.makeText(getApplicationContext(),"You Can't Order Zero Cofee",Toast.LENGTH_SHORT).show();
            //EXIT THIS METHOD EARLY COZ NOTHING LEFT TO TO DO
            return;
        }else if (numberOfCoffees >= 100){
            Toast.makeText(getApplicationContext(),"YOU REACH MINIMUM QUANTITY",Toast.LENGTH_SHORT).show();
            //EXIT THIS METHOD EARLY COZ NOTHING LEFT TO TO DO
            return;
        }else
        quantityTextView.setText("" + numberOfCoffees);
    }
    /**
     * This method displays the given price on the screen.
     */
//    private void displayPrice(int number) {
//        TextView priceTextView = (TextView) findViewById(R.id.order_summary_text_view);
//        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
//    }
}
