package com.example.securex.viewmodel;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.securex.data.User;
import com.example.securex.data.UserRepository;

public class RegistrationSharedViewModel  extends ViewModel {

    private MutableLiveData<String> Username = new MutableLiveData<>();
    private MutableLiveData<String> Email = new MutableLiveData<>();
    private MutableLiveData<String> Color = new MutableLiveData<>();
    private MutableLiveData<String> Pin = new MutableLiveData<>();
    private MutableLiveData<Integer> Size = new MutableLiveData<>();
    private MutableLiveData<String> Password = new MutableLiveData<>();

    public void setUsername(String username){
        Username.setValue(username);
    }
    public void setEmail(String email){
        Email.setValue(email);
    }
    public void setColor(String color){
        Color.setValue(color);
    }
    public void setPIN(String pin){
        Pin.setValue(pin);
    }
    public void setPassword(String password){
        Password.setValue(password);
    }
    public void setSize(Integer size){
        Size.setValue(size);
    }


    public LiveData<String> getUsername(){
        return Username;
    }
    public LiveData<String> getEmail(){
        return Email;
    }
    public LiveData<String> getColor(){
        return Color;
    }
    public LiveData<String> getPin(){
        return Pin;
    }
    public LiveData<String> getPassword(){
        return Password;
    }
    public LiveData<Integer> getSize(){
        return Size;
    }




    public void saveUser(Context context){
        UserRepository userRepository = new UserRepository(context);
        if (getUsername().getValue().toString().equals("")){
            Log.d("USER","FUCKED");
        }
        User user = new User(getUsername().getValue().toString(),getEmail().getValue().toString(),getColor().getValue().toString(),getPin().getValue().toString(),Integer.parseInt(getSize().getValue().toString()),getPassword().getValue().toString());
        userRepository.saveUser(user);
    }
}
