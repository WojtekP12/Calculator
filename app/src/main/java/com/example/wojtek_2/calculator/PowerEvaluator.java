package com.example.wojtek_2.calculator;

/**
 * Created by Wojtek_2 on 2016-04-10.
 */
public class PowerEvaluator
{
    public static String EvaluateAllPowers(String expression)
    {
        String number = "";
        String power = "";
        int n,p;
        expression = " "+expression+" ";

        for(int i=0;i<expression.length()-1;i++)
        {
            if(expression.charAt(i)=='^')
            {
                number = "";
                power = "";
                n = i-1;
                p = i+1;
                while(expression.charAt(n)>=48 && expression.charAt(n)<=57 && n>0 || expression.charAt(n)=='.' )
                {
                    n--;
                }
                for(int j=n+1;j<i;j++)
                {
                    number+=expression.charAt(j);
                }

                while(expression.charAt(p)!='+' && p<expression.length()-1)
                {
                    power+=expression.charAt(p);
                    p++;
                }

                double res = Math.pow(Double.parseDouble(number), Double.parseDouble(power));

                String r = String.valueOf(res);
                expression = expression.replace(number+"^"+power, r);
            }
        }
        expression = expression.substring(1,expression.length()-1);

        return expression;
    }
}
