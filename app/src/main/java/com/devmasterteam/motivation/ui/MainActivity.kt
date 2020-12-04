package com.devmasterteam.motivation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.devmasterteam.motivation.R
import com.devmasterteam.motivation.infra.MotivationConstants
import com.devmasterteam.motivation.infra.SecurityPreferences
import com.devmasterteam.motivation.repository.Mock
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mSecurityPreferences: SecurityPreferences
    private var mphrasefilter: Int = MotivationConstants.PHRASEFILTER.ALL

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(supportActionBar != null)
            supportActionBar!!.hide()


        mSecurityPreferences = SecurityPreferences(  this)
        val name = mSecurityPreferences.getString(MotivationConstants.KEY.PERSON_NAME)
        text_main.text = "Olá, $name"

        button_save.setOnClickListener(this)
        imgall.setOnClickListener(this)
        imghappy.setOnClickListener(this)
        imgsun.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        val id = v.id

        val listFilter = listOf(R.id.imgall, R.id.imghappy, R.id.imgsun)

        if(id == R.id.button_save)
            NovaFrase()
        else if (id in listFilter)
            Frases(id)
    }

    private fun Frases(id: Int){
        imgall.setColorFilter(resources.getColor(R.color.white))
        imghappy.setColorFilter(resources.getColor(R.color.white))
        imgsun.setColorFilter(resources.getColor(R.color.white))

        when(id){
            R.id.imgall->{
                imgall.setColorFilter(resources.getColor(R.color.colorAccent))
                mphrasefilter = MotivationConstants.PHRASEFILTER.ALL
            }
            R.id.imghappy->{
                imghappy.setColorFilter(resources.getColor(R.color.colorAccent))
                mphrasefilter = MotivationConstants.PHRASEFILTER.HAPPY
            }
            R.id.imgsun->{
                imgsun.setColorFilter(resources.getColor(R.color.colorAccent))
                mphrasefilter = MotivationConstants.PHRASEFILTER.MORNING
            }
        }
    }

    private fun NovaFrase(){
        frase_main.text = Mock().getPhrase(mphrasefilter)
    }
}