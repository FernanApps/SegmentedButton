package fernan.apps.test

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.to_java).setOnClickListener {
            startActivity(Intent(this, SegmentedButtonJava::class.java))
        }

        findViewById<Button>(R.id.to_kotlin).setOnClickListener {
            startActivity(Intent(this, SegmentedButtonKotlin::class.java))

        }
    }

}