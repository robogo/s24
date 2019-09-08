package com.robogo.s24;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button btnNew;
    private EditText txtNum1;
    private EditText txtNum2;
    private EditText txtNum3;
    private EditText txtNum4;
    private Button btnShow;
    private EditText txtResult;
    private Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNew = (Button) findViewById(R.id.btnNew);
        txtNum1 = (EditText) findViewById(R.id.txtNum1);
        txtNum2 = (EditText) findViewById(R.id.txtNum2);
        txtNum3 = (EditText) findViewById(R.id.txtNum3);
        txtNum4 = (EditText) findViewById(R.id.txtNum4);
        btnShow = (Button) findViewById(R.id.btnShow);
        txtResult = (EditText) findViewById(R.id.txtResult);
        random = new Random();
    }

    public void onNew(View view) {
        do {
            int a = random.nextInt(9) + 1;
            int b = random.nextInt(9) + 1;
            int c = random.nextInt(9) + 1;
            int d = random.nextInt(9) + 1;
            if (S24.calc(a, b, c, d) != null) {
                txtNum1.setText(String.valueOf(a));
                txtNum2.setText(String.valueOf(b));
                txtNum3.setText(String.valueOf(c));
                txtNum4.setText(String.valueOf(d));
                break;
            }
        } while (true);

        txtResult.setText("");
    }

    public void onShow(View view) {
        try {
            int a = Integer.parseInt(txtNum1.getText().toString());
            int b = Integer.parseInt(txtNum2.getText().toString());
            int c = Integer.parseInt(txtNum3.getText().toString());
            int d = Integer.parseInt(txtNum4.getText().toString());
            String s = S24.calc(a, b, c, d);
            if (s != null) {
                txtResult.setText(s);
                return;
            }
        } catch (Exception e) {
        }

        txtResult.setText("X");
    }
}
