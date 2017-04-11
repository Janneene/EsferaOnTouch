package com.example.jann.appmoleculas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.WindowManager;

public class MainActivity extends Activity implements OnTouchListener {

    private float YValue;
    private float XValue;
    private AtomoRenderer atomoRenderer;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        GLSurfaceView view = new GLSurfaceView(this);
        atomoRenderer = new AtomoRenderer(true);
        view.setRenderer(atomoRenderer);
        view.setOnTouchListener(this);
        setContentView(view);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        //

        //
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                YValue = event.getY();
                XValue = event.getX();
                break;
            case MotionEvent.ACTION_MOVE:
                atomoRenderer.transZ = transZ(event.getY(), atomoRenderer.transZ);

                break;
        }
        return true;
    }

    private float transZ(float y, float transZ) {
        float maxTransZ = -3.0f;
        float minTransZ = -20.0f;
        transZ += (YValue - y) / 100;
        transZ = Math.min(maxTransZ, transZ);
        transZ = Math.max(minTransZ, transZ);
        return transZ;
    }

}