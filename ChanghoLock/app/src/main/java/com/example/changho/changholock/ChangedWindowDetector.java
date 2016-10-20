package com.example.changho.changholock;

import android.accessibilityservice.AccessibilityService;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;

/**
 * Created by Changho on 2016-10-05.
 */
public class ChangedWindowDetector extends AccessibilityService{
    @Override
    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED)
            Log.i("WindowChangeDetect ",
                    "Window Package: " + accessibilityEvent.getPackageName());

    }

    @Override
    public void onInterrupt() {

    }
}
