package com.kavsoftware.kaveer.number2words.Acivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kavsoftware.kaveer.number2words.JavaClass.EnglishNumberToWords;
import com.kavsoftware.kaveer.number2words.R;

public class MainActivity extends AppCompatActivity {

    EditText number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //2 lines of code make app fullscreen
        setContentView(R.layout.activity_main);
        setTitle("Number 2 words");

        number = findViewById(R.id.txtNumber);
        Button buttonConvert   = findViewById(R.id.BtnConvert);
        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{
                    if (number.getText().toString().length() != 0){

                        String result = EnglishNumberToWords.convert(Long.parseLong(number.getText().toString()));

                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setMessage(result)
                                .setTitle("Result")
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        // CONFIRM
                                    }
                                });
//                            .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
//                                public void onClick(DialogInterface dialog, int id) {
//                                    // CANCEL
//                                }
//                            });
                        // Create the AlertDialog object and return it
                        builder.create();
                        builder.show();
                    }
                }
                catch (Exception ex){
                    Log.d("error", ex.getMessage());
                }

            }

        });
    }

    @Override
    public void onBackPressed() {

        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

        Toast.makeText(this, "Press the back button once again to close the application.", Toast.LENGTH_SHORT).show();
    }
}
