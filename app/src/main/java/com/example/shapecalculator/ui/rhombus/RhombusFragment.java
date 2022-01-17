package com.example.shapecalculator.ui.rhombus;

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
import com.example.shapecalculator.databinding.FragmentRhombusBinding;

public class RhombusFragment extends Fragment {

    private RhombusViewModel notificationsViewModel;
    private FragmentRhombusBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                new ViewModelProvider(this).get(RhombusViewModel.class);

        binding = FragmentRhombusBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.btnCalculateRhom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShapeCalculator sc = new ShapeCalculator();
                String width = binding.etWidthRhom.getText().toString();
                String height = binding.etHeightRhom.getText().toString();
                if(width.length() * height.length() > 0){
                    double h = Double.parseDouble(height),w = Double.parseDouble(width);
                    binding.txtAreaRhom.setTextColor(ContextCompat.getColor(getContext(), R.color.txt_color));
                    binding.txtPerimeterRhom.setTextColor(ContextCompat.getColor(getContext(), R.color.txt_color));
                    binding.txtAreaRhom.setText("Area is "+Double.toString(sc.RhombusArea(w, h)));
                    binding.txtPerimeterRhom.setText("Perimeter is "+Double.toString(sc.RhombusPerimeter(w, h)));
                    binding.imgRhom.setScaleX(Float.parseFloat(Double.toString(w/h)));


                }else{
                    binding.txtAreaRhom.setTextColor(Color.RED);
                    binding.txtAreaRhom.setText("Please Input Width and Height");
                    binding.txtPerimeterRhom.setText("");
                    binding.imgRhom.setScaleX(0);
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