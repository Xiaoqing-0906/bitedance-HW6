package com.app.keepdog

import java.io.Serializable

class DogItem(
    var icon: Int,
    var name: String,
    var content: String
) : Serializable 