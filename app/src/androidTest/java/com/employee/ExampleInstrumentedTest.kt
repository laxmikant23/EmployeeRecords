package com.employee

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import com.mykotlinapp.model.Employee
import com.mykotlinapp.model.EmployeeDao
import com.mykotlinapp.model.EmployeeRoomDB

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    private var empDao: EmployeeDao? = null
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("com.employee", appContext.packageName)
    }

    @Before
    fun setUp(){
        EmployeeRoomDB.TEST_MODE = true
        empDao = EmployeeRoomDB.getInstance(InstrumentationRegistry.getTargetContext())
    }

    @Test
    fun shouldInsert(){
        val employee : Employee = Employee("Sachin","Hello")
        empDao!!.insert(employee)

       // val empTest = getVa
    }

}

