package com.ipack.exe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends Activity {

    private static final String[] ICON_NAMES = {
            "app_store", "apple_music", "calendar_alt_01", "camera_alt_06",
            "clock", "email", "ex_dialer", "messages", "my_files",
            "notes", "photos_a_plus", "settings"
    };

    private static final String[] SUPPORTED_LAUNCHER_ACTIONS = {
            "com.novalauncher.THEME",
            "org.adw.launcher.icons.ACTION_PICK_ICON",
            "com.anddoes.launcher.THEME",
            "com.teslacoilsw.launcher.THEME",
            "ginlemon.iconpackstudio.ACTION_ICONPACK"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recycler = findViewById(R.id.icons_recycler);
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recycler.setAdapter(new IconAdapter(this, ICON_NAMES));

        TextView launcherSupportText = findViewById(R.id.launcher_support_text);
        launcherSupportText.setText("Supported launchers: " + SUPPORTED_LAUNCHER_ACTIONS.length);

        ToggleButton applyToggle = findViewById(R.id.apply_toggle);
        applyToggle.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                Toast.makeText(this, "Now select \"iPack\" as icon pack in your launcher's settings", Toast.LENGTH_LONG).show();
            }
        });

        findViewById(R.id.about_button).setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, AboutActivity.class)));
    }
}