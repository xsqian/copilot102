package com.projecttango.examples.java.motiontracking;

import com.google.atap.tangoservice.Tango;
import com.google.atap.tangoservice.TangoConfig;
import com.google.atap.tangoservice.TangoCoordinateFramePair;
import com.google.atap.tangoservice.TangoEvent;
import com.google.atap.tangoservice.TangoInvalidException;
import com.google.atap.tangoservice.TangoOutOfDateException;
import com.google.atap.tangoservice.TangoPointCloudData;
import com.google.atap.tangoservice.TangoPoseData;
import com.google.atap.tangoservice.TangoXyzIjData;
import com.google.tango.support.TangoSupport;

import android.app.Activity;
import android.hardware.display.DisplayManager;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.widget.Toast;

import org.rajawali3d.scene.ASceneFrameCallback;
import org.rajawali3d.surface.RajawaliSurfaceView;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Main Activity class for the Motion Tracking API Sample. Handles the connection to the Tango
 * Service and propagation of Tango pose data to OpenGL and Layout views. OpenGL rendering logic is
 * delegated to the {@link MotionTrackingRajawaliRenderer} class.
 */
public class MotionTrackingActivity extends Activity {

    private static final String TAG = MotionTrackingActivity.class.getSimpleName();

    private RajawaliSurfaceView mSurfaceView;
    private MotionTrackingRajawaliRenderer mRenderer;

    private AtomicBoolean mIsTangoPoseReady = new AtomicBoolean(false);
    private int mDisplayRotation = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motion_tracking);
        setupViews();
        setupRenderer();
    }

    @Override
    protected void onResume() {
        super.onResume();
        initializeTango();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    private void setupViews() {
        mSurfaceView = findViewById(R.id.gl_surface_view);
        mRenderer = new MotionTrackingRajawaliRenderer(this);
        mSurfaceView.setEGLContextClientVersion(2);
        mSurfaceView.setSurfaceRenderer(mRenderer);
        mSurfaceView.setRenderMode(GLSurfaceView.RENDERMODE_CONTINUOUSLY);
    }

    private void initializeTango() {
        Tango tango = new Tango(MotionTrackingActivity.this, new Runnable() {
            @Override
            public void run() {
                synchronized (MotionTrackingActivity.this) {
                    try {
                        mConfig = setupTangoConfig();
                        TangoSupport.initialize(tango);
                        mIsTangoPoseReady.set(true);
                        setDisplayRotation();
                    } catch (TangoOutOfDateException e) {
                        Log.e(TAG, getString(R.string.exception_out_of_date), e);
                        showsToastAndFinishOnUiThread(R.string.exception_out_of_date);
                    } catch (TangoInvalidException e) {
                        Log.e(TAG, getString(R.string.exception_tango_invalid), e);
                        showsToastAndFinishOnUiThread(R.string.exception_tango_invalid);
                    }
                }
            }
        });
    }

    private void disconnectTango() {
        mIsTangoPoseReady.set(false);
    }

    private TangoConfig setupTangoConfig() {
        TangoConfig config = tango.getConfig(TangoConfig.CONFIG_TYPE_DEFAULT);
        config.putBoolean(TangoConfig.KEY_BOOLEAN_MOTIONTRACKING, true);
        config.putBoolean(TangoConfig.KEY_BOOLEAN_AUTORECOVERY, true);
        return config;
    }

    private void setDisplayRotation() {
        Display display = getWindowManager().getDefaultDisplay();
        mDisplayRotation = display.getRotation();
    }

    private void showsToastAndFinishOnUiThread(final int resId) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MotionTrackingActivity.this,
                        getString(resId), Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}