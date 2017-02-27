package com.fabvest_inc.ru.instaphiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    Button mButton;

    EditText passText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        passText = (EditText)findViewById(R.id.editText2);

        mButton = (Button)findViewById(R.id.button2);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(passText.getText().toString().equals("1111")){
                    passText.getText().clear();
                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(MainActivity.this, "Wrong pass", Toast.LENGTH_LONG)
                            .show();
                }
            }
        });
    }
}
