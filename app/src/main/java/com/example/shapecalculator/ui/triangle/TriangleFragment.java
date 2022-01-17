package com.example.shapecalculator.ui.triangle;

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
import com.example.shapecalculator.databinding.FragmentTriangleBinding;

public class TriangleFragment extends Fragment {

    private TriangleViewModel triangleViewModel;
    private FragmentTriangleBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        triangleViewModel =
                new ViewModelProvider(this).get(TriangleViewModel.class);

        binding = FragmentTriangleBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.btnCalculateTri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShapeCalculator sc = new ShapeCalculator();
                String width = binding.etWidthTri.getText().toString();
                String height = binding.etHeightTri.getText().toString();
                if(width.length() * height.length() > 0){
                    double h = Double.parseDouble(height),w = Double.parseDouble(width);
                    binding.txtAreaTri.setTextColor(ContextCompat.getColor(getContext(), R.color.txt_color));
                    binding.txtPerimeterTri.setTextColor(ContextCompat.getColor(getContext(), R.color.txt_color));
                    binding.txtAreaTri.setText("Area is "+Double.toString(sc.TriangleArea(w, h)));
                    binding.txtPerimeterTri.setText("Perimeter is "+Double.toString(sc.TrianglePerimeter(w, h)));
                    binding.imgTri.setScaleX(Float.parseFloat(Double.toString(w/h)));
                }else{
                    binding.txtAreaTri.setTextColor(Color.RED);
                    binding.txtAreaTri.setText("Please Input Width and Height");
                    binding.txtPerimeterTri.setText("");
                    binding.imgTri.setScaleX(0);
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