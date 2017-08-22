package demo.exercise.pclap.mvpmodel.ui.base.presenter;

import demo.exercise.pclap.mvpmodel.ui.IBasePresenter;
import demo.exercise.pclap.mvpmodel.ui.IViewMain;

/**
 * Created by PC Lap on 8/21/2017.
 */
public abstract class BaseMVPPresenter<V extends IViewMain> implements IBasePresenter {
    protected V mView;


}
