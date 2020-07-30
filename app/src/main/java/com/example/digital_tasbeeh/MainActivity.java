package com.example.digital_tasbeeh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn1;
    Button btn2;
    Button btn3;
    TextView txt1;
    int count=0;
    Intent i;
    Intent i1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=(Button)findViewById(R.id.count_btn);
        btn2=(Button)findViewById(R.id.reset_btn);
        btn3=(Button)findViewById(R.id.minus_btn);
        txt1=(TextView)findViewById(R.id.txt_view);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                txt1.setText(String.valueOf(count));

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int i=Integer.parseInt(txt1.getText().toString());
                int b=i--;
                txt1.setText(String.valueOf(b));





            }
        });

        btn2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                count=0;
                txt1.setText(String.valueOf(count));


                Toast.makeText(getApplicationContext(),"reset tasbeeh",Toast.LENGTH_LONG).show();
                return false;

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence str1=txt1.getText();
                int num1 = Integer.parseInt(str1.toString());
                count=num1;
                if(count>0) {
                    count = count - 1;
                    txt1.setText(String.valueOf(count));
                }
                else if(num1==0){
                    count=0;
                    txt1.setText(String.valueOf(count));
                }

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater im=getMenuInflater();
        im.inflate(R.menu.menu1,menu);
        return super.onCreateOptionsMenu(menu);
    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.about:
              switchActivity(item.getActionView());
                  return true;
            case R.id.contact_us:
                switchContactUs(item.getActionView());

            default:
                return super.onOptionsItemSelected(item);
        }


    }


        public void switchActivity(View view){
        i=new Intent(getApplicationContext(),about_us.class);
        startActivity(i);
        }

        public void switchContactUs(View view){

        i1= new Intent(Intent.ACTION_DIAL, Uri.parse("tel:0313225590"));
        startActivity(i1);
        }


}