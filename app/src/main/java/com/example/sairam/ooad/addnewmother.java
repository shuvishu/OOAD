package com.example.sairam.ooad;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.DatePicker;
import android.widget.EditText;

public class addnewmother extends Activity implements OnClickListener {


    EditText DATE;
     DatePickerDialog DOB_PICKER_DIALOG;

     SimpleDateFormat dateFormatter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addnewmother);
        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        DATE= (EditText) findViewById(R.id.datePicker);
        setDateTimeField();
    }

    private void setDateTimeField() {
        DATE.setOnClickListener(this);

        Calendar DOBcalender=Calendar.getInstance();
        DOB_PICKER_DIALOG=new DatePickerDialog(this, new OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Calendar newDate=Calendar.getInstance();
                newDate.set(year,month,dayOfMonth);
                DATE.setText(dateFormatter.format(newDate.getTime()));
            }
        },DOBcalender.get(Calendar.YEAR),DOBcalender.get(Calendar.MONTH),DOBcalender.get(Calendar.DAY_OF_MONTH));
    }

    @Override
    public void onClick(View v) {
        DOB_PICKER_DIALOG.show();
    }
}
