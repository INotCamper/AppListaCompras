package com.morschgartner.nac2semestre.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.morschgartner.nac2semestre.ListActivity
import com.morschgartner.nac2semestre.R


class EnterAppFragment : Fragment(R.layout.fragment_enter_app) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = super.onCreateView(inflater, container, savedInstanceState)
        val bt = v?.findViewById<Button>(R.id.btNext)
        bt?.setOnClickListener {
            val intent = Intent(activity, ListActivity::class.java)
            startActivity(intent)
        }
        return v
    }
}