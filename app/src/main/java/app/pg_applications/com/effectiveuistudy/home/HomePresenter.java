package app.pg_applications.com.effectiveuistudy.home;

import android.util.Log;

import app.pg_applications.com.effectiveuistudy.models.CityListResponse;
import app.pg_applications.com.effectiveuistudy.networking.Service;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;

/**
 * Created by jiradet on 2/27/2017 AD.
 */

public class HomePresenter {
    private final Service service;
    private final HomeView mView;
    private CompositeSubscription compositeSubscription;


    public HomePresenter(Service service, HomeView view) {
        this.service = service;
        mView = view;
        compositeSubscription = new CompositeSubscription();
    }

    void getCityList() {
        mView.showProgress();


        Subscription subscription = service.getCityList(new Service.CityListCallback() {
            @Override
            public void onSuccess(CityListResponse cityListResponse) {

                mView.hideProgress();
                mView.setData(cityListResponse);
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "FAIL: POND");
                e.printStackTrace();
                mView.hideProgress();
                mView.onFailure("Failed");
            }
        });

        compositeSubscription.add(subscription);
    }

    public void onStop() {
        compositeSubscription.unsubscribe();
    }
}
