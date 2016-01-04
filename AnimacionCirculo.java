package utilities;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.Image;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import boken.notiplac.R;

/**
 * Created by Cuervo on 16/12/2015.
 */
public class AnimacionCirculo extends View {
    private int radioIn = 4;
    private int radio = 130;
    private int radio2 = radio - 30;
    private int radio3 = radio2 - 30;
    private int radioMax;
    private int radioMin;
    private int[] posiciones = new int[2];
    private ImageView imagen;

    //Circulo de inicio
    public AnimacionCirculo(Context context,ImageView i, int rMax, int rMin) {
        super(context);
        imagen = i;
        imagen.getLocationOnScreen(posiciones);

        radioMax = rMax;
        radioMin = rMin;
        radio = radioMin+1;
    }
    public AnimacionCirculo(Context context,ImageButton i, int rMax, int rMin) {
        super(context);
        imagen = i;
        imagen.getLocationOnScreen(posiciones);

        radioMax = rMax;
        radioMin = rMin;
        radio = radioMin+1;
    }
    //Circulo de Control



    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        imagen.getLocationInWindow(posiciones);
        latirRadio();

        Paint paint = new Paint();
        paint.setColor(Color.argb(80,200,200,200));

        Paint paint2 = new Paint();
        paint2.setColor(Color.argb(80,200,200,200));

        Paint paint3 = new Paint();
        paint3.setColor(Color.argb(80,200,200,200));

        canvas.drawCircle((imagen.getWidth()/2)+imagen.getX(), (imagen.getWidth()/2)+imagen.getY(), radio, paint);
        canvas.drawCircle((imagen.getWidth()/2)+imagen.getX(), (imagen.getWidth()/2)+imagen.getY(), radio-50, paint2);
        canvas.drawCircle((imagen.getWidth()/2)+imagen.getX(), (imagen.getWidth()/2)+imagen.getY(), radio-100, paint3);

        postInvalidate();
    }
    public void latirRadio(){
        if(radio > radioMax) {
            radioIn = -radioIn;
        }
        if(radio < radioMin ){
            radioIn = -radioIn;
        }
        radio += radioIn;
        radio2 += radioIn;
        radio3 += radioIn;
    }
}
