package com.mykotlinapp.model

import android.app.Application
import android.arch.lifecycle.LiveData
import android.os.AsyncTask



class EmployeeRepo(application : Application){
    private val empDao: EmployeeDao
    private val listLiveData: LiveData<List<Employee>>

    init {
        val empRoomDatabase = EmployeeRoomDB.getInstance(application)
        empDao = empRoomDatabase!!
        listLiveData = empDao.getALlEmployees()
    }

    fun getAllEmployees(): LiveData<List<Employee>> {
        return listLiveData
    }

    fun insert(emp: Employee) {
        insertAsyncTask(empDao).execute(emp)
    }

    private class insertAsyncTask internal constructor(private val mAsyncTaskDao: EmployeeDao) : AsyncTask<Employee, Void, Void>() {

        override fun doInBackground(vararg params: Employee): Void? {
            mAsyncTaskDao.insert(params[0])
            return null
        }
    }

}