package com.szp.mobilescrummer.ui.backlog;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.szp.mobilescrummer.data.database.task.Task;
import com.szp.mobilescrummer.data.database.task.TaskRepository;
import com.szp.mobilescrummer.data.remote.utils.IToastCallback;
import com.szp.mobilescrummer.utils.ScrummerViewModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BacklogViewModel extends ScrummerViewModel {
    public BacklogViewModel(@NonNull Application application) {
        super(application);
        backlogs.setValue(new HashMap<BacklogType, List<Task>>());
        this.taskRepository = new TaskRepository(application.getApplicationContext(), new IToastCallback() {
            @Override
            public void makeToast(Integer message) {
                displayToastMessage(message);
            }
        });
    }

    private TaskRepository taskRepository;

    private MutableLiveData<Map<BacklogType, List<Task>>> backlogs = new MutableLiveData<>();

    public void loadBacklogs(List<BacklogType> types) {
        for (BacklogType type: types) {
            loadBacklogByType(type);
        }
    }

    private void loadBacklogByType(BacklogType type) {
        Map<BacklogType, List<Task>> backlogsMap = backlogs.getValue();
        if (backlogsMap == null)
            backlogsMap = new HashMap<>();

        List<Task> tasks = taskRepository.getTasksByBacklogType(type);

        if (backlogsMap.containsKey(type)) {
            backlogsMap.replace(type, tasks);
        } else {
            backlogsMap.put(type, tasks);
        }

        backlogs.setValue(backlogsMap);
    }

}
