package com.ashish.visualizeds.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.widget.Toast;

import com.ashish.visualizeds.R;
import com.ashish.visualizeds.classes.DataStructureAlgorithm;
import com.ashish.visualizeds.classes.DataStructureAlgorithmContent;
import com.ashish.visualizeds.databinding.ActivityDataStructureAlgorithmTheoryBinding;

public class DataStructureAlgorithmTheoryActivity extends AppCompatActivity {

    private ActivityDataStructureAlgorithmTheoryBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDataStructureAlgorithmTheoryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DataStructureAlgorithm dataStructureAlgorithm = (DataStructureAlgorithm) getIntent().getSerializableExtra("data");
        if (dataStructureAlgorithm.getIcon() != null)
            binding.iconImageView.setImageResource(dataStructureAlgorithm.getIcon());
        binding.titleTextView.setText(dataStructureAlgorithm.getName());
        binding.difficultyTextView.setText(dataStructureAlgorithm.getDifficulty().toString());


        DataStructureAlgorithmContent dataStructureAlgorithmContent = dataStructureAlgorithm.getDataStructureAlgorithmContent();
        binding.theoryTextView.setText(dataStructureAlgorithmContent.getTheory());
        binding.algorithmTextView.setText(dataStructureAlgorithmContent.getAlgorithm());
        binding.codeTextView.setText(dataStructureAlgorithmContent.getCode());
        binding.worstCaseComplexityTextView.setText(formatTimeComplexity(dataStructureAlgorithmContent.getWorstCase()));
        binding.averageCaseComplexityTextView.setText(formatTimeComplexity(dataStructureAlgorithmContent.getAverageCase()));
        binding.bestCaseComplexityTextView.setText(formatTimeComplexity(dataStructureAlgorithmContent.getBestCase()));

        binding.visualizeBtn.setOnClickListener(v -> {
            if (dataStructureAlgorithm.getVisualizeClass() == null) {
                Toast.makeText(this, getString(R.string.missing_visualize_class), Toast.LENGTH_SHORT).show();
                return;
            }
            Intent intent = new Intent(getApplicationContext(), dataStructureAlgorithm.getVisualizeClass());
            intent.putExtra("data", dataStructureAlgorithm);
            startActivity(intent);
            finish();
        });
    }

    Spanned formatTimeComplexity(String s) {
        return Html.fromHtml(String.format("O(%s)", s));
    }
}