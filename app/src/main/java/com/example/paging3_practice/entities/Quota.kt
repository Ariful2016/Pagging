package com.example.paging3_practice.entities

data class Quota (
    val count : Int,
    val totalCount : Int,
    val page : Int,
    val totalPages : Int,
    val results : List<Results>
    )