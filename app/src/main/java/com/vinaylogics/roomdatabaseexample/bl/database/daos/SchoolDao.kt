package com.vinaylogics.roomdatabaseexample.bl.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.vinaylogics.roomdatabaseexample.bl.database.entities.Director
import com.vinaylogics.roomdatabaseexample.bl.database.entities.School
import com.vinaylogics.roomdatabaseexample.bl.database.entities.Student
import com.vinaylogics.roomdatabaseexample.bl.database.entities.relations.SchoolAndDirector

@Dao
interface SchoolDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchool(school: School)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDirector(director: Director)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(student: Student)

    @Transaction
    @Query("SELECT * FROM school WHERE schoolName = :schoolName")
    suspend fun getSchoolAndDirectorWithSchoolName(schoolName: String): List<SchoolAndDirector>

    @Transaction
    @Query("SELECT * FROM school WHERE schoolName = :schoolName")
    suspend fun getSchoolWithStudentWithSchoolName(schoolName: String): List<Student>

}