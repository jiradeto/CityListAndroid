package app.pg_applications.com.effectiveuistudy.dep;

import javax.inject.Singleton;

import app.pg_applications.com.effectiveuistudy.home.MainActivity;
import app.pg_applications.com.effectiveuistudy.networking.NetworkModule;
import dagger.Component;

/**
 * Created by jiradet on 2/27/2017 AD.
 */

@Singleton
@Component(modules = {NetworkModule.class})
public interface Deps {
    void inject(MainActivity mainActivity);
}
