package com.keshogroup.cartrader.model;

import retrofit.RetrofitError;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by darren on 7/23/15.
 */
public interface CartraderClient {

    String METHOD_GET = "GET";
    String BASE_URL = "http://api.wunderground.com/api/852ddd19c6a16593";

    @GET("/conditions/q/{zip}.json")
    ConditionsResponse getCondition(@Path("zip") String zip) throws RetrofitError;

}
