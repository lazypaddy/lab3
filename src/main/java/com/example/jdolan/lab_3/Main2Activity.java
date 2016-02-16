package com.example.jdolan.lab_3;

//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button ExitBtn = (Button) this.findViewById(R.id.button2);
        EditText phone2;
        phone2 = (EditText) this.findViewById(R.id.editText2);

        // read the passed phonenumber and display it in phone2
        String phoneno = getIntent().getStringExtra("phoneNumber");
        phone2.setText(phoneno);

        // exit to page 1 if the Exit button is clicked
        ExitBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();

            }
        });
    }
}
