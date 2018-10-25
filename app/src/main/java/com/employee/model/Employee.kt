package com.mykotlinapp.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "employee_table")
data class Employee(
                    @ColumnInfo(name = "name") val name: String, @ColumnInfo(name  = "age") var mAge: String){
    @PrimaryKey (autoGenerate = true) var id:Int = 0
    /* @PrimaryKey(autoGenerate = true)
     private var id = 0

     @NonNull
     @ColumnInfo(name  = "name")
     var mName : String = ""


     @NonNull
     @ColumnInfo(name  = "age")
     var mAge : Int = 18*/
}