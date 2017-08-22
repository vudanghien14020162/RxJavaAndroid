package demo.exercise.pclap.mvpmodel.ui.base.fragment;

import demo.exercise.pclap.mvpmodel.ui.IBasePresenter;

/**
 * Created by PC Lap on 8/21/2017.
 */
//create BaseFragment tuong tac voi Presnter
public abstract class BaseMVPFragment<P extends IBasePresenter> extends BaseFragment {

    protected P mPresenter;
    @Override
    public void onDestroyView() {
        if(mPresenter != null){
            mPresenter.onDestroy();
        }
        super.onDestroyView();
    }
}
