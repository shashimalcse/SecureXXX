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

import com.example.securex.databinding.FragmentRegistrationPhaseSixBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegistrationPhaseSixFragment extends Fragment implements View.OnClickListener {

    private FragmentRegistrationPhaseSixBinding binding;
    private NavController navController;

    public RegistrationPhaseSixFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRegistrationPhaseSixBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        return view;
           }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        binding.phase6confirm.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.phase6confirm:

        }
    }
}
