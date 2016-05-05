package omlib.sample;

import android.app.Activity;
import android.os.Bundle;
import mobisocial.omlet.OmletGameSDK;
import android.opengl.GLSurfaceView;
import javax.microedition.khronos.opengles.*;
import javax.microedition.khronos.egl.EGLConfig;
import android.opengl.GLSurfaceView.Renderer;
import java.util.Random;
import android.view.Window;
import static android.opengl.GLES10.*;

public class GLActvity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        
        GLSurfaceView gl = new GLSurfaceView(this);
        
        //opengl 2+ required
        gl.setEGLContextClientVersion(2);
        
		gl.setRenderer(new Renderer() {
            Random r = new Random();
			@Override
			public void onSurfaceCreated(GL10 gl, EGLConfig config) {
			}

			@Override
			public void onSurfaceChanged(GL10 gl, int width, int height) {
			}

			@Override
			public void onDrawFrame(GL10 gl) {
                glClearColor(r.nextFloat(),r.nextFloat(),r.nextFloat(), 1);
                glClear(GL10.GL_COLOR_BUFFER_BIT);
			}
		});
        setContentView(gl);

        OmletGameSDK.setGameChatOverlayEnabled(this, true);
        OmletGameSDK.setRecordingControlsEnabled(this, true);
    }
    
    
    @Override
    protected void onResume() {
        super.onResume();
        OmletGameSDK.onGameActivityResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        OmletGameSDK.onGameActivityPause(this);
    }

}
