package demo.exercise.pclap.mvpmodel.ui;

/**
 * Created by PC Lap on 8/22/2017.
 */
//vi khong biet goi den hoat dong nao nen se de la template action can goi
public interface Action<A> {
    void call(A a);
}
