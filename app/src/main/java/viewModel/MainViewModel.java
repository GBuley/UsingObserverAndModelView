package viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    private MutableLiveData<Double> _sum = new MutableLiveData<>();

    public LiveData<Double> getSum() {
        return _sum;
    }

    public void calculateSum(double num1, double num2){
        _sum.setValue(num1 + num2);
    }

}
