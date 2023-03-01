package com.example.paging3_practice.entities

import androidx.room.Entity

@Entity
data class Results (
    val _id : String,
    val  author : String,
    val content : String,
    val authorSlug : String,
    val length : Int,
    val dateAdded : String,
    val dateModified : String,
    val tags : List<String>
    )



