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


public class MainActivity extends AppCompatActivity {

    //.....Variable Declaration.......
    private View decorView;
    private Button onebtn,twobtn,threebtn,fourbtn,fivebtn,sixbtn,sevenbtn,eightbtn,ninebtn,clearbtn;
    private Button pmbtn,dividebtn,multiplybtn,plusbtn,subbtn,equalbtn,decimalbtn,zerobtn;
    private ImageButton delbtn;
    TextView text1,text2;

    public String ans="";
    ArrayList <Integer> a = new ArrayList<Integer>();


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




        zerobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans+="1";
                text1.setText(text1.getText() + "0");
            }
        });
        onebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans+="2";
                text1.setText(text1.getText() + "1");
            }
        });

        twobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans+="2";
                text1.setText(text1.getText() + "2");
            }
        });

        threebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans+="3";
                text1.setText(text1.getText() + "3");
            }
        });

        fourbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans+="4";
                text1.setText(text1.getText() + "4");
            }
        });

        fivebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans+="5";
                text1.setText(text1.getText() + "5");
            }
        });

        sixbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans+="6";
                text1.setText(text1.getText() + "6");
            }
        });

        sevenbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans+="7";
                text1.setText(text1.getText() + "7");
            }
        });

        eightbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans+="8";
                text1.setText(text1.getText() + "8");
            }
        });

        ninebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans+="9";
                text1.setText(text1.getText() + "9");
            }
        });

        decimalbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!text1.getText().toString().isEmpty()){
                    String s = text1.getText().toString();
                    char ch = s.charAt(s.length() - 1);
                    if(ch!='+' && ch != '-' && ch!='%' && ch != '×' && ch != '÷'){
                        ans+=".";
                        text1.setText(text1.getText() + ".");
                    }
                }
            }
        });

        clearbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans ="";
                text1.setText(null);
                text2.setText(null);
                a.clear();
            }
        });

        pmbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = text1.getText().toString();
                double res = Double.parseDouble(s + "");
                res*=(-1);
                ans= String.valueOf(res);
                text1.setText(res + "");

            }
        });




        dividebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!text1.getText().toString().isEmpty())
                {
                    String s = text1.getText().toString();
                    char ch=s.charAt(s.length()-1);
                    if(ch!='+' && ch!='-' &&  ch!='×' && ch!='÷' && ch!='.') {
                        a.add(s.length()-1);
                        ans+="÷";
                        text1.setText(text1.getText() + "÷");
                    }
                }
            }
        });

        plusbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!text1.getText().toString().isEmpty())
                {
                    String s = text1.getText().toString();
                    char ch=s.charAt(s.length()-1);
                    if(ch!='+' && ch!='-' &&  ch!='×' && ch!='÷' && ch!='.') {
                        a.add(s.length()-1);
                        ans+="+";
                        text1.setText(text1.getText() + "+");
                    }
                }
            }
        });

        subbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!text1.getText().toString().isEmpty())
                {
                    String s = text1.getText().toString();
                    char ch=s.charAt(s.length()-1);
                    if(ch!='+' && ch!='-' &&  ch!='×' && ch!='÷' && ch!='.') {
                        a.add(s.length()-1);
                        ans+="-";
                        text1.setText(text1.getText() + "-");
                    }
                }
            }
        });

        multiplybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!text1.getText().toString().isEmpty())
                {
                    String s = text1.getText().toString();
                    char ch=s.charAt(s.length()-1);
                    if(ch!='+' && ch!='-' && ch!='×' && ch!='÷' && ch!='.') {
                        a.add(s.length()-1);
                        ans+="×";
                        text1.setText(text1.getText() + "×");
                    }


                }
            }
        });

        //.......BackSpace Function.....

        delbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!text1.getText().toString().isEmpty()) {
                    String s = text1.getText().toString();
                    //ans=ans.substring(0,ans.length());
                    String s1 = "";
                    for (int i = 0; i < s.length() - 1; i++) {
                        s1 =s1 + s.charAt(i);
                    }
                    //ans=ans.substring(0,s.length()-1);
                    ans = s1;
                    text1.setText(s1);
                }
            }
        });

        equalbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!text1.getText().toString().isEmpty())
                {
                    String s = ans;
                    char ch = s.charAt(s.length() - 1);
                    if (ch == '+' || ch == '-' || ch == '×' || ch == '÷' || ch=='.')
                    {
                        Toast.makeText(getApplicationContext(), "Invalid", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        a.add(s.length()-1);
                        s+= "=";
                        //String info="";

                        //boolean div=false,mult=false,sub=false,perc=false,add1=false;

                        double res=Double.parseDouble(s.substring(0,a.get(0)+1));

                        for(int i=0;i<a.size()-1;i++)
                        {
                            double answ = Double.parseDouble(s.substring(a.get(i)+2,a.get(i+1)+1));
                            if(s.charAt(a.get(i)+1)=='+')
                            {
                                res+=answ;
                            }
                            else if(s.charAt(a.get(i)+1)=='-')
                            {
                                res-=answ;
                            }
                            else if(s.charAt(a.get(i)+1)=='÷')
                            {
                                res/=answ;
                            }
                            else if(s.charAt(a.get(i)+1)=='×')
                            {
                                res*=answ;
                            }

                        }

                        String answer = String.valueOf(res);
                        a.clear();


                        //int check=0; //first time
                        //String answ= String.valueOf(a.size());



                        text2.setText(answer);
                        //a.add(answer.length()-1);
                        ans=answer;
                    }


                }
            }
        });






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