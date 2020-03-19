package com.reactlibrary;

import android.content.Intent;
import android.util.Log;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

public class DelLibrary1Module extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;
    ReactApplicationContext context = getReactApplicationContext();

    public DelLibrary1Module(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "DelLibrary1";
    }

    @ReactMethod
    public void sampleMethod(String stringArgument, int numberArgument, Callback callback) {
        // TODO: Implement some actually useful functionality
        callback.invoke("Received numberArgument: " + numberArgument + " stringArgument: " + stringArgument);
    }

    @ReactMethod
    public void testLog() {
        Log.d("HTAG", "testLog: This method is called..");
        Intent intent = new Intent(context, LiveStream.class);
        Log.d("HTAG", "testLog:  below Intent : ");
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            Log.d("HTAG", "testLog: Context Intent here... ");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }
}
