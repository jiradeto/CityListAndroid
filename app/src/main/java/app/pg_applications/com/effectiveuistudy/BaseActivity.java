package app.pg_applications.com.effectiveuistudy;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.File;

import app.pg_applications.com.effectiveuistudy.dep.DaggerDeps;
import app.pg_applications.com.effectiveuistudy.dep.Deps;
import app.pg_applications.com.effectiveuistudy.networking.NetworkModule;

/**
 * Created by jiradet on 2/27/2017 AD.
 */

public class BaseActivity extends AppCompatActivity {

    Deps deps;

    private static final String TAG = "BaseActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        File cacheFile = new File(getCacheDir(), "responses");

        deps = DaggerDeps.builder().networkModule(new NetworkModule(cacheFile)).build();
    }

    public Deps getDep() {
        return deps;
    }
}
