package com.github.data;

import com.github.models.GitHubModel;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.GET;

public interface GitHubApi {
    @GET("/repositories")
    Single<Response<List<GitHubModel>>> getTopGitHubItems();
}
