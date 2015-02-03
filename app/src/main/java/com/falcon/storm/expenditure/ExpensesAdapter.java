package com.falcon.storm.expenditure;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Flyer on 16/12/14.
 */
public class ExpensesAdapter extends RecyclerView.Adapter<ExpensesViewHolder> {

    private ArrayList<Expenses> expensesList;

    public ExpensesAdapter(ArrayList<Expenses> expensesList)
    {
        this.expensesList = expensesList;
    }


    @Override
    public ExpensesViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list, viewGroup, false);

        return new ExpensesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ExpensesViewHolder expensesViewHolder, int i) {
        Expenses expenses = expensesList.get(i);
        expensesViewHolder.vDate.setText(expenses.date);
        expensesViewHolder.vDay.setText(expenses.day);
        expensesViewHolder.vCost.setText(expenses.cost.toString());
        expensesViewHolder.vRemark.setText(expenses.remark);
    }

    @Override
    public int getItemCount() {
        return expensesList.size();
    }
}
