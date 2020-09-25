package com.morschgartner.nac2semestre

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.morschgartner.nac2semestre.fragments.CautionFragment
import com.morschgartner.nac2semestre.fragments.EnterAppFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Referencia do fragment
        val enterAppFragment = EnterAppFragment()
        val cautionFragment = CautionFragment()

        changeFragmentPresented(enterAppFragment, false)

        btSecret.setOnClickListener {
            changeFragmentPresented(cautionFragment, true)
        }

    }

    private fun changeFragmentPresented(frag:Fragment, addToBack:Boolean){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, frag)
            if (addToBack)
                addToBackStack(null)
            commit()
        }
    }
}