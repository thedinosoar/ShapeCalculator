package com.example.shapecalculator.ui.circle;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.shapecalculator.R;
import com.example.shapecalculator.ShapeCalculator;
import com.example.shapecalculator.databinding.FragmentCircleBinding;

import java.util.Objects;

public class CircleFragment extends Fragment {

    private CircleViewModel circleViewModel;
    private FragmentCircleBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        circleViewModel =
                new ViewModelProvider(this).get(CircleViewModel.class);

        binding = FragmentCircleBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.btnCalculateCirc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShapeCalculator sc = new ShapeCalculator();
                String radius = binding.etRadius.getText().toString();
                if(radius.length() > 0){
                    double r = Double.parseDouble(radius);
                    binding.txtAreaCirc.setTextColor(ContextCompat.getColor(requireContext(), R.color.txt_color));
                    binding.txtPerimeterCirc.setTextColor(ContextCompat.getColor(requireContext(), R.color.txt_color));
                    binding.txtAreaCirc.setText("Area is "+Double.toString(sc.CircleArea(r)));
                    binding.txtPerimeterCirc.setText("Perimeter is "+Double.toString(sc.CirclePerimeter(r)));
                    float scale = Math.min(((float) r/40) +.2f,1);
                    binding.imgCirc.setScaleX(scale);
                    binding.imgCirc.setScaleY(scale);
                }else{
                    binding.txtAreaCirc.setTextColor(Color.RED);
                    binding.txtAreaCirc.setText("Please Input a Radius");
                    binding.txtPerimeterCirc.setText("");
                    binding.imgCirc.setScaleY(0);
                }
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}