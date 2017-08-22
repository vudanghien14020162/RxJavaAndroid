package demo.exercise.pclap.mvpmodel.ui.main;

import android.support.v4.app.FragmentManager;

import demo.exercise.pclap.mvpmodel.R;
import demo.exercise.pclap.mvpmodel.ui.base.activity.BaseActivity;
import demo.exercise.pclap.mvpmodel.ui.base.animation.ScreenAnimation;
import demo.exercise.pclap.mvpmodel.ui.base.fragment.BaseFragment;
import demo.exercise.pclap.mvpmodel.ui.main.music.ListMusicFragment;

public class MainActivity extends BaseActivity {
    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void findViewByIds() {

    }

    @Override
    public void initComponents() {
        FragmentManager manager = getSupportFragmentManager();
        BaseFragment.
                openFragment(manager,
                        manager.beginTransaction(),
                        ListMusicFragment.class,
                        ScreenAnimation.OPEN_FULL, null, false, false);
    }

    @Override
    public void setEvents() {

    }
}
