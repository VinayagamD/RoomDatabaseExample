package com.vinaylogics.roomdatabaseexample.bl.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.vinaylogics.roomdatabaseexample.bl.database.entities.Director
import com.vinaylogics.roomdatabaseexample.bl.database.entities.School
import com.vinaylogics.roomdatabaseexample.bl.database.entities.Student
import com.vinaylogics.roomdatabaseexample.bl.database.entities.Subject
import com.vinaylogics.roomdatabaseexample.bl.database.entities.relations.SchoolAndDirector
import com.vinaylogics.roomdatabaseexample.bl.database.entities.relations.SchoolWithStudents
import com.vinaylogics.roomdatabaseexample.bl.database.entities.relations.StudentSubjectCrossRef
import com.vinaylogics.roomdatabaseexample.bl.database.entities.relations.StudentWithSubjects
import com.vinaylogics.roomdatabaseexample.bl.database.entities.relations.SubjectWithStudents

@Dao
interface SchoolDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchool(school: School)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDirector(director: Director)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(student: Student)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSubject(subject: Subject)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSubjectSubjectCrossRef(crossRef: StudentSubjectCrossRef)

    @Transaction
    @Query("SELECT * FROM school WHERE schoolName = :schoolName")
    suspend fun getSchoolAndDirectorWithSchoolName(schoolName: String): List<SchoolAndDirector>

    @Transaction
    @Query("SELECT * FROM school WHERE schoolName = :schoolName")
    suspend fun getSchoolWithStudents(schoolName: String): List<SchoolWithStudents>

    @Transaction
    @Query("SELECT * FROM subject WHERE subjectName = :subjectName")
    suspend fun getStudentsOfSubject(subjectName: String): List<SubjectWithStudents>

    @Transaction
    @Query("SELECT * FROM student WHERE studentName = :studentName")
    suspend fun getSubjectsOfStudent(studentName: String): List<StudentWithSubjects>

}