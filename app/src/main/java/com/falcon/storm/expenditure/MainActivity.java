package com.falcon.storm.expenditure;

import android.content.Intent;
import android.graphics.Outline;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class MainActivity extends ActionBarActivity{

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private LinearLayoutManager mLayoutManager;
    private ArrayList<Expenses> expensesList;

    private static final String TAG = "MainActivity";
    static final String EXPENSES_LIST = "expensesList";

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putParcelableArrayList(EXPENSES_LIST, expensesList);
    }

    public void addExpenses(View view)
    {
        Intent intent = new Intent(this, addExpenses.class);
        startActivity(intent);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(savedInstanceState != null)
        {
            expensesList = savedInstanceState.getParcelableArrayList(EXPENSES_LIST);
            Intent intent = getIntent();

            String sDate = intent.getStringExtra(addExpenses.STR_DATE);
            String sDay = intent.getStringExtra(addExpenses.STR_DAY);
            Double sCost = Double.parseDouble(intent.getStringExtra(addExpenses.STR_COST));
            String sRemark = intent.getStringExtra(addExpenses.STR_REMARK);

            Log.d(TAG, sRemark);

            //Expenses newExpenses = new Expenses(sDate, sDay, sCost, sRemark);
            Expenses newExpenses = new Expenses("DATe", "Monday", 11.11, "TestRemark");

            expensesList.add(newExpenses);
            Log.d(TAG, "IF Size: " + expensesList.size());

        }
        else {
            ///////////////////////////////////////////////////////////////////////////////
            // Tester Code
            ///////////////////////////////////////////////////////////////////////////////
            expensesList = new ArrayList<Expenses>();

            for (int i = 0; i < 5; i++) {
                Expenses temp = new Expenses("15 Dec 2014", "Monday", 12.34, "Dummy Data");
                //Expenses temp = new Expenses();
                expensesList.add(temp);
            }
            Log.d(TAG, "Else Size: " + expensesList.size());
        }

        //System.out.println(expensesList.size());

        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        mRecyclerView.setLayoutManager(mLayoutManager);
        //newly added
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mAdapter = new ExpensesAdapter(expensesList);
        mRecyclerView.setAdapter(mAdapter);

        /**
        try {
            InputStream is = getResources().openRawResource(R.raw.test);
            InputStreamReader inputStreamReader = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(inputStreamReader);

            ArrayList<String> textHolder = new ArrayList<String>();
            String input = br.readLine();
            textHolder.add(input);
            while (input != null) {
                textHolder.add(input);
                input = br.readLine();
            }
        } catch (IOException e)
        {

        }
        **/

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch(item.getItemId())
        {
            case R.id.action_settings:
                //openSetting();
                return true;

            case R.id.about:
                openAbout();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void openAbout()
    {
        Intent intent = new Intent(this, About.class);
        startActivity(intent);
    }
}