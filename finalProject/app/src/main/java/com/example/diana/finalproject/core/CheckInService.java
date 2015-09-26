package com.example.diana.finalproject.core;

import java.util.List;

import retrofit.http.GET;

public interface CheckInService {

    @GET(Constants.Http.URL_CHECKINS_FRAG)
    CheckInWrapper getCheckIns();
}
