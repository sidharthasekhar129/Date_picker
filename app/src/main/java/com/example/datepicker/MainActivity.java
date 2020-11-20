package com.example.datepicker;

import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
   private DatePickerDialog.OnDateSetListener  onDateSetListener;
    private EditText editText;
    private TextView textView;

    private Calendar curentdate;
    int day, month, year;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        editText = (EditText) findViewById(R.id.editText);


        //for edittext 1
        curentdate = Calendar.getInstance();
        day = curentdate.get(Calendar.DAY_OF_MONTH);
        month = curentdate.get(Calendar.MONTH);
        year = curentdate.get(Calendar.YEAR);

        month = month + 1;
        editText.setText(day + "/" + month + "/" + year);

        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month = month + 1;
                        editText.setText(dayOfMonth + "/" + month + "/" + year);

                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });


        //for textview
        textView=(TextView)findViewById(R.id.textView);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, onDateSetListener, year, month, day);

                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();

            }
        });
        onDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                String data = (dayOfMonth + "/"+month+ "/" + year);
                textView.setText(data);
            }
        };





    }
}
