package com.szp.mobilescrummer.data.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.szp.mobilescrummer.data.database.task.Task;
import com.szp.mobilescrummer.data.database.task.TaskDAO;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = Task.class, exportSchema = false, version = 1)
public abstract class ScrummerDatabase extends RoomDatabase {
    private static final String DB_NAME = "scrummer_db";
    private static final int NUMBER_OF_THREADS = 4;
    private static ScrummerDatabase instance;

    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static synchronized ScrummerDatabase getInstance(Context context) {
        if (instance == null)
            instance = Room.databaseBuilder(context.getApplicationContext(), ScrummerDatabase.class, DB_NAME)
                    .fallbackToDestructiveMigration()
                    .build();

        return instance;
    }

    public abstract TaskDAO taskDAO();
}

