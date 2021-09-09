package my.edu.tarc.myqrcode

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.zxing.integration.android.IntentIntegrator
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnScan : Button = findViewById<Button>(R.id.btnQRCode)

        btnScan.setOnClickListener(){
            //integrate the camera with main activity
            val scanner = IntentIntegrator(this)
            //open camera
            scanner.initiateScan()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)

        if(result != null){
            val obj = JSONObject(result.contents)

            //findViewById<TextView>(R.id.tvResult).text = result.contents
            findViewById<TextView>(R.id.tvResult).text = obj.getString("description")
        }


    }
}