package com.example.wojtek_2.calculator;

import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.sourceforge.jeval.function.math.Sin;

/**
 * Created by wojciech.pelka on 2016-04-01.
 */
public class AdvanceOperationButtonClick implements View.OnClickListener {
    TextView expression;
    String buttonContent;

    public AdvanceOperationButtonClick(TextView expression) {
        this.expression = expression;
    }

    private void AdvanceOperationStringCreator(String operation)
    {

        String temp = expression.getText().toString();
        String temp2 = "";

        int i = temp.length() - 1;

        if ((temp.contains("+") || temp.contains("-") || temp.contains("*") || temp.contains("/")))
        {
            while ((temp.charAt(i) >= 48 && temp.charAt(i) <= 57) || temp.charAt(i) == '.')
            {
                i--;
            }

            for (int j = i + 1; j <= temp.length() - 1; j++)
            {
                temp2 += temp.charAt(j);
            }

            if (operation == "x^2")
            {
                temp = temp.substring(0, i + 1) + temp2 + "^2";
            }
            else
            {
                temp = temp.substring(0, i + 1) + operation + "(" + temp2 + ")";
            }

        }
        else
        {
            temp2 = expression.getText().toString();

            if (operation == "x^2")
            {
                temp = temp2 + "^2";
            } else {
                temp = operation + "(" + temp2 + ")";
            }

        }

        if(temp2.contains("^"))
        {
            return;
        }

        double a = AdvacedOperationEval(operation, temp2);
        String temp3 = String.valueOf(a);

        if (NumericExpression.NumericExpression.length() == temp2.length())
        {
            NumericExpression.NumericExpression = "0";
        }
        else
        {
            NumericExpression.NumericExpression = NumericExpression.NumericExpression.substring(0, NumericExpression.NumericExpression.length() - temp2.length());
        }

        if (NumericExpression.NumericExpression.charAt(NumericExpression.NumericExpression.length() - 1) == '+' && temp3.charAt(0) == '-')
        {
            NumericExpression.NumericExpression = NumericExpression.NumericExpression.substring(0, NumericExpression.NumericExpression.length() - 1);
        }
        if (NumericExpression.NumericExpression.charAt(NumericExpression.NumericExpression.length() - 1) == '-' && temp3.charAt(0) == '-')
        {
            NumericExpression.NumericExpression = NumericExpression.NumericExpression.substring(0, NumericExpression.NumericExpression.length() - 1);
            NumericExpression.NumericExpression += "+";
            temp3 = temp3.substring(1, temp3.length());
        }

        NumericExpression.NumericExpression += temp3;
        expression.setText(temp);

    }

    private double AdvacedOperationEval(String operation, String d)
    {
        double res=0.0 ;
        if (expression.getText().length() > 0)
        {
            switch(operation)
            {
                case "sin":
                {
                    res = Math.sin(Double.parseDouble(d));
                    break;
                }
                case "cos":
                {
                    res = Math.cos(Double.parseDouble(d));
                    break;
                }
                case "ln":
                {
                    res = Math.log(Double.parseDouble(d));
                    break;
                }
                case "log":
                {
                    res = Math.log10(Double.parseDouble(d));
                    break;
                }
                case "sqrt":
                {
                    res = Math.sqrt(Double.parseDouble(d));
                    break;
                }
                case "x^2":
                {
                    res = Math.pow(Double.parseDouble(d),2);
                    break;
                }

            }
        }


        return res;
    }

    @Override
    public void onClick(View v)
    {
        Button button = (Button) v;
        buttonContent = button.getText().toString();

        if (expression.getText() == "0")
        {
            expression.setText("");
        }

            char lastChar = ' ';
            if(expression.getText().length()>0)
            {
                 lastChar = expression.getText().charAt(expression.getText().length() - 1);
            }

            if (lastChar != ')' && lastChar != '^' && lastChar!='.' && expression.getText()!="ERROR") {

                    switch (buttonContent) {
                        case "e":
                        {
                            if (lastChar < 48 || lastChar > 57)
                            {
                                String e = "2.71828183";
                                String temp = expression.getText().toString();
                                NumericExpression.NumericExpression = temp + e;
                                temp += e;
                                expression.setText(temp);
                            }

                            break;
                        }
                        case "sin":
                        {
                            if(expression.getText().length()!=0 && lastChar!='*' && lastChar!='/' && lastChar!='+' && lastChar!='-')
                            AdvanceOperationStringCreator("sin");
                            break;
                        }

                        case "cos":
                        {
                            if(expression.getText().length()!=0 && lastChar!='*' && lastChar!='/' && lastChar!='+' && lastChar!='-')
                            AdvanceOperationStringCreator("cos");
                            break;
                        }

                        case "log":
                        {
                            if(expression.getText().length()!=0 && lastChar!='*' && lastChar!='/' && lastChar!='+' && lastChar!='-')
                            AdvanceOperationStringCreator("log");
                            break;
                        }

                        case "ln":
                        {
                            if(expression.getText().length()!=0 && lastChar!='*' && lastChar!='/' && lastChar!='+' && lastChar!='-')
                            AdvanceOperationStringCreator("ln");
                            break;
                        }

                        case "sqrt":
                        {
                            if(expression.getText().length()!=0 && lastChar!='*' && lastChar!='/' && lastChar!='+' && lastChar!='-')
                            AdvanceOperationStringCreator("sqrt");
                            break;
                        }
                        case "x^2":
                        {
                            if(expression.getText().length()!=0 && lastChar!='*' && lastChar!='/' && lastChar!='+' && lastChar!='-')
                            AdvanceOperationStringCreator("x^2");
                            break;
                        }
                        case "x^y":
                        {
                            if(expression.getText().length()!=0 && lastChar!='*' && lastChar!='/' && lastChar!='+' && lastChar!='-')
                            {
                                String temp = expression.getText().toString();
                                NumericExpression.NumericExpression = temp + "^";
                                temp += "^";
                                expression.setText(temp);
                            }

                            break;
                        }
                    }

            }
        }

    }