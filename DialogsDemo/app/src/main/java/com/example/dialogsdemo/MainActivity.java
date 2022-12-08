package com.example.dialogsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnDatePickerDialog, btnTimePickerDialog, btnAlertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initListeners();
    }

    private void initViews(){
        btnAlertDialog = findViewById(R.id.btnAlertDialog);
        btnDatePickerDialog = findViewById(R.id.btnDatePickerDialog);
        btnTimePickerDialog = findViewById(R.id.btnTimePickerDialog);
    }

    private void initListeners(){
        btnAlertDialog.setOnClickListener(new BtnAlertDialogClickListener());
        btnDatePickerDialog.setOnClickListener(new BtnDatePickerDialogClickListener());
        btnTimePickerDialog.setOnClickListener(new BtnTimePickerDialogClickListener());
    }

    class BtnDatePickerDialogClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    MainActivity.this,
                    new MyOnDateSetListener(),
                    2022,
                    11,
                    8
                    );
            datePickerDialog.show();
        }
    }

    class MyOnDateSetListener implements DatePickerDialog.OnDateSetListener {

        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            btnDatePickerDialog.setText(year + "--" + month + "--" + dayOfMonth);
        }
    }

    class BtnTimePickerDialogClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            TimePickerDialog timePickerDialog = new TimePickerDialog(
                    MainActivity.this,
                     new MyOnTimeSetListener(),
                    20,
                    40,
                    true
            );
            timePickerDialog.show();
        }
    }

    class MyOnTimeSetListener implements TimePickerDialog.OnTimeSetListener{
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            btnTimePickerDialog.setText(hourOfDay + ":" + minute);
        }
    }

    class BtnAlertDialogClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {

            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage("Do you really want to Submit the exam?");
            builder.setTitle("Exam Submit");
            builder.setIcon(R.drawable.ic_launcher_background);

            builder.setPositiveButton("yes",new PositiveBtnClickListener());
            builder.setNegativeButton("No", new NegativeBtnCLickListener());
            builder.setNeutralButton("NA",new NeutralBtnClickListener());

            AlertDialog logoutDialog = builder.create();
            logoutDialog.show();
        }
    }

    class PositiveBtnClickListener implements DialogInterface.OnClickListener{
        @Override
        public void onClick(DialogInterface dialog, int which) {
            makeToast("Yes Clicked");
        }
    }

    class NegativeBtnCLickListener implements DialogInterface.OnClickListener{
        @Override
        public void onClick(DialogInterface dialog, int which) {
            makeToast("No Clicked");
        }
    }

    class NeutralBtnClickListener implements DialogInterface.OnClickListener{
        @Override
        public void onClick(DialogInterface dialog, int which) {
            makeToast("NA Clicked");
        }
    }

    private void makeToast(String text){
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }
}