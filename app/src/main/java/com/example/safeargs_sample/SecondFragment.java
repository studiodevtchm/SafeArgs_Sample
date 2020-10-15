package com.example.safeargs_sample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.safeargs_sample.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    int arg1;
    String arg2;
    Student arg3;
    Weeks arg4;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        SecondFragmentArgs args = SecondFragmentArgs.fromBundle(getArguments());
        arg1 = args.getMyarg1();      // <= 5
        arg2 = args.getMyarg2();
        arg3 = args.getMyarg3();
        arg4 = args.getMyarg4();


        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Toast.makeText(view.getContext(), "Passed Values: " + arg1 + "  " + arg2, Toast.LENGTH_LONG).show();

        Toast.makeText(view.getContext(), "Student data: " + arg3.name + "  " + arg3.age, Toast.LENGTH_LONG).show();

        Toast.makeText(view.getContext(), "Enum value: " + arg4, Toast.LENGTH_LONG).show();

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}