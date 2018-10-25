package com.mykotlinapp.viewmodels

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.mykotlinapp.model.Employee
import com.mykotlinapp.model.EmployeeRepo

class EmployeeViewModel(application: Application) : AndroidViewModel(application){
    private var repo : EmployeeRepo = EmployeeRepo(application)
    private var allEmployees : LiveData<List<Employee>>

    init {
        allEmployees = repo.getAllEmployees()
    }

    fun getAllWords(): LiveData<List<Employee>> {
        return allEmployees
    }

    fun insert(employee: Employee) {
        repo.insert(employee)
    }


}