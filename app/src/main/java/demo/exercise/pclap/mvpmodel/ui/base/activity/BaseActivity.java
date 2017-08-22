package demo.exercise.pclap.mvpmodel.ui.base.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import demo.exercise.pclap.mvpmodel.R;
import demo.exercise.pclap.mvpmodel.ui.IViewMain;

/**
 * Created by PC Lap on 8/20/2017.
 */
public abstract class BaseActivity extends AppCompatActivity implements IViewMain {
    private ProgressDialog mProgress;
    protected boolean mIsDestroy;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        mIsDestroy = false;
        mProgress = new ProgressDialog(this);
        mProgress.setMessage(getResources().getString(R.string.Loading));
        findViewByIds();
        initComponents();
        setEvents();
    }

    @Override
    public void showProgress() {
        if(mIsDestroy){
            return;
        }
        mProgress.show();
    }

    @Override
    public void hideProgress() {
        if(mIsDestroy){
            return;
        }
        if(!mProgress.isShowing()){
            return;
        }
        mProgress.hide();
    }

    @Override
    public void showMess(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showMess(@StringRes int msg) {
        Toast.makeText(BaseActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        mIsDestroy = true;
        super.onDestroy();
    }
}
