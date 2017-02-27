package app.pg_applications.com.effectiveuistudy;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import java.io.File;

import app.pg_applications.com.effectiveuistudy.dep.DaggerDeps;
import app.pg_applications.com.effectiveuistudy.dep.Deps;
import app.pg_applications.com.effectiveuistudy.networking.NetworkModule;

/**
 * Created by jiradet on 2/27/2017 AD.
 */

public class BaseActivity extends AppCompatActivity {

    Deps dep;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        File cacheFile = new File(getCacheDir(), "responses");

        DaggerDeps.builder().networkModule(new NetworkModule(cacheFile)).build();
    }

    public Deps getDep() {
        return dep;
    }
}
