package app.pg_applications.com.effectiveuistudy.networking;

import app.pg_applications.com.effectiveuistudy.models.CityListResponse;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by jiradet on 2/27/2017 AD.
 */

public interface NetworkService {

    @GET("v1/city")
    Observable<CityListResponse> getCityList();
    
}

