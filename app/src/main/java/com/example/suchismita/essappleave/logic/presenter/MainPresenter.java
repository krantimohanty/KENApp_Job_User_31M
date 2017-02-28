package com.example.suchismita.essappleave.logic.presenter;

import android.support.annotation.Nullable;

import com.example.suchismita.essappleave.logic.presenter_view.MainView;


public final class MainPresenter {

    @Nullable
    private MainView view;

    public MainPresenter(@Nullable MainView view) {
        this.view = view;
    }

//    public void addNavigationDrawer() {
//        if (null != getView()) {
//            getView().prepareNavigationDrawer();
//        }
//    }

    public void addListView() {
        if (null != getView()) {
            getView().prepareListView();
        }
    }

    public void addCalendarView() {
        if (null != getView()) {
            getView().prepareCalendarView();
        }
    }

    public void animate() {
        if (null != getView()) {
            getView().animateViews();
        }
    }

    public void detachView() {
        this.view = null;
    }

    @Nullable
    public MainView getView() {
        return view;
    }
}
