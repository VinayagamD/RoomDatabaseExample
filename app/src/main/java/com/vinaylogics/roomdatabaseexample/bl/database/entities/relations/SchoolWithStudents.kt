package com.vinaylogics.roomdatabaseexample.bl.database.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.vinaylogics.roomdatabaseexample.bl.database.entities.School
import com.vinaylogics.roomdatabaseexample.bl.database.entities.Student

data class SchoolWithStudents(
  @Embedded val school: School,
  @Relation(
      parentColumn = "schoolName",
      entityColumn = "schoolName"
  )
  val students: List<Student>
)