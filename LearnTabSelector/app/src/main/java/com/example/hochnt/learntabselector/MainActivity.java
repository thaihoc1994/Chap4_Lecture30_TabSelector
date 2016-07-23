package com.example.hochnt.learntabselector;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //khai bao tat ca cac control trong main
    EditText txtA,txtB;
    Button btnCong;

    ListView lvHistory;
    ArrayList<String>dsCong;
    ArrayAdapter<String>adapterCong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControl();
        addEvent();
    }

    private void addEvent() {
        btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyCong();
            }
        });
    }

    private void xuLyCong() {
        int a = Integer.parseInt(txtA.getText().toString());
        int b = Integer.parseInt(txtB.getText().toString());
        String s = a + "+" + b + "=" + (a+b);
        dsCong.add(s);
        Toast.makeText(MainActivity.this,"Tổng là: " + (a+b),Toast.LENGTH_SHORT).show();
        txtA.setText("");
        txtB.setText("");
    }

    private void addControl() {

        TabHost tabHost = (TabHost) findViewById(R.id.tabHost);//ở version mới có thể bắt sửa @android:id
        tabHost.setup();//cau hinh de tao ra tabhost

        TabHost.TabSpec tspc1 =  tabHost.newTabSpec("t1");//t1 la ten tab
//        tspc1.setIndicator("Phép cộng");//hien thi chuoi hoac hinh
        tspc1.setIndicator("",getResources().getDrawable(R.drawable.plus));//hien thi chuoi hoac hinh
        tspc1.setContent(R.id.tab1);
        tabHost.addTab(tspc1);

        TabHost.TabSpec tspc2 =  tabHost.newTabSpec("t2");//t1 la ten tab : ID
//        tspc2.setIndicator("Lịch sử");//hien thi chuoi hoac hinh
        tspc2.setIndicator("",getResources().getDrawable(R.drawable.history));//hien thi chuoi hoac hinh
        tspc2.setContent(R.id.tab2);
        tabHost.addTab(tspc2);

        //
        txtA = (EditText) findViewById(R.id.txtA);
        txtB = (EditText) findViewById(R.id.txtB);
        btnCong = (Button) findViewById(R.id.btnCong);
        lvHistory = (ListView) findViewById(R.id.lvHistory);

        dsCong = new ArrayList<String>();
        adapterCong = new ArrayAdapter<String>
                (MainActivity.this,android.R.layout.simple_list_item_1,dsCong);
        lvHistory.setAdapter(adapterCong);
    }
}
