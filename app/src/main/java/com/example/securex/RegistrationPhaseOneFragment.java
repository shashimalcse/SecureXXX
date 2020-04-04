package com.example.securex;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.securex.databinding.FragmentRegistrationPhaseOneBinding;


public class RegistrationPhaseOneFragment extends Fragment implements View.OnClickListener {

    private FragmentRegistrationPhaseOneBinding binding;

    private NavController navController;

    public RegistrationPhaseOneFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRegistrationPhaseOneBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        return view;
   }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);

        binding.phase1next.setOnClickListener(this);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.phase1next:
                navController.navigate(R.id.action_registrationPhaseOneFragment_to_registrationPhaseTwoFragment);
                break;
        }
    }
}
