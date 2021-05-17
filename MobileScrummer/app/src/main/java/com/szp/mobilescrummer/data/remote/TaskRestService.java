package com.szp.mobilescrummer.data.remote;

import com.szp.mobilescrummer.data.database.task.Task;
import com.szp.mobilescrummer.data.remote.dto.TaskAddDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface TaskRestService {

    @GET("/task/getAllTasks")
    Call<List<Task>> getAllTasks();

    @GET("/task/getAssignedTasks")
    Call<List<Task>> getAssignedTasks(@Query("login") String login);

    @POST("/task/add")
    Call<Task> createTask(@Body TaskAddDTO taskAddDTO);
}
