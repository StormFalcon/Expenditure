package com.falcon.storm.expenditure;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.text.NumberFormat;

/**
 * Created by Flyer on 17/12/14.
 */
public class CustomTextWatcher implements TextWatcher {

    private NumberFormat numberFormat = NumberFormat.getNumberInstance();
    private EditText editText;
    private String temp = "";
    private int moveCaretTo;
    private static final int INTEGER_CONSTRAINT = 6;
    private static final int FRACTION_CONSTRAINT = 2;
    private static final int MAX_LENGTH = INTEGER_CONSTRAINT + FRACTION_CONSTRAINT;

    public CustomTextWatcher(EditText editText)
    {
        this.editText = editText;
        numberFormat.setMaximumIntegerDigits(INTEGER_CONSTRAINT);
        numberFormat.setMaximumFractionDigits(FRACTION_CONSTRAINT);
        numberFormat.setGroupingUsed(false);
    }

    public int countOccurrences (String str, char c)
    {
        int count = 0;
        for(int i=0; i<str.length(); i++)
        {
            if(str.charAt(i) == c)
            {
                count++;
            }
        }

        return count;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        moveCaretTo = editText.getSelectionEnd();
        temp = s.toString();
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        int length = editText.getText().toString().length();
        if(length > 0)
        {
            moveCaretTo = start + count - before;
        }
    }

    @Override
    public void afterTextChanged(Editable s) {

        ////////////////////////////////////////////////////////////////////
        // NOTE NOTE NOTE NOTE NOTE NOTE NOTE NOTE NOTE NOTE NOTE NOTE
        // NOTE: This works, but will have error with large number
        ////////////////////////////////////////////////////////////////////
        if(!s.toString().equals(temp))
        {
            editText.removeTextChangedListener(this);
        }

        String cleanString = s.toString().replaceAll("[$,.]","");

        double parsed = Double.parseDouble(cleanString);
        String formatted = NumberFormat.getCurrencyInstance().format((parsed/100));

        temp = formatted;
        editText.setText(formatted);
        editText.setSelection(formatted.length());

        editText.addTextChangedListener(this);


        /**
        editText.removeTextChangedListener(this);   // remove to prevent stackoverflow
        String ss = s.toString();
        int len = ss.length();
        int dots = countOccurrences(ss, '.');
        boolean shouldParse = dots <= 1 && (dots == 0 ? len != (INTEGER_CONSTRAINT + 1) : len < (MAX_LENGTH + 1));

        if(shouldParse)
        {
            if(len > 1 && ss.lastIndexOf(".") != len - 1)
            {
                try
                {
                    Double d = Double.parseDouble(ss);
                    if(d != null)
                    {
                        editText.setText(numberFormat.format(d));
                    }
                }
                catch (NumberFormatException e)
                {

                }
            }
        }
        else
        {
            editText.setText(temp);
        }

        editText.addTextChangedListener(this); // reset listener

        if(editText.getText().toString().length() > 0)
        {
            if(dots == 0 && len >= INTEGER_CONSTRAINT && moveCaretTo > INTEGER_CONSTRAINT)
            {
                moveCaretTo = INTEGER_CONSTRAINT;
            }
            else
            {
                if(dots > 0 && len >= (MAX_LENGTH) && moveCaretTo > (MAX_LENGTH))
                {
                    moveCaretTo = MAX_LENGTH;
                }
            }

            try
            {
                editText.setSelection(editText.getText().toString().length());
            }
            catch (Exception e)
            {

            }
        }
         **/
    }
}
