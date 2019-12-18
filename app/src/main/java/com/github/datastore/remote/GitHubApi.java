package com.github.datastore.remote;

import com.github.models.GitHubModel;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface GitHubApi {

    @GET("/repositories")
    Single<Response<List<GitHubModel>>> getTopGitHubItems();




}
