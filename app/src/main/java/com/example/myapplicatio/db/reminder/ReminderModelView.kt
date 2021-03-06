package com.example.myapplicatio.db.reminder

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData

class ReminderModelView : AndroidViewModel {
    private var mItems: LiveData<List<ReminderEntity>>? = null
    private var mItem: List<ReminderEntity>? = null
    var mRepo: ReminderRepositor

    constructor(application: Application) : super(application) {
        mRepo = ReminderRepositor(application)
    }

    fun getAllPeopleInfo(): LiveData<List<ReminderEntity>>? {
        if (mItems == null) {
            mItems = mRepo.getLiveUsers()
        }
        return mItems
    }

    fun getAllReminder(): List<ReminderEntity>? {
        if (mItem == null) {
            mItem = mRepo.getAllPeople()
        }
        return mItem
    }

    fun insert(id: ReminderEntity) {
        mRepo.insert(id)
    }

    fun delete(id: ReminderEntity) {
        mRepo.delete(id)
    }
}