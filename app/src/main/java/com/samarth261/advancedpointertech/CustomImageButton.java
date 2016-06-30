package com.samarth261.advancedpointertech;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * Created by Samarth on 27-06-2016.
 */

public class CustomImageButton extends ImageButton {

    double dis;
    int flag;

    CustomImageButton(Context context)
    {
        super(context);
        flag=0;
    }
    CustomImageButton(Context context, AttributeSet attributeSet)
    {
        super(context,attributeSet);
        flag=0;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        if(event.getPointerCount()==2&&flag==0)
        {
            flag=1;
            dis=(Math.sqrt(Math.pow(event.getX(0)-event.getX(1),2)+Math.pow(event.getY(0)-event.getY(1),2)));
        }
        else if(event.getPointerCount()==2&&flag==1)
        {
            double d=(Math.sqrt(Math.pow(event.getX(0)-event.getX(1),2)+Math.pow(event.getY(0)-event.getY(1),2)));
            if(dis-d>50) {
                clickequi();
                return false;
            }
        }
        else
        {
            dis=0;
            flag=0;

        }
        return true;
    }

    //@Override
    public void clickequi()
    {
        Toast.makeText(getContext(),"equivalent of click function running",Toast.LENGTH_LONG).show();
    }
}
