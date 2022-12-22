package com.flaxeninfosoft.guptaoffset.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.flaxeninfosoft.guptaoffset.listeners.ApiResponseListener;
import com.flaxeninfosoft.guptaoffset.models.Client;
import com.flaxeninfosoft.guptaoffset.repositories.MainRepository;
import com.flaxeninfosoft.guptaoffset.utils.SharedPrefs;

import java.util.List;

public class EmployeeViewModel extends AndroidViewModel {
    private final MainRepository repo;

    private final MutableLiveData<String> toastMessage;
    private final MutableLiveData<List<Client>> employeeClientListLiveData;
    private final MutableLiveData<List<Client>> attendanceListLiveData;

    public EmployeeViewModel(@NonNull Application application, MutableLiveData<List<Client>> attendanceListLiveData) {
        super(application);
        repo = MainRepository.getInstance(application.getApplicationContext());
        this.attendanceListLiveData = attendanceListLiveData;
        toastMessage = new MutableLiveData<>();
        employeeClientListLiveData = new MutableLiveData<>();
        attendanceListLiveData = new MutableLiveData<>();

    }

    public LiveData<Boolean> fetchEmployeeClients(){
        MutableLiveData<Boolean> flag = new MutableLiveData<>();


        Long currentEmpId = getCurrentEmployeeId();
        repo.getEmployeeClients(currentEmpId, new ApiResponseListener<List<Client>, String>() {
            @Override
            public void onSuccess(List<Client> response) {
                employeeClientListLiveData.postValue(response);
                attendanceListLiveData.postValue(response);
                flag.postValue(true);
            }

            @Override
            public void onFailure(String error) {
                toastMessage.postValue(error);
                flag.postValue(false);
            }
        });

        return flag;

    }

    private Long getCurrentEmployeeId() {
        return SharedPrefs.getInstance(getApplication().getApplicationContext()).getCurrentEmployee().getId();

    }

    public LiveData<String> getToastMessageLiveData(){
        return toastMessage;
    }

    public LiveData<List<Client>> getAllClientListLiveData(){
        if (employeeClientListLiveData == null || employeeClientListLiveData.getValue().isEmpty()){
            fetchEmployeeClients();
        }
        return employeeClientListLiveData;
    }
}