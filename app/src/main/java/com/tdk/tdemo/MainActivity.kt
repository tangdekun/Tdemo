package com.tdk.tdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.widget.Toast

class MainActivity : AppCompatActivity(),MainFragment.FragmentListener {
    override fun process(name:String) {
        Toast.makeText(this,"MainActivity $name",Toast.LENGTH_LONG).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var fragment:Fragment = MainFragment.newMainFragment()
        var bundle = Bundle()
        bundle.putString("key","Hello")
        fragment.arguments = bundle
        supportFragmentManager.beginTransaction().add(R.id.fragment,fragment).commit()

    }

    fun gettitle() = "MainFragment"


}
