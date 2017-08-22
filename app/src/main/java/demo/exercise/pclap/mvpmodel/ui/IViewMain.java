package demo.exercise.pclap.mvpmodel.ui;

import android.support.annotation.StringRes;

/**
 * Created by PC Lap on 8/20/2017.
 */
public interface IViewMain {
    int getLayout();
    void findViewByIds();
    void initComponents();
    void setEvents();
    void showProgress();
    void hideProgress();
    void showMess(String msg);
    void showMess(@StringRes int msg);

}
