package com.example.gohil.piycalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText scr;
    private   double numb ;
    private  String operation ;
    public ButtonClicklistener btnClick;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scr = (EditText) findViewById(R.id.edit_text);

        scr.setEnabled(false);

        btnClick = new ButtonClicklistener();
        int idList[] = {R.id.ce,R.id.devide,R.id.backspe,R.id.eight,R.id.equal,R.id.five,R.id.four,R.id.six,R.id.seven,R.id.nine,R.id.mul,
                R.id.three,R.id.two,R.id.one,R.id.minus,R.id.plus,R.id.point,R.id.zero,R.id.inverse,R.id.tan,R.id.sin,
                R.id.cos,R.id.log,R.id.ten_res,R.id.min,R.id.sqre ,R.id.x_res       };

        for( int id:idList){
            View v = (View) findViewById(id);
            v.setOnClickListener(btnClick);
        }





    }



    public  void mMath(String str){
        numb = Double.parseDouble(scr.getText().toString());
        operation = str;
        scr.setText("0");
    }

    public  void mSci(String str){
        numb = Double.parseDouble(scr.getText().toString());
        operation = str;
    //    String st = str.concat("(").concat(String.valueOf(numb)).concat(")");
        scr.setText(str);

    }

    public void getkeyboard(String str){
        String scrCurrent = scr.getText().toString();
        if (scrCurrent.equals("0")){
            scrCurrent ="0";
        }

        scrCurrent += str;
        scr.setText(scrCurrent);
    }



    public void backs (){
        String scrCurrent = scr.getText().toString();
        if (scrCurrent != null && scrCurrent.length() > 0) {
            scrCurrent = scrCurrent.substring(0, scrCurrent.length()-1);
        }
        scr.setText(scrCurrent);
    }

    public void mResult(){
        double numa = 0;
        double result = 0;

        if (operation.equals("+")){
             numa = Double.parseDouble(scr.getText().toString());
            result = numb + numa;
        }
        if (operation.equals("-")){

             numa = Double.parseDouble(scr.getText().toString());
            result = numb - numa;
        }
        if (operation.equals("/")){
            numa = Double.parseDouble(scr.getText().toString());
            result = numb / numa;
        }
        if (operation.equals("*")){
            numa = Double.parseDouble(scr.getText().toString());
            result = numb * numa;
        }

        if(operation.equals("sin")){
            result = Math.sin(Math.toRadians(numb));

        }
        if(operation.equals("tan")){
            result = Math.tan((Math.toRadians(numb)));
        }
        if(operation.equals("cos")){
            result = Math.cos((Math.toRadians(numb)));
        }
        if(operation.equals("log")){
            result = Math.log10(numb);
        }
        if(operation.equals("sqr")){
            result = numb * numb;
        }
        if(operation.equals("mi")){
            result = -(numb) ;
        }
        if(operation.equals("inverse")){
            result = 1/numb ;
        }
        if(operation.equals("ten_res")){
            result = Math.pow(10,numb);
        }
        if(operation.equals("x_res")){
            numa = Double.parseDouble(scr.getText().toString());
            result = Math.pow(numb,numa);
        }
        scr.setText(String.valueOf(result));

    }


    //new classs
    public class ButtonClicklistener implements View.OnClickListener{
        public void onClick (View v){
            switch (v.getId()){
                case R.id.ce : //  clear all
                    scr.setText("");
                    numb = 0;
                    operation ="";
                    break;
                case  R.id.devide:
                    mMath("/");
                    break;
                case R.id.mul:
                    mMath("*");
                    break;
                case R.id.plus:
                    mMath("+");
                    break;
                case R.id.minus:
                    mMath("-");
                    break;

                case R.id.equal:
                    mResult();
                    break;
                case R.id.backspe:
                    backs();
                    break;
                case R.id.point:
                    String numbc  = ((Button) v).getText().toString();
                    getkeyboard(numbc);
                    break;
                case R.id.tan:
                    mSci("tan");
                    break;
                case R.id.sin:
                    mSci("sin");
                    break;
                case R.id.log:
                    mSci("log");
                    break;
                case R.id.cos:
                    mSci("cos");
                    break;
                case R.id.min:
                    mSci("mi");
                    break;
                case R.id.inverse:
                    mSci("inverse");
                    break;
                case R.id.ten_res:
                    mSci("ten_res");
                    break;
                case R.id.sqre:
                    mSci("sqr");
                    break;
                case R.id.x_res:
                    mMath("x_res");
                    break;


                default:
                    String numc  = ((Button) v).getText().toString();
                    getkeyboard(numc);
                    break;
            }
        }


    }




}