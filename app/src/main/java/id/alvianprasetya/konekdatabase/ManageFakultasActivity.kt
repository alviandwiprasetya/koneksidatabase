@file:Suppress("DEPRECATION")

package id.alvianprasetya.konekdatabase


import android.app.Application
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import kotlinx.android.synthetic.main.activity_manage_fakultas.*
import org.json.JSONObject

class  ManageFakultasActivity : AppCompatActivity() {
    lateinit var i: Intent
    lateinit var add:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manage_fakultas)

        add = findViewById(R.id.btnCreate)
        i = intent
        if(i.hasExtra("editmode").equals("1")) {
            onEditMode()

        }
    }
    add.setOnClikListener  {
        onCreate()
    }
}

private fun onEditMode() {
    TODO("not implemented") //To change body of created functions use File | Settings | FIle Templates.
    txt_kodefakultas.setText (i.getStringExtra("txt_kodefakultas"))
    txt_namafakultas.setText(i.getStringExtra ("txt_namafakultas"))

    btnCreate.visibility = View.GONE
    btnUpdate.visibility = View.VISIBLE
    btnDelete.visibility = View.VISIBLE
}

private fun onCreate() {

    val loading = ProgressDialog(this)
    loading.setMessage("Menambahkan data....")
    loading .show()

    AndroidNetworking.post (ApiEndPoint.CREATE)
        .addBodyParameter ("kodefakultas",txt_kodefakultas.text.toString())
        .addBodyParameter ("namafakultas",txt_namafakultas.text.tosTRING())
        .setPriority(Priority.MEDIUM)
        .build()
        .getAsJSONobject(object : JSONObject(object : JSONObjectRequestListener {
            override fun onResponse(response: JSONObject?) {
                loading.dismiss()
                Toast.makeText(ApplicationContext.response?.getString("message"),Toast.LENGTH_SHORT).show
                if (response?.getString("message")?.contains("succesfully)!!))

            }
        }
                override fun  onError(anError: ANError?) {
            loading.dismiss()
            Log.d("ONEERROR", anError?.errorDetail?.toString())
            Toast,makeText(applicationContext."ConnectionFailure",Toast.LENGHT_SHORT) .show()
        }
})
}
}