package com.employee.view

import android.app.Activity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.employee.R
import com.mykotlinapp.model.EmpListAdapter
import com.mykotlinapp.model.Employee
import com.mykotlinapp.viewmodels.EmployeeViewModel

class EmployeeListClass : AppCompatActivity() {

    val NEW_WORD_ACTIVITY_REQUEST_CODE = 1

    private var mEmpViewModel: EmployeeViewModel?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)

       mEmpViewModel = ViewModelProviders.of(this).get(EmployeeViewModel::class.java)

            val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
           val adapter = EmpListAdapter(this)
           recyclerView?.layoutManager = LinearLayoutManager(this)
           recyclerView?. adapter = adapter

           mEmpViewModel?.getAllWords()?.observe(this, object : Observer<List<Employee>> {
               override fun onChanged(t: List<Employee>?) {
                   adapter.setWords(t!!)
               }
           });

           findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
               val intent = Intent(this@EmployeeListClass, MainActivity::class.java)
               startActivityForResult(intent, NEW_WORD_ACTIVITY_REQUEST_CODE)
           }
    }

     override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val employee = Employee(data!!.getStringExtra(MainActivity.EXTRA_NAME),
                    data.getStringExtra(MainActivity.EXTRA_LAST_NAME))
            mEmpViewModel?.insert(employee)
        } else {
        }
    }
}