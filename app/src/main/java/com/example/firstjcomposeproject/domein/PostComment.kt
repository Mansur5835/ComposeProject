package com.example.firstjcomposeproject.domein


data class PostComment(
    val id: Int,
    val authorName: String = "Author",
    val avatar: String = "https://imgv3.fotor.com/images/slider-image/A-clear-image-of-a-woman-wearing-red-sharpened-by-Fotors-image-sharpener.jpg",
    val commentText: String = "Long comment text",
    val publicDate: String = "14:35"

)