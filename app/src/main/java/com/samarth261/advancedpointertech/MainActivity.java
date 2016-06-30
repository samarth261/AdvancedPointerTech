package com.samarth261.advancedpointertech;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CustomImageButton cib;//=(CustomImageButton)findViewById(R.id.imageButton);
         cib=new CustomImageButton(this);
        ((RelativeLayout)findViewById(R.id.rl)).addView(cib,150,150);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        ((RelativeLayout)findViewById(R.id.rl)).removeAllViews();
        if(event.getAction()==event.ACTION_UP) {
            setContentView(R.layout.activity_main);
            CustomImageButton cib;//=(CustomImageButton)findViewById(R.id.imageButton);
            cib=new CustomImageButton(this);
            ((RelativeLayout)findViewById(R.id.rl)).addView(cib,150,150);
            ((RelativeLayout)findViewById(R.id.rl)).setBackgroundColor(0x00000000);
            return false;
        }
        int n=event.getPointerCount();
        for (int i=0;i<n;i++)
        {
            TextView tv=new TextView(this);
            tv.setTextColor(0xff000000);
            tv.setTextSize(30);
            tv.setText(Integer.toString((int)event.getX(i))+","+Integer.toString((int)event.getY(i)));
            tv.setX(event.getX(i)-170);
            tv.setY(event.getY(i)-120);
            tv.setBackgroundColor(0x20000000);
            ((RelativeLayout)findViewById(R.id.rl)).addView(tv,-2,-2);
        }
        if(n==2)
        {
            float H;
            float S;
            double factor=(1)/960.0;
            S=(float) ((Math.sqrt(Math.pow(event.getX(0)-event.getX(1),2)+Math.pow(event.getY(0)-event.getY(1),2)))*factor);
            factor=(370)/540.0;
            H=(float)((event.getX(0)+event.getX(1))/2*factor);
            float HSV[]={H,S,1};
           // Toast.makeText(this,(int)H+","+(int)(S*100),Toast.LENGTH_SHORT).show();
            ((RelativeLayout)findViewById(R.id.rl)).setBackgroundColor(Color.HSVToColor(0xff,HSV));
        }
        return false;
    }
}
