package com.falcon.storm.expenditure;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class test extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        String strDate = intent.getStringExtra(addExpenses.STR_DATE);
        String strDay = intent.getStringExtra(addExpenses.STR_DAY);
        String strCost = intent.getStringExtra(addExpenses.STR_COST);
        String strRemark = intent.getStringExtra(addExpenses.STR_REMARK);

        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText("Date:_" + strDate + "_Day:_" + strDay + "_Cost:_" + strCost + "_Re:_" + strRemark);

        setContentView(textView);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_test, menu);
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
