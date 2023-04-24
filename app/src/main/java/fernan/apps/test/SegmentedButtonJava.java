package fernan.apps.test;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import fernan.apps.segmented.SegmentedButton;

public class SegmentedButtonJava extends AppCompatActivity {

    private SegmentedButton segmentedButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segmented_button);
        initViews();
        initActions();
    }

    private void initViews(){
        segmentedButton = findViewById(R.id.segmented_button);
    }
    private void initActions(){
        segmentedButton.setListener(new SegmentedButton.SegmentedListen() {
            @Override
            public void onSelected(@NonNull String nameItem) {
                Log.d("ITEM", nameItem);
            }
        });
    }
}
