package com.szp.mobilescrummer.ui.taskCreator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.textfield.TextInputEditText;
import com.szp.mobilescrummer.R;
import com.szp.mobilescrummer.utils.Strings;

public class TaskCreatorActivity extends AppCompatActivity {

    private TextInputEditText titleField;
    private TextInputEditText descriptionField;
    private TextInputEditText effortHoursField;

    private Button submitButton;
    private ImageButton backButton;

    private TaskCreatorViewModel taskCreatorViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_creator);

        initView();
        setView();
    }

    private void initView() {
        titleField = findViewById(R.id.activity_task_creator_text_field_title);
        descriptionField = findViewById(R.id.activity_task_creator_text_field_description);
        effortHoursField = findViewById(R.id.activity_task_creator_text_field_effort_hours);
        submitButton = findViewById(R.id.activity_task_creator_submit_button);
        backButton = findViewById(R.id.activity_task_creator_back_button);
    }

    private void setView() {
        taskCreatorViewModel = new ViewModelProvider(this).get(TaskCreatorViewModel.class);

        taskCreatorViewModel.getTitleErrorMessage().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer message) {
                if (message != null && message != 0) {
                    titleField.setError(TaskCreatorActivity.this.getResources().getString(message));
                }
            }
        });

        taskCreatorViewModel.getDescriptionErrorMessage().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer message) {
                if (message != null && message != 0) {
                    descriptionField.setError(TaskCreatorActivity.this.getResources().getString(message));
                }
            }
        });

        taskCreatorViewModel.getEffortHoursErrorMessage().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer message) {
                if (message != null && message != 0) {
                    effortHoursField.setError(TaskCreatorActivity.this.getResources().getString(message));
                }
            }
        });

        taskCreatorViewModel.getToastMessage().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer message) {
                if (message != null && message != 0) {
                    Toast.makeText(TaskCreatorActivity.this, message, Toast.LENGTH_SHORT).show();
                }
            }
        });

        setButtonListeners();
    }

    private void setButtonListeners() {
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = titleField.getText().toString();
                String description = descriptionField.getText().toString();
                String effortString = effortHoursField.getText().toString();
                Long effortHours = Strings.isEmptyOrNull(effortString) ? null : Long.parseLong(effortString);
                taskCreatorViewModel.tryToCreateTask(title, description, effortHours);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
