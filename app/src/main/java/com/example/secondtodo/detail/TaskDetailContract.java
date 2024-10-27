package com.example.secondtodo.detail;


import com.example.secondtodo.BasePresenter;
import com.example.secondtodo.BaseView;
import com.example.secondtodo.model.Task;

public interface TaskDetailContract {

    interface View extends BaseView {
        void showTask(Task task);

        void setDeleteButtonVisibility(boolean visible);

        void showError(String error);

        void returnResult(int resultCode, Task task);
    }

    interface Presenter extends BasePresenter<View> {
        void deleteTask();

        void saveChanges(int importance, String title);

    }
}
