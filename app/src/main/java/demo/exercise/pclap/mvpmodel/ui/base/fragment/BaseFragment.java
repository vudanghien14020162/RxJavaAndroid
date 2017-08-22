package demo.exercise.pclap.mvpmodel.ui.base.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import demo.exercise.pclap.mvpmodel.R;
import demo.exercise.pclap.mvpmodel.ui.IViewMain;
import demo.exercise.pclap.mvpmodel.ui.base.activity.BaseActivity;
import demo.exercise.pclap.mvpmodel.ui.base.animation.ScreenAnimation;

/**
 * Created by PC Lap on 8/20/2017.
 */
public abstract class BaseFragment extends Fragment implements IViewMain {
    private boolean mIsDestroy;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mIsDestroy = false;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(), container, false);
        return view;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        findViewByIds();
        initComponents();
        setEvents();
    }

    public BaseActivity getMainActivity(){
        BaseActivity baseActivity = (BaseActivity) getActivity();
        return baseActivity;
    }

    @Override
    public void showProgress() {
        if(mIsDestroy){
            return;
        }
        getMainActivity().showProgress();
    }

    @Override
    public void hideProgress() {
        if(mIsDestroy){
            return;
        }

        getMainActivity().hideProgress();
    }

    public static void openFragment(FragmentManager manager,
                                    FragmentTransaction transaction,
                                    Class<? extends BaseFragment> className,
                                    ScreenAnimation animation,
                                    Bundle bundle,
                                    boolean isAddBackStack,
                                    boolean isCommit){
        String tag = className.getName().toString();
        BaseFragment fragment = (BaseFragment) manager.findFragmentByTag(tag);
        if(fragment == null){
            try {
                fragment = className.newInstance();
                fragment.setArguments(bundle);
                transaction.setCustomAnimations(animation.getEnter_left_to_right(),
                        animation.getExit_left_to_right(),
                        animation.getEnter_right_to_left(),
                        animation.getExit_right_to_left());
                transaction.add(R.id.fr_content, fragment, tag);

            } catch (java.lang.InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }else {
            //neu co roi thi kiem tra xem no co dang hien thi hay khong
            if(fragment.isVisible()){
                return;
            }

            //co trong do roi thi khpng can add them
            transaction.setCustomAnimations(animation.getEnter_left_to_right(),
                                            animation.getExit_left_to_right(),
                                            animation.getEnter_right_to_left(),
                                            animation.getExit_right_to_left());
            //hien th fragment
            transaction.show(fragment);
        }

        if(!isAddBackStack){
            transaction.addToBackStack(tag);
        }
        if(!isCommit){
            transaction.commit();
        }
    }

    public static void closeFragment(FragmentManager manager,
                                     FragmentTransaction transaction,
                                     Class<? extends BaseFragment> className,
                                     ScreenAnimation animation,
                                     boolean isAddBackStack,
                                     boolean isCommit){
        String tag = className.getName().toString();
        BaseFragment baseFragment = (BaseFragment) manager.findFragmentByTag(tag);

        if(baseFragment != null && baseFragment.isVisible()){
            transaction.setCustomAnimations(animation.getEnter_right_to_left(),
                                            animation.getExit_right_to_left(),
                                            animation.getEnter_left_to_right(),
                                            animation.getExit_left_to_right());
            if(!isAddBackStack){
                transaction.addToBackStack(tag);
            }
            if(!isCommit){
                transaction.commit();
            }
        }
    }

    @Override
    public void showMess(String msg) {
        Toast.makeText(getMainActivity(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showMess(@StringRes int msg) {
        Toast.makeText(getMainActivity(), msg, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onDestroyView() {
        mIsDestroy = true;
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        mIsDestroy = true;
        super.onDestroy();
    }
}
