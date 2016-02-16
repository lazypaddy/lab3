package com.example.jdolan.lab_3;


import android.content.Intent;
//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    // Validation criteria
    private static final String PHONE_REGEX = "^(0|\\+\\d{3}|00\\d{3})8[3-8]\\d{7}$" ;//^(08[3-8]|\+\d{3}8[3-7]|00\d{3}8[3-7])\d{7}$

    // Error Messages
    private static final String REQUIRED_MSG = "required";
    private static final String PHONE_MSG = "Invalid Phone Number";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button validate = (Button) findViewById(R.id.button);

        validate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phone_validate(v);
            }
        });


    }
    // call this method when you need to check phone number validation
    public static boolean isPhoneNumber(EditText editText, boolean required) {
        return isValid(editText, PHONE_REGEX, PHONE_MSG, required);
    }

    // return true if the input field is valid, based on the parameter passed
    public static boolean isValid(EditText editText, String regex, String errMsg, boolean required) {

        String text = editText.getText().toString().trim();
        // clearing the error, if it was previously set by some other values
        editText.setError(null);

        // text required and editText is blank, so return false
        if ( required && !hasText(editText) ) return false;

        // pattern doesn't match so returning false
        if (required && !Pattern.matches(regex, text)) {
            editText.setError(errMsg);
            return false;
        }

        return true;
    }

    // check the input field has any text or not
    // return true if it contains text otherwise false
    public static boolean hasText(EditText editText) {

        String text = editText.getText().toString().trim();
        editText.setError(null);

        // length 0 means there is no text
        if (text.length() == 0) {
            editText.setError(REQUIRED_MSG);

            return false;
        }

        return true;
    }
    public void phone_validate(View v1) {
        TextView ErrorTxt = (TextView) findViewById(R.id.textView2);
        Intent A2Intent = new Intent (v1.getContext(), Main2Activity.class);
        EditText phone = (EditText) findViewById(R.id.editText);
        if (isPhoneNumber(phone, true)){
            //make sure the Error Text is blank (null)
            ErrorTxt.setText("");
            // pass the entered phone number to the next activity
            //A2Intent.putExtra("phoneNumber", tv2.getText());
            String ph = phone.getText().toString();
            A2Intent.putExtra("phoneNumber", ph);
            // start the next activity/page
            startActivity(A2Intent);

        }
        else {
            ErrorTxt.setText("format needs to be 1 of the following: \n" +
                    "08[345678] abcdefg \n" +
                    "+ccc 8[345678] abcdefg \n" +
                    "00 ccc 8[345678] abcdefg");
        }


    }

}

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item); */
// }


