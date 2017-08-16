package com.nica.bolitaap;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.nica.bolitaap.databinding.ActivityMainBinding;

public class MainActivity extends BaseAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //TextView toolbarTitle = (TextView) findViewById(R.id.toolbar);


        ActivityMainBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
       // ActivityMainBinding binding = DataBindingUtil.inflate(getLayoutInflater(),);


        Toolbar toolbar = binding.toolbarinclude.toolbar;
        TextView toolbarTitle = binding.toolbarinclude.toolbarTitle;

        initToolbar(toolbar);
        toolbarTitle.setText("Bolitapp");


    }
}
