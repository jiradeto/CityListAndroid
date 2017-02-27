package app.pg_applications.com.effectiveuistudy.home;

import app.pg_applications.com.effectiveuistudy.models.CityListResponse;

/**
 * Created by jiradet on 2/27/2017 AD.
 */

public interface HomeView {

    void showProgress();

    void hideProgress();

    void onFailure(String appErrorMessage);

    void setData(CityListResponse cityListResponse);

}
