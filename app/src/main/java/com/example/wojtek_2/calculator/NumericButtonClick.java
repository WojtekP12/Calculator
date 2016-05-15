package com.example.wojtek_2.calculator;

/**
 * Created by Wojtek_2 on 2016-04-02.
 */
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by wojciech.pelka on 2016-03-30.
 */
public class NumericButtonClick implements View.OnClickListener
{

    Button button;
    TextView expression;

    public NumericButtonClick(TextView expression)
    {
        this.expression = expression;
    }

    @Override
    public void onClick(View v)
    {
        if(expression.getText().length()>0 && expression.getText().charAt(expression.getText().length()-1)==')')
        {
            return;
        }

        if(expression.getText().toString()=="0")
        {
            expression.setText("");
        }
        button = (Button)v;

        String buttonContent = button.getText().toString();
        String ExpressionContent = expression.getText().toString();

        ExpressionContent+=buttonContent;

        expression.setText(ExpressionContent);
        NumericExpression.NumericExpression = expression.getText().toString();



    }
}

