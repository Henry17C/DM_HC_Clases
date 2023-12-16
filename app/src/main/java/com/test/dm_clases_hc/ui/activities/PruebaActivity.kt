package com.test.dm_clases_hc.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


import com.test.dm_clases_hc.databinding.ActivityPruebaBinding
import com.test.dm_clases_hc.ui.fragments.ListFragment

class PruebaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPruebaBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityPruebaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listFragment = ListFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(binding.frmContainer.id, listFragment)
        transaction.commit()



    }
}