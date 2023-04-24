package fernan.apps.test

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import fernan.apps.segmented.SegmentedButton


class SegmentedButtonKotlin : AppCompatActivity() {

    private lateinit var segmentedButton: SegmentedButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segmented_button)

        initViews()
        initActions()

    }
    private fun initViews(){
        segmentedButton = findViewById(R.id.segmented_button)
    }
    private fun initActions(){
        segmentedButton.setListener(object: SegmentedButton.SegmentedListen{
            override fun onSelected(nameItem: String) {
                Log.d("ITEM", nameItem)
            }

        })
    }





}




