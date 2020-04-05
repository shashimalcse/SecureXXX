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

import com.example.securex.databinding.FragmentRegistrationPhaseFiveBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegistrationPhaseFiveFragment extends Fragment implements View.OnClickListener {

    private FragmentRegistrationPhaseFiveBinding binding;
    private NavController navController;

    public RegistrationPhaseFiveFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRegistrationPhaseFiveBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        return view;
  }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        binding.phase5next.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.phase5next:
                navController.navigate(R.id.action_registrationPhaseFiveFragment_to_registrationPhaseSixFragment);
                break;

        }
    }
}
