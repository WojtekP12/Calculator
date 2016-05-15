package com.example.wojtek_2.calculator;

/**
 * Created by Wojtek_2 on 2016-04-02.
 */

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by wojciech.pelka on 2016-04-01.
 */
public class OperationButtonClick implements View.OnClickListener
{
    TextView expression;
    String buttonContent;

    public OperationButtonClick(TextView expression)
    {
        this.expression = expression;
    }

    @Override
    public void onClick(View v)
    {
        Button button = (Button)v;
        buttonContent = button.getText().toString();

        if(expression.getText().toString()=="0")
        {
            expression.setText("");
        }

        switch(buttonContent)
        {
            case "C":
            {
                expression.setText("");
                NumericExpression.NumericExpression = expression.getText().toString();
                break;
            }
            case "<--":
            {
                if(expression.getText().length()!=0)
                {
                    String temp = expression.getText().toString();
                    temp = temp.substring(0,temp.length()-1);
                    expression.setText(temp);
                    NumericExpression.NumericExpression = expression.getText().toString();

                }
                break;
            }
            case "-":
            {

                if(expression.getText().length()>2)
                {
                    char tempChar = expression.getText().charAt(expression.getText().length()-2);

                    if(tempChar=='+' || tempChar=='-' || tempChar=='*' || tempChar=='/')
                    {
                        return;
                    }
                }

                String temp = expression.getText().toString();
                temp += button.getText();
                expression.setText(temp);
                NumericExpression.NumericExpression = expression.getText().toString();
                break;
            }
            default:
            {
                if(expression.getText()!="" && (expression.getText().toString().charAt(expression.getText().toString().length()-1) != '+' &&
                        expression.getText().toString().charAt(expression.getText().toString().length()-1) != '-' &&
                        expression.getText().toString().charAt(expression.getText().toString().length()-1) != '*' &&
                        expression.getText().toString().charAt(expression.getText().toString().length()-1) != '/' &&
                        expression.getText().toString().charAt(expression.getText().toString().length()-1) != '.'))
                {
                    String temp = expression.getText().toString();
                    temp += button.getText();
                    expression.setText(temp);
                    NumericExpression.NumericExpression = expression.getText().toString();
                }

                break;
            }

        }
    }
}

