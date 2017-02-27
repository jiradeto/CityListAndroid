package app.pg_applications.com.effectiveuistudy.home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import app.pg_applications.com.effectiveuistudy.R;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }
}
