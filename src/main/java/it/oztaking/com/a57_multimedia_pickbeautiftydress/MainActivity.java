package it.oztaking.com.a57_multimedia_pickbeautiftydress;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final ImageView iv_pre = (ImageView) findViewById(R.id.iv_pre);



        //1.创建模板
        Bitmap srcBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.pre19);

        final Bitmap copybitmap = Bitmap.createBitmap(srcBitmap.getWidth(), srcBitmap.getHeight(), srcBitmap.getConfig());
        final Canvas canvas = new Canvas(copybitmap);
        final Paint paint = new Paint();
        canvas.drawBitmap(srcBitmap,new Matrix(),paint);
        iv_pre.setImageBitmap(copybitmap);

        iv_pre.setOnTouchListener(new View.OnTouchListener() {
            int startX = 0;
            int startY = 0;
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();

                switch (action){
                    case MotionEvent.ACTION_DOWN:
                        startX = (int) event.getX();
                        startY = (int) event.getY();

                        break;
                    case MotionEvent.ACTION_MOVE:
                        int stopX = (int) event.getX();
                        int stopY = (int) event.getY();

                        for (int i=0; i<20; i++){
                            for (int j=0; j<20; j++){
                                if (Math.sqrt(i*i + j*j) <20 ){
                                    copybitmap.setPixel(stopX+i,stopY+j,Color.TRANSPARENT);
                                    //canvas.drawLine(startX,startY,stopX,stopY,paint);
                                }

                            }
                        }
//
//                        paint.setColor(Color.TRANSPARENT);
////                        paint.setColor(0x000000);
//                        paint.setAlpha(100);
//                        paint.setStrokeWidth(50f);

//
//                        startX = stopX;
//                        startY = stopY;


                        iv_pre.setImageBitmap(copybitmap);
                        break;
                    default:
                        break;

                }


                return true;
            }
        });
    }
}
