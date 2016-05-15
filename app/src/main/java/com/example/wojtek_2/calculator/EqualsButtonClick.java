package com.example.wojtek_2.calculator;

/**
 * Created by Wojtek_2 on 2016-04-02.
 */
import android.view.View;
import android.widget.TextView;

import net.sourceforge.jeval.EvaluationException;
import net.sourceforge.jeval.Evaluator;

public class EqualsButtonClick implements View.OnClickListener
{
    TextView expression;

    public EqualsButtonClick(TextView expression)
    {
        this.expression = expression;
    }

    @Override
    public void onClick(View v) {
        char lastChar = expression.getText().charAt(expression.getText().length() - 1);

        try{
            if (lastChar != '-' && lastChar != '.' && lastChar!='^' && lastChar!='+' && lastChar!='*' && lastChar!='/' && expression.getText().length()!=0)
            {
                String expr = NumericExpression.NumericExpression;
                String result = "";
                Evaluator ev = new Evaluator();

                if(expr.contains("^"))
                {
                    expr = PowerEvaluator.EvaluateAllPowers(expr);
                }


                try
                {
                    result = ev.evaluate(expr);
                }
                catch(EvaluationException ex)
                {
                   expression.setText("ERROR");
                }

                if(result.charAt(result.length()-1)=='0')
                {
                    result = result.substring(0,result.length()-1);
                }

                if(result.charAt(result.length()-1)=='.')
                {
                    result = result.substring(0,result.length()-1);
                }
                NumericExpression.NumericExpression = result;
                expression.setText(result);
            }
        }
        catch (Exception e)
        {
            expression.setText("ERROR");
        }


    }}

