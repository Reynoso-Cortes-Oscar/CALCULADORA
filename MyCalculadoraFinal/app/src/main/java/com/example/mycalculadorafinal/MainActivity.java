package com.example.mycalculadorafinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView screen;
    double AC, Power, Back, Div, btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, Mul, Suma, Resta, Igual, Ans, Dot;
    String input, answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        screen = findViewById(R.id.screen);
        AC = findViewById(R.id.ac);
        Power = findViewById(R.id.power);
        Back = findViewById(R.id.back);
        Div = findViewById(R.id.div);
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        Mul = findViewById(R.id.mul);
        Suma = findViewById(R.id.suma);
        Resta = findViewById(R.id.res);
        Igual = findViewById(R.id.igual);
        Ans = findViewById(R.id.ans);
        Dot = findViewById(R.id.dot);
    }

    public void cientifica(View view) {
        Intent cientific = new Intent(this, calculadoracientifica.class);
        startActivity(cientific);
    }
    public void btn0(View view){
        tvdisplay=(TextView)findViewById(R.id.tv_dis);
        tvdisplay.setText(tvdisplay.getText()+"0");
    }
    public void btn1(View view){
        tvdisplay=(TextView)findViewById(R.id.tv_dis);
        tvdisplay.setText(tvdisplay.getText()+"1");
    }
    public void btn2(View view){
        tvdisplay=(TextView)findViewById(R.id.tv_dis);
        tvdisplay.setText(tvdisplay.getText()+"2");
    }
    public void btn3(View view){
        tvdisplay=(TextView)findViewById(R.id.tv_dis);
        tvdisplay.setText(tvdisplay.getText()+"3");
    }
    public void btn4(View view){
        tvdisplay=(TextView)findViewById(R.id.tv_dis);
        tvdisplay.setText(tvdisplay.getText()+"4");
    }
    public void btn5(View view){
        tvdisplay=(TextView)findViewById(R.id.tv_dis);
        tvdisplay.setText(tvdisplay.getText()+"5");
    }
    public void btn6(View view){
        tvdisplay=(TextView)findViewById(R.id.tv_dis);
        tvdisplay.setText(tvdisplay.getText()+"6");
    }
    public void btn7(View view){
        tvdisplay=(TextView)findViewById(R.id.tv_dis);
        tvdisplay.setText(tvdisplay.getText()+"7");
    }
    public void btn8(View view){
        tvdisplay=(TextView)findViewById(R.id.tv_dis);
        tvdisplay.setText(tvdisplay.getText()+"8");
    }
    public void btn9(View view){
        tvdisplay=(TextView)findViewById(R.id.tv_dis);
        tvdisplay.setText(tvdisplay.getText()+"9");
    }
    public void bDot(View view){
        tvdisplay=(TextView)findViewById(R.id.tv_dis);
        tvdisplay.setText(tvdisplay.getText()+".");
    }
    public void OnClickOperacionCapturaNumero1 (View view){
        tvdisplay=(TextView)findViewById(R.id.tv_dis);
        n1=Double.parseDouble(tvdisplay.getText().toString());
        tvdisplay.setText(" ");
    }

    public void ButtonClick(View view) {
        Button button = (Button) view;
        String data = button.getText().toString();
        switch (data) {
            case "AC":
                input = "";
                break;
            case "Ans":
                input += answer;
                break;
            case "×":
                input += "*";
                break;
            case "^":
                input += "^";
                break;
            case "=":
                resolver();
                answer = input;
                break;
            case "←":
                String newText = input.substring(0, input.length() - 1);
                input = newText;
                break;
            default:
                if (input == null) {
                    input = "";
                }
                if (data.equals("+") || data.equals("-") || data.equals("÷")) {
                    resolver();
                }
                input += data;
        }
        screen.setText(input);
    }

    private void resolver() {
        if (input.split("\\*").length == 2) {
            String number[] = input.split("\\*");
            try {
                double multiplicacion = Double.parseDouble(number[0]) * Double.parseDouble(number[1]);
                input = multiplicacion + "";
            } catch (Exception e) {

            }
        } else if (input.split("\\÷").length == 2) {
            String number[] = input.split("\\÷");
            try {
                double div = Double.parseDouble(number[0]) / Double.parseDouble(number[1]);
                input = div + "";
            } catch (Exception e) {

            }
        } else if (input.split("\\^").length == 2) {
            String number[] = input.split("\\^");
            try {
                if (Double.parseDouble(number[1]) != 0 && Double.parseDouble(number[0]) != 0) {
                    double pow = Math.pow(Double.parseDouble(number[0]), Double.parseDouble(number[1]));
                    input = pow + "";
                } else {
                    input = "Math Error";
                }
            } catch (Exception e) {

            }
        } else if (input.split("\\+").length == 2) {
            String number[] = input.split("\\+");
            try {
                double sum = Double.parseDouble(number[0]) + Double.parseDouble(number[1]);
                input = sum + "";
            } catch (Exception e) {

            }
        } else if (input.split("\\-").length > 1) {
            String number[] = input.split("\\-");
            if (number[0] == "" && number.length == 2) {
                number[0] = 0 + "";
            }
            try {
                double res = 0;
                if (number.length == 2) {
                    res = Double.parseDouble(number[0]) - Double.parseDouble(number[1]);
                } else if (number.length == 3) {
                    res = -Double.parseDouble(number[1]) - Double.parseDouble(number[2]);
                }
                input = res + "";
            } catch (Exception e) {

            }
        }
        String n[] = input.split("\\.");
        if (n.length > 1) {
            if (n[1].equals("0")) {
                input = n[0];
            }
        }
        screen.setText(input);
    }
}