package com.haiyunshan.whatsandroid;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import club.andnext.markdown.MarkdownWebView;
import club.andnext.utils.AssetUtils;

public class HelpActivity extends AppCompatActivity {

    MarkdownWebView markdownWebView;

    String name;
    String help;

    public static final void start(Activity context, String name, String help) {
        Intent intent = new Intent(context, HelpActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("help", help);

        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_help);

        {
            Intent intent = this.getIntent();
            name = intent.getStringExtra("name");
            help = intent.getStringExtra("help");
        }

        {
            this.markdownWebView = findViewById(R.id.marked_view);
        }

        {
            this.setTitle(name);
        }

        if (!TextUtils.isEmpty(help)) {
            String name = "help/" + help;
            String text = AssetUtils.getString(this, name);
            markdownWebView.setText(text);
        }
    }
}
