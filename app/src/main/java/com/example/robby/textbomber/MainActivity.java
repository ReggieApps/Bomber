package com.example.robby.textbomber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button pissOffButton;

    private EditText vicNumber;
    private EditText vicMessage;
    private EditText vicAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pissOffButton = (Button) findViewById(R.id.button_piss_off);

        vicNumber = (EditText) findViewById(R.id.edittext_number);
        vicMessage = (EditText) findViewById(R.id.edittext_message);
        vicAmount = (EditText) findViewById(R.id.edittext_number_of_times);

        pissOffButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //when we click the button, THIS CODE BELOW executes
                String phoneNumber = vicNumber.getText().toString();
                String message = vicMessage.getText().toString();
                int spamCount = Integer.parseInt(vicAmount.getText().toString());

                SmsManager manager = SmsManager.getDefault();

                for(int i = 0; i < spamCount; i++){
                    manager.sendTextMessage(phoneNumber, null, message, null, null);
                }

                //END EXECUTION FOR BUTTON CLICK
            }
        });
    }
}
