package com.szp.mobilescrummer.ui.taskCreator;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.szp.mobilescrummer.R;
import com.szp.mobilescrummer.data.database.task.TaskRepository;
import com.szp.mobilescrummer.data.remote.utils.IToastCallback;
import com.szp.mobilescrummer.utils.ScrummerViewModel;
import com.szp.mobilescrummer.utils.Strings;

public class TaskCreatorViewModel extends ScrummerViewModel {
    public TaskCreatorViewModel(@NonNull Application application) {
        super(application);
        taskRepository = new TaskRepository(application.getApplicationContext(), new IToastCallback() {
            @Override
            public void makeToast(Integer message) {
                displayToastMessage(message);
            }
        });
    }
    private TaskRepository taskRepository;

    private MutableLiveData<Integer> titleErrorMessage = new MutableLiveData<>();
    private MutableLiveData<Integer> descriptionErrorMessage = new MutableLiveData<>();
    private MutableLiveData<Integer> effortHoursErrorMessage = new MutableLiveData<>();

    public void tryToCreateTask(String title, String description, Long effortHours) {
        if (!valid(title, description, effortHours)) {
            displayToastMessage(R.string.activity_task_creator_failure_message);
            return;
        }

        taskRepository.createTask(title, description, effortHours);
    }

    private boolean valid(String title, String description, Long effortHours) {
        boolean valid = true;
        if (Strings.isEmptyOrNull(title)) {
            titleErrorMessage.setValue(R.string.activity_task_creator_text_field_title_error_message);
            valid = false;
        }

        if (Strings.isEmptyOrNull(description)) {
            descriptionErrorMessage.setValue(R.string.activity_task_creator_text_field_description_error_message);
            valid = false;
        }

        if (effortHours == null || effortHours < 0) {
            effortHoursErrorMessage.setValue(R.string.activity_task_creator_text_field_effort_hours_error_message);
            valid = false;
        }

        return valid;
    }

    public MutableLiveData<Integer> getTitleErrorMessage() {
        return titleErrorMessage;
    }

    public MutableLiveData<Integer> getDescriptionErrorMessage() {
        return descriptionErrorMessage;
    }

    public MutableLiveData<Integer> getEffortHoursErrorMessage() {
        return effortHoursErrorMessage;
    }
}
