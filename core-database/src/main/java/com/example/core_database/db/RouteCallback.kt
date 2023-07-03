package com.example.core_database.db

import android.content.Context
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.core_database.R
import org.json.JSONArray
import java.io.BufferedReader

class RouteCallback(val context: Context) : RoomDatabase.Callback() {
    override fun onCreate(db: SupportSQLiteDatabase) {
        super.onCreate(db)
        loadJSONArray(context)?.let {
            for (i in 0 until  it.length()){
                val items = it.getJSONArray(i)
            }
        }
        RouteDatabase.getInstance(context).routeDao().insertRouteFromJson()

    }

    private fun loadJSONArray(context: Context): JSONArray? {

        val inputStream = context.resources.openRawResource(R.raw.route)

        BufferedReader(inputStream.reader()).use {
            return JSONArray(it.readText())
        }
    }

}