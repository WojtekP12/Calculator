package com.example.wojtek_2.calculator;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView equation = (TextView)findViewById(R.id.Equation);
        equation.setText("");

        MenuItem exit = (MenuItem)findViewById(R.id.action_exit);

        Button one = (Button)findViewById(R.id.OneButton);
        Button two = (Button)findViewById(R.id.TwoButton);
        Button three = (Button)findViewById(R.id.ThreeButton);
        Button four = (Button)findViewById(R.id.FourButton);
        Button five = (Button)findViewById(R.id.FiveButton);
        Button six = (Button)findViewById(R.id.SixButton);
        Button seven = (Button)findViewById(R.id.SevenButton);
        Button eight = (Button)findViewById(R.id.EightButton);
        Button nine = (Button)findViewById(R.id.NineButton);
        Button zero = (Button)findViewById(R.id.ZeroButton);

        Button clear = (Button)findViewById(R.id.ClearButton);
        Button backSpace = (Button)findViewById(R.id.BackSpaceButton);
        Button coma = (Button)findViewById(R.id.ComaButton);

        Button equals = (Button)findViewById(R.id.EqualsButton);

        Button plus = (Button)findViewById(R.id.PlusButton);
        Button minus = (Button)findViewById(R.id.MinusButton);
        Button multi = (Button)findViewById(R.id.MultiButton);
        Button division = (Button)findViewById(R.id.DivistionButton);

        Button euler = (Button)findViewById(R.id.EulerButton);
        Button sinus = (Button)findViewById(R.id.SinButton);
        Button cos = (Button)findViewById(R.id.CosButton);
        Button ln = (Button)findViewById(R.id.LnButton);
        Button log = (Button)findViewById(R.id.LogButton);
        Button sqrt = (Button)findViewById(R.id.SqrtButton);
        Button square = (Button)findViewById(R.id.Square);
        Button power = (Button)findViewById(R.id.PowerButton);

        one.setOnClickListener(new NumericButtonClick(equation));
        two.setOnClickListener(new NumericButtonClick(equation));
        three.setOnClickListener(new NumericButtonClick(equation));
        four.setOnClickListener(new NumericButtonClick(equation));
        five.setOnClickListener(new NumericButtonClick(equation));
        six.setOnClickListener(new NumericButtonClick(equation));
        seven.setOnClickListener(new NumericButtonClick(equation));
        eight.setOnClickListener(new NumericButtonClick(equation));
        nine.setOnClickListener(new NumericButtonClick(equation));
        zero.setOnClickListener(new NumericButtonClick(equation));

        clear.setOnClickListener(new OperationButtonClick(equation));
        backSpace.setOnClickListener(new OperationButtonClick(equation));
        coma.setOnClickListener(new OperationButtonClick(equation));


        equals.setOnClickListener(new EqualsButtonClick(equation));


        plus.setOnClickListener(new OperationButtonClick(equation));
        minus.setOnClickListener(new OperationButtonClick(equation));
        multi.setOnClickListener(new OperationButtonClick(equation));
        division.setOnClickListener(new OperationButtonClick(equation));

        if(sinus!=null && cos!=null && ln!=null && log!=null && sqrt!=null && euler!=null)
        {
            try
            {
                euler.setOnClickListener(new AdvanceOperationButtonClick(equation));
                sinus.setOnClickListener(new AdvanceOperationButtonClick(equation));
                cos.setOnClickListener(new AdvanceOperationButtonClick(equation));
                ln.setOnClickListener(new AdvanceOperationButtonClick(equation));
                log.setOnClickListener(new AdvanceOperationButtonClick(equation));
                sqrt.setOnClickListener(new AdvanceOperationButtonClick(equation));
                square.setOnClickListener(new AdvanceOperationButtonClick(equation));
                power.setOnClickListener(new AdvanceOperationButtonClick(equation));
            }
            catch(NumberFormatException exc)
            {
                ShowDialog("ERROR","Za duża liczba!",android.R.drawable.ic_dialog_alert);
            }

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_exit:
            {
                System.exit(0);
                return true;
            }
            case R.id.action_about:
            {
                ShowDialog("Calculator","Wojciech Pełka 187783 6I-IO2"+"\n"+"Prosty kalkulator do liczenia",android.R.drawable.ic_dialog_info);
            }
            default:
            {
                return super.onOptionsItemSelected(item);
            }
        }
    }

    private void ShowDialog(String title, String message, int icon)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title).setMessage(message).setIcon(icon);

        AlertDialog alert = builder.create();
        alert.show();
    }
}
