package com.vinaylogics.roomdatabaseexample.bl.database.entities.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.vinaylogics.roomdatabaseexample.bl.database.entities.Student
import com.vinaylogics.roomdatabaseexample.bl.database.entities.Subject

data class StudentWithSubjects(
    @Embedded val student: Student,
    @Relation(
      parentColumn = "studentName",
      entityColumn = "subjectName",
        associateBy = Junction(StudentSubjectCrossRef::class)
    )
    val subjects: List<Subject>

)
