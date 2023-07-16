package com.vinaylogics.roomdatabaseexample.bl.database.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.vinaylogics.roomdatabaseexample.bl.database.entities.Director
import com.vinaylogics.roomdatabaseexample.bl.database.entities.School

data class SchoolAndDirector(
    @Embedded val school: School,

    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val director: Director
)