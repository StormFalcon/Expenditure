package com.falcon.storm.expenditure;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;


public class addExpenses extends ActionBarActivity {

    // Date
    private TextView dateDisplay;
    private TextView dayDisplay;
    private Button editDate;

    private int year;
    private int month;
    private int day;
    private int day_of_week;

    static final int DATE_DIALOG_ID = 999;

    private String strDate;
    private String strDay;

    // Cost
    private EditText costEdit;
    private String strCost;

    // Remark
    private EditText remarkEdit;
    private String strRemark;

    // Add Expenses
    private Button addExpense;

    public final static String STR_DATE = "com.falcon.storm.expenditure.DATE";
    public final static String STR_DAY = "com.falcon.storm.expenditure.DAY";
    public final static String STR_COST = "com.falcon.storm.expenditure.COST";
    public final static String STR_REMARK = "com.falcon.storm.expenditure.REMARK";

    public void sendTest(View view)
    {
        strDate = dateDisplay.getText().toString();
        strDay = dayDisplay.getText().toString();
        strCost = costEdit.getText().toString();
        remarkEdit = (EditText) findViewById(R.id.remarkEdit);
        strRemark = remarkEdit.getText().toString();
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(STR_DATE, strDate);
        intent.putExtra(STR_DAY, strDay);
        intent.putExtra(STR_COST, strCost);
        intent.putExtra(STR_REMARK, strRemark);
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expenses);

        // Date
        setCurrentDateOnView();
        setListenerOnButton();


        // Cost
        costEdit = (EditText) findViewById(R.id.costEdit);
        costEdit.setRawInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        costEdit.addTextChangedListener(new CustomTextWatcher(costEdit));


        // Remark


    }

    private void setCurrentDateOnView()
    {
        dateDisplay = (TextView) findViewById(R.id.dateDisplay);
        dayDisplay = (TextView) findViewById(R.id.dayDisplay);

        final Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        day_of_week = calendar.get(Calendar.DAY_OF_WEEK);

        String strMonth = getMonth(month);
        String strDay = getDay(day_of_week);

        dateDisplay.setText(new StringBuilder().append(day).append(" ").append(strMonth).append(" ").append(year).append(" "));
        dayDisplay.setText(new StringBuilder().append(strDay).append(" "));
    }

    private String getDay(int day_of_week) {
        String strDay = null;
        switch (day_of_week)
        {
            case 1:
                strDay = "Sunday";
                break;

            case 2:
                strDay = "Monday";
                break;

            case 3:
                strDay = "Tuesday";
                break;

            case 4:
                strDay = "Wednesday";
                break;

            case 5:
                strDay = "Thursday";
                break;

            case 6:
                strDay = "Friday";
                break;

            case 7:
                strDay = "Saturday";
                break;
        }
        return strDay;
    }

    private String getMonth(int month) {
        String strMonth = null;
        switch(month)
        {
            case 0:
                strMonth = "Jan";
                break;

            case 1:
                strMonth = "Feb";
                break;

            case 2:
                strMonth = "Mar";
                break;

            case 3:
                strMonth = "Apr";
                break;

            case 4:
                strMonth = "May";
                break;

            case 5:
                strMonth = "June";
                break;

            case 6:
                strMonth = "Jul";
                break;

            case 7:
                strMonth = "Aug";
                break;

            case 8:
                strMonth = "Sept";
                break;

            case 9:
                strMonth = "Oct";
                break;

            case 10:
                strMonth = "Nov";
                break;

            case 11:
                strMonth = "Dec";
                break;
        }
        return strMonth;
    }

    private void setListenerOnButton()
    {
        editDate = (Button) findViewById(R.id.editDate);
        editDate.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                showDialog(DATE_DIALOG_ID);
            }
        });
    }

    @Override
    protected Dialog onCreateDialog(int id)
    {
        switch(id)
        {
            case DATE_DIALOG_ID:
                return new DatePickerDialog(this, datePickerListener, year, month, day);
        }

        return null;
    }

    private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener()
    {
        public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay)
        {
            year = selectedYear;
            month = selectedMonth;
            day = selectedDay;

            Calendar calendar = Calendar.getInstance();
            calendar.set(year, month, day);
            int day_of_week = calendar.get(Calendar.DAY_OF_WEEK);

            String strMonth = getMonth(month);
            String strDay = getDay(day_of_week);

            dateDisplay.setText(new StringBuilder().append(day).append(" ").append(strMonth).append(" ").append(year).append(" "));
            dayDisplay.setText(new StringBuilder().append(strDay).append(" "));
        }
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_expenses, menu);
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

        return super.onOptionsItemSelected(item);
    }
}
