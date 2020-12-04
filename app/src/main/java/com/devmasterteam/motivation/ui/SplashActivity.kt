package com.devmasterteam.motivation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.devmasterteam.motivation.R
import com.devmasterteam.motivation.infra.MotivationConstants
import com.devmasterteam.motivation.infra.SecurityPreferences
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity(), View.OnClickListener  {

    private lateinit var mSecurityPreferences: SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        mSecurityPreferences = SecurityPreferences(this)

        if(supportActionBar != null){
            supportActionBar!!.hide()
        }
        button_save.setOnClickListener(this)
        VerifyName()

        val SecurityPreferences = SecurityPreferences(  this)
        SecurityPreferences.StoreString("", "")
    }


    override fun onClick(v: View) {
        val id = v.id
        if(id == R.id.button_save){
            CallPage()
        }
    }
    private fun VerifyName() {
        val name = mSecurityPreferences.getString(MotivationConstants.KEY.PERSON_NAME)
        if(name != ""){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun CallPage(){
        val name = enter_name.text.toString()

        if(name != ""){
            mSecurityPreferences.StoreString("name", name)
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }else
            Toast.makeText(this, "Por Favor Insira um Nome!", Toast.LENGTH_SHORT).show()
    }


}