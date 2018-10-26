package com.mykotlinapp.model

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
@Dao
interface EmployeeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(employee:Employee)

    @Query("DELETE FROM employee_table")
    fun deleteAll()

    @Query("SELECT * FROM employee_table ORDER BY name ASC")
    fun getALlEmployees() : LiveData<List<Employee>>
}