package com.falcon.storm.expenditure;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Flyer on 16/12/14.
 */
public class ExpensesViewHolder extends RecyclerView.ViewHolder {
    protected TextView vDate;
    protected TextView vDay;
    protected TextView vCost;
    protected TextView vRemark;

    public ExpensesViewHolder(View view)
    {
        super(view);
        vDate = (TextView) view.findViewById(R.id.date);
        vDay = (TextView) view.findViewById(R.id.day);
        vCost = (TextView) view.findViewById(R.id.cost);
        vRemark = (TextView) view.findViewById(R.id.remark);

    }

}
