package com.my.memory.annotation.custom;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.my.apt.annotation.BindView;
import com.my.memory.test.R;


public class CustomAnnotationActivity extends AppCompatActivity {

    @BindView(R.id.tv)
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_annotation);
        BindViewTools.bind(this);
        mTextView.setText("bind TextView success");
    }
}
