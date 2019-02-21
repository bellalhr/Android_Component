package io.destreza.android_component.Retrofits;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface ApiInterface {
    @GET("categories")
    Call<Model> getCategoriesListApi();
}
