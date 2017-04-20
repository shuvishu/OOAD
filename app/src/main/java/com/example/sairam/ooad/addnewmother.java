package com.example.sairam.ooad;

import java.sql.BatchUpdateException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.text.InputType;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class addnewmother extends Activity{


    EditText DATE,USERNAME,PASSWORD,MOTHER_NAME,NO_BABIES_EARLIER;
    RadioGroup DELIVERED,PRAGNENT;
    String delivered,pragnent;
     DatePickerDialog DOB_PICKER_DIALOG;

     SimpleDateFormat dateFormatter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addnewmother);
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);



        findViewsById();
        DATE.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar DOBcalender=Calendar.getInstance();
                DOB_PICKER_DIALOG=new DatePickerDialog(addnewmother.this, new OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        Calendar newDate=Calendar.getInstance();
                        newDate.set(year,month,dayOfMonth);
                        DATE.setText(dateFormatter.format(newDate.getTime()));
                    }
                },DOBcalender.get(Calendar.YEAR),DOBcalender.get(Calendar.MONTH),DOBcalender.get(Calendar.DAY_OF_MONTH));
                DOB_PICKER_DIALOG.show();
            }
        });
        DELIVERED.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                delivered=(String) ((RadioButton)findViewById(DELIVERED.getCheckedRadioButtonId())).getText();
            }
        });
        PRAGNENT.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                pragnent=(String) ((RadioButton)findViewById(PRAGNENT.getCheckedRadioButtonId())).getText();
            }
        });


    }


    private void findViewsById()
    {
        DATE= (EditText) findViewById(R.id.datePicker);
        USERNAME= (EditText) findViewById(R.id.NMusername);
        PASSWORD= (EditText) findViewById(R.id.NMpass);
        MOTHER_NAME= (EditText) findViewById(R.id.NMname);
        NO_BABIES_EARLIER= (EditText) findViewById(R.id.no_babies_earlier);
        DELIVERED= (RadioGroup) findViewById(R.id.RGbabyDelivered);
        PRAGNENT= (RadioGroup) findViewById(R.id.Ispragnent);
    }




    public void addNewMother(View v) {

            String nmusername=USERNAME.getText().toString();
            String nmpass=PASSWORD.getText().toString();
            String nmname=MOTHER_NAME.getText().toString();
            String method="addnewMother";
            String no_baby_ear=NO_BABIES_EARLIER.getText().toString();
            String dob=DATE.getText().toString();
            BackGroundTask backGroundTask=new BackGroundTask(this);
            backGroundTask.execute(method,nmusername,nmpass,nmname,no_baby_ear,delivered,pragnent,dob);

    }


}
