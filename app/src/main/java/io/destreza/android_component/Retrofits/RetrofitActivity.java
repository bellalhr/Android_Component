package io.destreza.android_component.Retrofits;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import io.destreza.android_component.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitActivity extends AppCompatActivity {
    private static final String BASE_URL="http://192.168.0.110/Project/ExamHelper/api/";
    private static final String LOG="error";
    private TextView categoryNameTV;
    int k=0;
   // private static final String BASE_URL="https://127.0.0.1/Project/ExamHelper/api/";
   // private static final String BASE_URL="https://opentdb.com/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

        categoryNameTV=findViewById(R.id.categoryName);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface apiInterface=retrofit.create(ApiInterface.class);

        apiInterface.getCategoriesListApi().enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                if(response.isSuccessful())
                {
                    String category="";
                    //Toast.makeText(RetrofitActivity.this, "Success "+response.body().getData().getCategories().size(), Toast.LENGTH_SHORT).show();
                    for(int i=0;i<response.body().getData().getCategories().size();i++)
                    {
                        String categoryName=response.body().getData().getCategories().get(i).getCategoryName();
                        Log.e("Log",categoryName);
                        category=category+"\n"+categoryName;

                    }

                    categoryNameTV.setText(category);
                }
                else{
                    Toast.makeText(RetrofitActivity.this, "Failed "+response.message(), Toast.LENGTH_LONG).show();
                    //Log.e("Error",response.message().toString());
                }
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                Toast.makeText(RetrofitActivity.this, "Failed "+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}
