package com.app.covidwelness.ui

import android.app.Activity
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import com.app.covidwelness.databinding.ActivityHomeBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder


class HomeActivity : Activity(), View.OnClickListener {

    private lateinit var binding: ActivityHomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding?.buttonCondition1.setOnClickListener(this)
        binding?.buttonCondition2.setOnClickListener(this)
        binding?.buttonCondition3.setOnClickListener(this)
        binding?.buttonCondition4.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
           showConfirmationAlert()
    }

    override fun onBackPressed() {
        //super.onBackPressed()
    }


   private fun  showConfirmationAlert(){
       MaterialAlertDialogBuilder(this)
               .setTitle("Thank You")
               .setMessage("Your current condition has been recorded")
               .setPositiveButton("GOT IT",object : DialogInterface.OnClickListener  {
                   override fun onClick(p0: DialogInterface?, p1: Int) {

                   }

               })
               .show()
   }



}