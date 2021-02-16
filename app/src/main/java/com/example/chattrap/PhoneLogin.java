package com.example.chattrap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hbb20.CountryCodePicker;

public class PhoneLogin extends AppCompatActivity {

    Button continueButton;
    EditText phoneNumberText;

    CountryCodePicker ccp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_login);

        ccp=(CountryCodePicker)findViewById(R.id.ccp);

        phoneNumberText=(EditText)findViewById(R.id.verify_phone_number);

        ccp.registerCarrierNumberEditText(phoneNumberText);


        continueButton=(Button)findViewById(R.id.verify_continue_button);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(phoneNumberText.getText().toString().replace(" ","").length()==0)
                {
                    Toast.makeText(getApplicationContext(),"INVALID , Blank Field",Toast.LENGTH_SHORT).show();
                }
                else if(phoneNumberText.getText().toString().replace(" ","").length()<10)
                {
                    Toast.makeText(getApplicationContext(),"INVALID , Phone Number Entered is too short",Toast.LENGTH_SHORT).show();
                }
                else if(phoneNumberText.getText().toString().replace(" ","").length()>10)
                {
                    Toast.makeText(getApplicationContext(),"INVALID , Phone Number Entered is too long",Toast.LENGTH_SHORT).show();
                }
                else{
                Intent loginIntent=new Intent(PhoneLogin.this,OtpActivity.class);
                loginIntent.putExtra("phoneN",ccp.getFullNumberWithPlus().replace(" ",""));
                startActivity(loginIntent);
                }
            }
        });

    }
}