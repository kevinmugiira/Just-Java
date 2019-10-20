package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 *The submitOrder method and the createOrderSummary method have under gone various changes, please follow keenly
 */



/**
 * This app displays an order form to order coffee
 */

public class MainActivity extends AppCompatActivity {

    int qunatity = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked
     */

    public void submitOrder(View view) {
        CheckBox cb = (CheckBox) findViewById(R.id.whipped_cream_checkBox);
        boolean hasWhippedCream = cb.isChecked();
        int howMuch = qunatity * 150 ;
        //String priceMessage = "Amount:ksh " + price;
        //priceMessage = "Name: Lyla Ali\nAdded Whipped cream: "+ hasWhippedCream +"\nQuantity:"+ qunatity + "\n"+ priceMessage;
        //priceMessage = priceMessage + "\nThankYou, Come again!";
        displayMessage(createOrderSummary(howMuch,hasWhippedCream));

        //can also use the commented lines above or this

    }

    private String createOrderSummary(int price,boolean addWhippedCream){
        CheckBox check = (CheckBox) findViewById(R.id.whipped_cream_checkBox);
        //boolean gotWhippedCream = check.isChecked();
        //int howMuch = qunatity * 150;
        String priceMessage = "Name: Lyla Ali";
         priceMessage += "\nAdded Whipped cream: " + addWhippedCream;
         priceMessage += "\nQuantity: " + qunatity;
         priceMessage = priceMessage + "\nAmount: " + price;
         priceMessage = priceMessage + "\ncome again!";
        return priceMessage;

    }

    /**
     *This method is called when the increment button is pressed
     */
    public void increment(View view) {
        qunatity = qunatity + 1;
        displayQuantity(qunatity);
    }


    /**
     * This method is called when the decrement button is pressed
     */

    public void decrement(View view) {
        qunatity = qunatity - 1;
        displayQuantity(qunatity);
    }



    /**
     * This method displays the given quantity value on the screen
     */

    private void displayQuantity(int number){
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
                quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen
     */

    //public void displayPrice(int number){
        //TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
       // priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    //}


    private void displayMessage(String message){
        TextView priceTextV = (TextView) findViewById(R.id.price_text_view);
        priceTextV.setText(message);
    }



}
