package com.mykotlinapp.model

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import android.arch.persistence.db.SupportSQLiteDatabase

@Database(entities = [Employee::class], version = 1)

abstract class EmployeeRoomDB : RoomDatabase() {
    abstract fun empDao(): EmployeeDao
    companion object {
        private var INSTANCE: EmployeeRoomDB? = null
        var TEST_MODE = false

        fun getInstance(context: Context): EmployeeDao? {
            if (INSTANCE == null) {
                synchronized(EmployeeRoomDB::class) {
                    if (TEST_MODE) {
                        INSTANCE = Room.inMemoryDatabaseBuilder(context, EmployeeRoomDB::class.java).allowMainThreadQueries().build()

                    }else{
                        INSTANCE = Room.databaseBuilder(context.applicationContext,
                                EmployeeRoomDB::class.java, "employee").
                                addCallback(sRoomDatabaseCallback)
                                .build()
                    }

                }

            }
            return INSTANCE!!.empDao()
        }

        fun destroyInstance() {
            INSTANCE = null
        }

        private val sRoomDatabaseCallback = object : RoomDatabase.Callback() {

            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                PopulateDbAsync(INSTANCE).execute()
            }
        }
    }
}