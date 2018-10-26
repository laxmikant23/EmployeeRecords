package com.mykotlinapp.model

import android.os.AsyncTask

class PopulateDbAsync(instance: EmployeeRoomDB?) : AsyncTask<Void,Void,Void>(){
    private var mDao: EmployeeDao = instance!!.empDao()

    override fun doInBackground(vararg params: Void): Void? {

       /* mDao.deleteAll()
        var emp = Employee()
        emp.name = "Karan"
        emp.mAge = 22

        mDao.insert(emp)
        emp = Employee()
        emp.name = "Kiran"
        emp.mAge = 23

        mDao.insert(emp)*/
        return null

    }
}
