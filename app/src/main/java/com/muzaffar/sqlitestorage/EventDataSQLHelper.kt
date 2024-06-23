package com.muzaffar.sqlitestorage

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns

// 1) Class declaration inherits SQLiteHelper
// 3) Alt enter on EventDataSQLHelper -> Implement methods
class EventDataSQLHelper(context: Context) : SQLiteOpenHelper(context,
    EventDataSQLHelper.DATABASE_NAME, null, EventDataSQLHelper.DATABASE_VERSION) {

    // 2) Constant dan masukkan di dalam constructor parent class
    // COnstants / Settings / Nama table nama db nama coluumn
    companion object {
        private val DATABASE_NAME = "events.db" // nama db
        private val DATABASE_VERSION = 1
        val TABLE = "users" //nama table
        val USERNAME = "username" // nama column
    }

    // When the databse is created..
    // Create all the tables that we are going to store
    override fun onCreate(db: SQLiteDatabase?) {
        val query = "CREATE TABLE $TABLE(${BaseColumns._ID} integer primary key autoincrement, $USERNAME text not null);"
        db?.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        if (oldVersion >= newVersion){
            return
        }
        // Lain2 tak penting buat masa ni
    }
}