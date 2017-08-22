package demo.exercise.pclap.mvpmodel.ui.base.presenter;

import java.util.ArrayList;
import java.util.List;

import demo.exercise.pclap.mvpmodel.ui.Action;
import demo.exercise.pclap.mvpmodel.ui.IBasePresenter;
import demo.exercise.pclap.mvpmodel.ui.IViewMain;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by PC Lap on 8/20/2017.
 */
//Base Presenter tuong tac voiw voi Main
public abstract class BasePresenter<V extends IViewMain> implements IBasePresenter {

    protected V mView;

    //Thời điểm kết nối giữa Observable và Observer được xử lý thông qua Disposable.dispose()
    private List<Disposable> disposables;

    public BasePresenter(V mView) {
        this.mView = mView;
        disposables = new ArrayList<>();
    }

    //thuc hien cac ket noi voi account api
    public <E> void interact(Observable<E> observable, final Action<E> onNext, final Action<Throwable> onError){
        observable = observable.subscribeOn(Schedulers.newThread())
                .subscribeOn(AndroidSchedulers.mainThread());
        //xem dis nao chua dc xu ly
        checkDis();
        Disposable disposable = observable.subscribe(response->{
            onNext.call(response);
        }, error->{
            onError.call(error);
        });

        disposables.add(disposable);
    }

    //check action nao  chua dc xu ly
    public void checkDis(){
        for ( int i = disposables.size()-1; i >=0 ; i-- ) {
            if (disposables.get(i).isDisposed()){
                disposables.remove(i);
            }
        }
    }

    @Override
    public void onDestroy() {
        for(Disposable disposable: disposables){
            disposable.dispose();
        }
    }
}
