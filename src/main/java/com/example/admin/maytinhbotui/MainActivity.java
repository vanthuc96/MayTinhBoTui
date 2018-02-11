package com.example.admin.maytinhbotui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtNumber;
    private TextView tvResult;
    private Button btn0;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;

    private Button btnMinus;
    private Button btnAdd;
    private Button btnMultiplied;
    private Button btnDevided;
    private Button btnEqual;
    private Button btnPoint;

    private  Button btnAC;
    private  Button btnC;

    private  final  String TAG=getClass().getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidget();// khoi tao cac doi tuong tuong ung cac thanh phan trong file layout
        setEventClickViews();//lang nghe cac su kien
    }
    public void initWidget(){ // khoi tao cac doi tuong tuong ung cac nut trong file layout
            edtNumber=(EditText) findViewById(R.id.edt_input);
            tvResult=(TextView) findViewById(R.id.tv_result);
            btn0=(Button) findViewById(R.id.btn0);
            btn1=(Button) findViewById(R.id.btn1);
            btn2=(Button) findViewById(R.id.btn2);
            btn3=(Button) findViewById(R.id.btn3);
            btn4=(Button) findViewById(R.id.btn4);
            btn5=(Button) findViewById(R.id.btn5);
            btn6=(Button) findViewById(R.id.btn6);
            btn7=(Button) findViewById(R.id.btn7);
            btn8=(Button) findViewById(R.id.btn8);
            btn9=(Button) findViewById(R.id.btn9);
            btnAdd=(Button) findViewById(R.id.btnAdd);
            btnMinus=(Button) findViewById(R.id.btnMinus);
            btnMultiplied=(Button) findViewById(R.id.btnMutilplied);
            btnDevided=(Button) findViewById(R.id.btnDevided);
            btnEqual=(Button) findViewById(R.id.btnEqual);
            btnAC=(Button) findViewById(R.id.btnAC);
            btnC=(Button) findViewById(R.id.btnC);
            btnPoint=(Button) findViewById(R.id.btnPoint);
    }
    public void setEventClickViews(){
            btn0.setOnClickListener(this);
            btn1.setOnClickListener(this);
            btn2.setOnClickListener(this);
            btn3.setOnClickListener(this);
            btn4.setOnClickListener(this);
            btn5.setOnClickListener(this);
            btn6.setOnClickListener(this);
            btn7.setOnClickListener(this);
            btn8.setOnClickListener(this);
            btn9.setOnClickListener(this);
            btnAdd.setOnClickListener(this);
            btnMinus.setOnClickListener(this);
            btnMultiplied.setOnClickListener(this);
            btnDevided.setOnClickListener(this);
            btnPoint.setOnClickListener(this);
            btnEqual.setOnClickListener(this);
            btnC.setOnClickListener(this);
            btnAC.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {//kich hoat cac su kien khi click vao button
        switch (view.getId()){
            case R.id.btn0:
                edtNumber.append("0");
             break;
            case R.id.btn1:
                edtNumber.append("1");
                break;
            case R.id.btn2:
                edtNumber.append("2");
             break;
            case R.id.btn3:
                edtNumber.append("3");
                break;
            case R.id.btn4:
                edtNumber.append("4");
                break;
            case R.id.btn5:
                edtNumber.append("5");
                break;
            case R.id.btn6:
                edtNumber.append("6");
                break;
            case R.id.btn7:
                edtNumber.append("7");
                break;
            case R.id.btn8:
                edtNumber.append("8");
                break;
            case R.id.btn9:
                edtNumber.append("9");
                break;
            case R.id.btnAdd:
                edtNumber.append("+");
                break;
            case R.id.btnMinus:
                edtNumber.append("-");
                break;
            case R.id.btnMutilplied:
                edtNumber.append("*");
                break;
            case R.id.btnDevided:
                edtNumber.append("/");
                break;
            case R.id.btnPoint:
                edtNumber.append(".");
                break;

            case R.id.btnEqual:
                double result=0;
                addOperation(edtNumber.getText().toString());
                addNumber(edtNumber.getText().toString());
                if(arrOperation.size()>=arrNumber.size()){
                    tvResult.setText("Error Operation");
                }
                else{
                for(int i=0;i<arrNumber.size()-1;i++) {
                    switch (arrOperation.get(i)) {
                        case "+":
                            if (i == 0) result = arrNumber.get(i) + arrNumber.get(i + 1);
                            else result += arrNumber.get(i + 1);
                            break;
                        case "-":
                            if (i == 0) result = arrNumber.get(i) - arrNumber.get(i + 1);
                            else result -= arrNumber.get(i + 1);
                            break;
                        case "*":
                            if (i == 0) result = arrNumber.get(i) * arrNumber.get(i + 1);
                            else result *= arrNumber.get(i + 1);
                            break;
                        case "/":
                            if (i == 0) result = arrNumber.get(i) / arrNumber.get(i + 1);
                            else result /= arrNumber.get(i + 1);
                            break;
                    }
                }
                    tvResult.setText(result+ "");
                }
                break;
            case R.id.btnC:
                BaseInputConnection texInputConnection=new BaseInputConnection(edtNumber,true);
                texInputConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN,KeyEvent.KEYCODE_DEL));
                break;
            case R.id.btnAC:
                edtNumber.setText("");
                break;
                default:
                    break;
        }
    }
    public ArrayList<String> arrOperation;//mang luu cac toan tu
    public ArrayList<Double> arrNumber;//mang luu cac so

    public void addOperation(String input){
        arrOperation=new ArrayList<>();//khoi tao danh sach
        char[] cArray=input.toCharArray();//dua chuoi input ve mang ky tu
        for(int i=0;i<cArray.length;i++){//xet cac phan tu trong mang ky tu cArray neu phan tu thu i la toan tu thi dua vao list arrOperation
            switch (cArray[i]){
                case '+': arrOperation.add(cArray[i]+"");
                    break;
                case '-': arrOperation.add(cArray[i]+"");
                    break;
                case '*': arrOperation.add(cArray[i]+"");
                    break;
                case '/': arrOperation.add(cArray[i]+"");
                    break;
                default:
                    break;
            }
        }
    }
    public void addNumber(String input){
        arrNumber=new ArrayList<>();
        Pattern regex=Pattern.compile("(\\d+(?:\\.\\d+)?)");
        Matcher matcher=regex.matcher(input);
        while (matcher.find()){
            arrNumber.add(Double.valueOf(matcher.group(1)));
        }
    }

}
