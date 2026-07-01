package com.ios.iconpacks;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView tv = new TextView(this);
        tv.setText("Icon pack installed. Select it in your launcher's Icon Pack settings.");
        tv.setPadding(40, 100, 40, 40);
        setContentView(tv);
    }
}
