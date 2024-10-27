package com.example.secondtodo;

public interface BasePresenter<T extends BaseView> {
    void onAttach(T view);

    void onDetach();
}
