package com.szp.mobilescrummer.data.database.task;

import android.content.Context;
import android.content.SharedPreferences;

import com.szp.mobilescrummer.Configuration;
import com.szp.mobilescrummer.data.database.ScrummerDatabase;
import com.szp.mobilescrummer.data.remote.utils.IToastCallback;
import com.szp.mobilescrummer.data.remote.utils.ScrummerRetrofitCallback;
import com.szp.mobilescrummer.data.remote.TaskRestService;
import com.szp.mobilescrummer.data.remote.dto.TaskAddDTO;
import com.szp.mobilescrummer.ui.backlog.BacklogType;

import java.util.LinkedList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TaskRepository {
    public TaskRepository(Context applicationContext, IToastCallback toastCallback) {
        this.applicationContext = applicationContext;
        this.toastCallback = toastCallback;
        this.taskDAO = ScrummerDatabase.getInstance(applicationContext).taskDAO();
    }

    private final Context applicationContext;
    private IToastCallback toastCallback;
    private final TaskDAO taskDAO;

    public void createTask(String title, String description, Long effortHours) {
        Call<Task> call = getTaskRestService().createTask(new TaskAddDTO(title, description, effortHours));
        call.enqueue(new ScrummerRetrofitCallback<Task>(toastCallback) {
            @Override
            protected void onPositiveResponse(final Task response) {
                ScrummerDatabase.databaseWriteExecutor.execute(new Runnable() {
                    @Override
                    public void run() {
                        taskDAO.insertTask(response);
                    }
                });
            }
        });
    }

    public List<Task> getTasksByBacklogType(BacklogType type) {
        switch (type) {
            case PROJECT:
                return getProjectTasks();
            case SPRINT:
                return getCurrentSprintTasks();
            case PERSONAL:
                return getPersonalTasks();
            default:
                break;
        }
        return new LinkedList<>();
    }

    private List<Task> getPersonalTasks() {
        final List<Task> result = new LinkedList<>();
        TaskRestService service = getTaskRestService();
        SharedPreferences sharedPreferences = applicationContext.getSharedPreferences(Configuration.USER_DATA_SHARED_PREFERENCES, 0);
        Call<List<Task>> call = service.getAssignedTasks(sharedPreferences.getString(Configuration.LOGGED_USER, ""));
        call.enqueue(new ScrummerRetrofitCallback<List<Task>>(toastCallback) {
            @Override
            protected void onPositiveResponse(List<Task> response) {
                result.addAll(response);
            }
        });
        return result;
    }

    private List<Task> getCurrentSprintTasks() {
        return new LinkedList<>();
    }

    private List<Task> getProjectTasks() {
        return new LinkedList<>();
    }

    private TaskRestService getTaskRestService() {
        Retrofit retrofitCall = new Retrofit.Builder()
                .baseUrl(Configuration.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofitCall.create(TaskRestService.class);
    }
}
