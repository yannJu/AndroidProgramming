package service

import com.example.imagesearch.data.Images
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface KakaoImageSeachService {
    @Headers("Authorization: KakaoAK 6acc3abf203ac6b3b5901880bd14d69e") // 카카오에서 발급받은 key
    @GET("/v2/search/image")
    fun requestSearchImage(
        @Query("query") keyword: String,
        @Query("sort") sort: String = "recency",
        @Query("page") page: Int,
        @Query("size") size: Int = 10
    ): Call<Images>
}

// singleton 객체
// 생성자 호출 -> 단 한개의 인스턴스만 만들 수 있다.
object KakaoImageSearch {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://dapi.kakao.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    // interface 를 자동으로 구현해달라 - 라는 의미
//    fun getService(): KakaoImageSeachService = retrofit.create(KakaoImageSeachService::class.java)
    val service get() = retrofit.create((KakaoImageSeachService::class.java)) //위와 동일한 구문
}