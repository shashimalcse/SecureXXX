package com.example.securex.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PasswordUpdateSharedViewModel extends ViewModel {


    private MutableLiveData<String> Color = new MutableLiveData<>();
    private MutableLiveData<Integer> Size = new MutableLiveData<>();
    private MutableLiveData<String> Password = new MutableLiveData<>();


    public void setColor(String color){
        Color.setValue(color);
    }
    public void setPassword(String password){
        Password.setValue(password);
    }
    public void setSize(Integer size){
        Size.setValue(size);
    }



    public LiveData<String> getColor(){
        return Color;
    }
    public LiveData<String> getPassword(){
        return Password;
    }
    public LiveData<Integer> getSize(){
        return Size;
    }





}
