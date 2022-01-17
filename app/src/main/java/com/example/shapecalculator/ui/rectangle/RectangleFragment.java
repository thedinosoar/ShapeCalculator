package com.example.shapecalculator.ui.rectangle;


import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;


import com.example.shapecalculator.MainActivity;
import com.example.shapecalculator.R;
import com.example.shapecalculator.ShapeCalculator;
import com.example.shapecalculator.databinding.FragmentRectangleBinding;

import org.xmlpull.v1.XmlPullParser;

public class RectangleFragment extends Fragment {

    private RectangleViewModel rectangleViewModel;
    private FragmentRectangleBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        rectangleViewModel =
                new ViewModelProvider(this).get(RectangleViewModel.class);

        binding = FragmentRectangleBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        //binding.txtRectangle.setText("Enter Rectangle Values");

        binding.btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShapeCalculator sc = new ShapeCalculator();
                String width = binding.etWidth.getText().toString();
                String height = binding.etHeight.getText().toString();
                if(width.length() * height.length() > 0){
                    double h = Double.parseDouble(height),w = Double.parseDouble(width);
                    Float hf = Float.parseFloat(height), wf = Float.parseFloat(width);
                    binding.txtArea.setTextColor(ContextCompat.getColor(getContext(), R.color.txt_color));
                    binding.txtPerimeter.setTextColor(ContextCompat.getColor(getContext(), R.color.txt_color));
                    binding.txtArea.setText("Area is "+Double.toString(sc.RectangleArea(w, h)));
                    binding.txtPerimeter.setText("Perimeter is "+Double.toString(sc.RectanglePerimeter(w, h)));
                    binding.imgRect.setScaleX(Math.min(wf/hf,6));
                    binding.imgRect.setScaleY((w/h>6)?(12*hf/wf):2);
                }else{
                    binding.txtArea.setTextColor(Color.RED);
                    binding.txtArea.setText("Please Input Width and Height");
                    binding.txtPerimeter.setText("");
                    binding.imgRect.setScaleX(0);
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