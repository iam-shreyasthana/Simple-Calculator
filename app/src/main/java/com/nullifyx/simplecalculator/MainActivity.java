package com.nullifyx.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {

    //.....Variable Declaration.......
    private View decorView;
    private Button onebtn,twobtn,threebtn,fourbtn,fivebtn,sixbtn,sevenbtn,eightbtn,ninebtn,clearbtn;
    private Button pmbtn,dividebtn,multiplybtn,plusbtn,subbtn,equalbtn,decimalbtn,zerobtn;
    private ImageButton delbtn;
    TextView text1,text2,operate;
    private Double op1 = null;
    private Double op2 = null;
    private String process = "=";
    Double dv;

    //....Decimal Format Function.........

    final DecimalFormat df = new DecimalFormat("0.00000");


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //........For hiding the Status Bar..........

        decorView = getWindow().getDecorView();
        View onSystemUiVisibilityChangeListener;
        //noinspection deprecation
        decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            @Override
            public void onSystemUiVisibilityChange(int visibility) {
                if(visibility==0)
                    //noinspection deprecation
                    decorView.setSystemUiVisibility(hideSystemBars());

            }
        });

        zerobtn = findViewById(R.id.zerobtnn);
        onebtn = findViewById(R.id.onebtnn);
        twobtn = findViewById(R.id.twobtnn);
        threebtn = findViewById(R.id.threebtnn);
        fourbtn = findViewById(R.id.fourbtnn);
        fivebtn = findViewById(R.id.fivebtnn);
        sixbtn = findViewById(R.id.sixbtnn);
        sevenbtn = findViewById(R.id.sevenbtnn);
        eightbtn = findViewById(R.id.eightbtnn);
        ninebtn = findViewById(R.id.ninebtnn);

        equalbtn = findViewById(R.id.equalbtnn);
        delbtn = findViewById(R.id.delbtnn);
        dividebtn = findViewById(R.id.dividebtnn);
        multiplybtn = findViewById(R.id.multiplybtnn);
        plusbtn = findViewById(R.id.plusbtnn);
        subbtn = findViewById(R.id.subbtnn);
        clearbtn = findViewById(R.id.clearbtnn);
        pmbtn = findViewById(R.id.pmbtnn);

        decimalbtn = findViewById(R.id.decimalbtnn);

        text1 = findViewById(R.id.smallres);
        text2 = findViewById(R.id.largeres);
        operate = findViewById(R.id.operator);




        zerobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text1.setText(text1.getText() + "0");
            }
        });
        onebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text1.setText(text1.getText() + "1");
            }
        });

        twobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text1.setText(text1.getText() + "2");
            }
        });

        threebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text1.setText(text1.getText() + "3");
            }
        });

        fourbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text1.setText(text1.getText() + "4");
            }
        });

        fivebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text1.setText(text1.getText() + "5");
            }
        });

        sixbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text1.setText(text1.getText() + "6");
            }
        });

        sevenbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text1.setText(text1.getText() + "7");
            }
        });

        eightbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text1.setText(text1.getText() + "8");
            }
        });

        ninebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text1.setText(text1.getText() + "9");
            }
        });

        decimalbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text1.setText(text1.getText() + ".");
            }
        });

        clearbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text1.setText(null);
                text2.setText(null);
                operate.setText(null);
                process="=";
                op1 = null;
                op2 = null;
            }
        });

        //........Negative Button Listener...........

        pmbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = text1.getText().toString();
                if(value.length() == 0){
                    text1.setText("-");
                }
                else{
                    try{
                        Double dv = Double.valueOf(value);
                        dv *= (-1);
                        text1.setText(dv.toString());
                    }catch(NumberFormatException e){
                        // Since the text was "-" so we will clear it from the screen......

                        text1.setText("");
                    }
                }
            }
        });


        View.OnClickListener opListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button b = (Button) view;
                String op = b.getText().toString();
                String value = text1.getText().toString();
                try{
                    dv = Double.valueOf(value);
                    performOperation(dv,op);
                }
                catch (NumberFormatException e){
                    text1.setText("");
                }
                    process = op;
                    operate.setText(op);
            }
        };

        plusbtn.setOnClickListener(opListener);
        subbtn.setOnClickListener(opListener);
        multiplybtn.setOnClickListener(opListener);
        dividebtn.setOnClickListener(opListener);
        equalbtn.setOnClickListener(opListener);

        //.......BackSpace Function.....

        delbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!text1.getText().toString().isEmpty()) {
                    String s = text1.getText().toString();
                    String s1 = "";
                    for (int i = 0; i < s.length() - 1; i++) {
                        s1 =s1 + s.charAt(i);
                    }
                    text1.setText(s1);
                }
            }
        });

    }

    private void performOperation(Double value, String operation){
        if(op1 == null){
            op1 = value;
        }
        else{
            op2 = value;

            if(process.equals("=")){
                process = operation;
            }
            switch (process){
                case "=" :
                    op1 = op2;
                    break;
                case "÷":
                    if(value==0){
                        text2.setText("INFINITE");
                    }
                    else{
                        op1/=op2;
                        int intPlaces = process.indexOf('.');
                        int decimalPlaces = process.length() - intPlaces - 1;
                        if(decimalPlaces<2)
                        {
                            String res = df.format(op1);
                            double result = Double.parseDouble(res);
                            op1 = result;
                        }
                    }
                    break;
                case "×":
                    op1*=op2;
                    break;
                case "+":
                    op1+=op2;
                    break;
                case "-":
                    op1-=op2;
                    break;
            }
        }
        if(process=="-"){
            op1*=(-1);
        }
        text2.setText(op1.toString());
        text1.setText("");
    }






    // Function for response to UI Change........Checking the in and out behaviour of thee user
    //from the main activity.....

    @SuppressWarnings("deprecation")
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if(hasFocus)
            decorView.setSystemUiVisibility(hideSystemBars());
    }

    //Function to return status of UI of status bar or FULLSCREEN..............

    @SuppressWarnings("deprecation")
    private int hideSystemBars(){
        return View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
    }



}

//........Hurray The Work is Done Now.................
