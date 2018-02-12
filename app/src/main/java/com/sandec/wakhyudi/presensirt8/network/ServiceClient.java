package com.sandec.wakhyudi.presensirt8.network;

import com.sandec.wakhyudi.presensirt8.model.ResponServer;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by wakhyudi on 30/01/18.
 */

public interface ServiceClient {
    @Headers("Content-Type: application/json")
    @POST("exec")
    Call<ResponServer> sendPresensi(@Query("action") String action,
                                    @Query("sheetName")String sheetName,
                                    @Query("bulan") String bulan,
                                    @Query("data") List<String>listPresensi);

}
