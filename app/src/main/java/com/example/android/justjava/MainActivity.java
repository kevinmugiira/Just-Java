package com.example.android.justjava;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

        int howMuch = qunatity * 150 ;

        //handles the edit text
        EditText edtext = (EditText) findViewById(R.id.name_editText);
        String jina = edtext.getText().toString();

        //handles the whipped cream checkbox
        CheckBox cb = (CheckBox) findViewById(R.id.whipped_cream_checkBox);
        boolean hasWhippedCream = cb.isChecked();
        if (hasWhippedCream){
            howMuch = howMuch + 50;
        }

        //handles the chocolate checkbox
        CheckBox checkB = (CheckBox) findViewById(R.id.chocolate_checkBox);
        boolean hasChocolate = checkB.isChecked();
        if (hasChocolate){
            howMuch = howMuch + 50;
        }

        Intent inte = new Intent(Intent.ACTION_SENDTO);
        inte.setData(Uri.parse("mailto:"));
        inte.putExtra(Intent.EXTRA_SUBJECT, "Just Java order for " + jina);
        inte.putExtra(Intent.EXTRA_TEXT, createOrderSummary(howMuch,hasWhippedCream,hasChocolate,jina));
        if (inte.resolveActivity(getPackageManager()) != null) {
            startActivity(inte);
        }
        //String priceMessage = "Amount:ksh " + price;
        //priceMessage = "Name: Lyla Ali\nAdded Whipped cream: "+ hasWhippedCream +"\nQuantity:"+ qunatity + "\n"+ priceMessage;
        //priceMessage = priceMessage + "\nThankYou, Come again!";
        //displayMessage(createOrderSummary(howMuch,hasWhippedCream,hasChocolate,jina));

        //can also use the commented lines above or this

    }


//    public void nextpage(View view){
//        Button btn = (Button) findViewById(R.id.next_btn);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent in = new Intent(getApplicationContext(),SecondActivity.class);
//                startActivity(in);
//            }
//        });
//    }
//

    private String createOrderSummary(int price,boolean addWhippedCream,boolean addChocolate,String name){
        //CheckBox check = (CheckBox) findViewById(R.id.whipped_cream_checkBox);
        //boolean gotWhippedCream = check.isChecked();
        //int howMuch = qunatity * 150;
        String priceMessage = "Name: " + name;
         priceMessage += "\nAdded Whipped cream: " + addWhippedCream;
         priceMessage += "\nAddedChocolate: " + addChocolate;
         priceMessage += "\nQuantity: " + qunatity;
         priceMessage = priceMessage + "\nAmount: " + price;
         priceMessage = priceMessage + "\ncome again!";
        return priceMessage;

    }

    /**
     *This method is called when the increment button is pressed
     * A toast is used to notify the maximum limit
     */
    public void increment(View view) {
        qunatity = qunatity + 1;
        if (qunatity > 100){

            qunatity = 100;

            //Toast
            Context context = getApplicationContext();
            CharSequence text = "Can not order more than 100";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            return;
        }
        displayQuantity(qunatity);
    }


    /**
     *         Or
     *
     * public void increment(View view) {
     *
     *         if (qunatity == 100){
     *
     *             //Toast
     *             Context context = getApplicationContext();
     *             CharSequence text = "Can not order more than 100";
     *             int duration = Toast.LENGTH_SHORT;
     *
     *             Toast toast = Toast.makeText(context, text, duration);
     *             toast.show();
     *
     *             return;
     *         }
     *         qunatity = qunatity + 1;
     *         displayQuantity(qunatity);
     *     }
     */


    /**
     * This method is called when the decrement button is pressed
     * A toast is used to notify the minimum limit
     */

    public void decrement(View view) {
        qunatity = qunatity - 1;
        if (qunatity < 1){
            qunatity = 1;

            //Toast
            Context context = getApplicationContext();
            CharSequence text = "Can not order less than 1";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            return;
        }
        displayQuantity(qunatity);
    }


    /**
     *        Or
     *
     * public void decreament (View view) {
     *     if (qunatity ==1){
     *         //Toast
     *         Toast.makeText(this, "Can not order less than 1", Toast.LENGTH_SHORT).show();
     *         return;
     *     }
     *     qunatity = qunatity - 1;
     *     displayQuantity(qunatity)
     * }
     */



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


//    private void displayMessage(String message){
//        TextView priceTextV = (TextView) findViewById(R.id.price_text_view);
//        priceTextV.setText(message);
//    }



}
