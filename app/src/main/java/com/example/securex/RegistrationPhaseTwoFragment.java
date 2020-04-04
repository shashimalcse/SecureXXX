package com.example.securex;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.securex.databinding.FragmentRegistrationPhaseTwoBinding;


public class RegistrationPhaseTwoFragment extends Fragment implements View.OnClickListener {

    private FragmentRegistrationPhaseTwoBinding binding;

    private NavController navController;

    public RegistrationPhaseTwoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRegistrationPhaseTwoBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        binding.phase2next.setOnClickListener(this);
        binding.phase2back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.phase2next:
                navController.navigate(R.id.action_registrationPhaseTwoFragment_to_registrationPhaseThreeFragment);
                break;
            case R.id.phase2back:
                navController.navigate(R.id.action_registrationPhaseTwoFragment_to_registrationPhaseOneFragment);
                break;
        }

    }
}
