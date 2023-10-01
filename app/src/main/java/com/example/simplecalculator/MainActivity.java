package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn01, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0;
    Button btnadd, btnsub, btndiv, btnmul, btnclr, btndot, btneql;
    EditText result1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn01 = (Button) findViewById(R.id.btn1);
        btn01.setOnClickListener(this);
        btn2 = (Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(this);
        btn3 = (Button) findViewById(R.id.btn3);
        btn3.setOnClickListener(this);
        btn4 = (Button) findViewById(R.id.btn4);
        btn4.setOnClickListener(this);
        btn5 = (Button) findViewById(R.id.btn5);
        btn5.setOnClickListener(this);
        btn6 = (Button) findViewById(R.id.btn6);
        btn6.setOnClickListener(this);
        btn7 = (Button) findViewById(R.id.btn7);
        btn7.setOnClickListener(this);
        btn8 = (Button) findViewById(R.id.btn8);
        btn8.setOnClickListener(this);
        btn9 = (Button) findViewById(R.id.btn9);
        btn9.setOnClickListener(this);
        btn0 = (Button) findViewById(R.id.btn0);
        btn0.setOnClickListener(this);
        btnadd = (Button) findViewById(R.id.btnadd);
        btnadd.setOnClickListener(this);
        btnsub = (Button) findViewById(R.id.btnsub);
        btnsub.setOnClickListener(this);
        btnmul = (Button) findViewById(R.id.btnmul);
        btnmul.setOnClickListener(this);
        btndiv = (Button) findViewById(R.id.btndiv);
        btndiv.setOnClickListener(this);
        btndot = (Button) findViewById(R.id.btndot);
        btndot.setOnClickListener(this);
        btnclr = (Button) findViewById(R.id.btnclr);
        btnclr.setOnClickListener(this);
        btneql = (Button) findViewById(R.id.btneql);
        btneql.setOnClickListener(this);
        result1 = (EditText) findViewById(R.id.rsult);
        result1.setText("");


    }

    private void displayErrorMsg(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        if (v.equals(btn01))
            result1.append("1");
        if (v.equals(btn2))
            result1.append("2");
        if (v.equals(btn3))
            result1.append("3");
        if (v.equals(btn4))
            result1.append("4");
        if (v.equals(btn5))
            result1.append("5");
        if (v.equals(btn6))
            result1.append("6");
        if (v.equals(btn7))
            result1.append("7");
        if (v.equals(btn8))
            result1.append("8");
        if (v.equals(btn9))
            result1.append("9");
        if (v.equals(btn0))
            result1.append("0");
        if (v.equals(btnadd))
            result1.append("+");
        if (v.equals(btnsub))
            result1.append("-");
        if (v.equals(btnmul))
            result1.append("*");
        if (v.equals(btndiv))
            result1.append("/");
        if (v.equals(btnclr))
            result1.append("C");
        if (v.equals(btndot))
            result1.append(".");
        if (v.equals(btneql)) {
            try {
                String data = result1.getText().toString();
                if (data.contains("+")) {
                    add(data);
                } else if (data.contains("-")) {
                    sub(data);

                } else if (data.contains("*")) {
                    mul(data);

                } else if (data.contains("/")) {
                    div(data);
                }
            } catch (Exception e) {
                result1.setText(result1.toString());
            }

        }
    }
    public void clearText(View view){
        Button btn=(Button) view;
        String btnclr=btn.getText().toString();
        if(btnclr.equals("c")){
            result1.setText("");
        }else {
            String alreadyNum=result1.getText().toString();
            String updatedNum=alreadyNum.substring(0,alreadyNum.length());
            result1.setText(updatedNum);
        }
    }

    private void add(String data) {
        String[] operands = data.split(Pattern.quote("+"));
        if (operands.length == 2) {
            Double op1 = Double.parseDouble(operands[0]);
            Double op2 = Double.parseDouble(operands[1]);
            double result = op1 + op2;
            result1.setText(String.valueOf(result));
        } else {
            result1.setText(result1.toString());
        }


    }

    private void sub(String data) {
        String[] operands = data.split(Pattern.quote("-"));
        if (operands.length == 2) {
            Double op1 = Double.parseDouble(operands[0]);
            Double op2 = Double.parseDouble(operands[1]);
            double result = op1 - op2;
            result1.setText(String.valueOf(result));
            result1.setText(result1.toString());
        }
    }


    private void mul(String data) {
        String[] operands = data.split(Pattern.quote("*"));
        if (operands.length == 2) {
            Double op1 = Double.parseDouble(operands[0]);
            Double op2 = Double.parseDouble(operands[1]);
            double result = op1 * op2;
            result1.setText(String.valueOf(result));

            result1.setText(result1.toString());
        }

    }


    private void div(String data) {
        String[] operands = data.split(Pattern.quote("/"));
        if (operands.length == 2) {
            Double op1 = Double.parseDouble(operands[0]);
            Double op2 = Double.parseDouble(operands[1]);
            if (op2 == 0) {
                displayErrorMsg("Divide by Zero Error msg");
            } else {
                Double res = op1 / op2;
                result1.setText(result1.toString());
            }
        }
    }
}




