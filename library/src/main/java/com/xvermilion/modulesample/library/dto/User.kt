package com.xvermilion.modulesample.library.dto

import java.util.*

interface User {
    var id: Long
    var name: String?
    var username: String?
    var uuid: String?
    var serverToken: String?
    var serverUUID: String?
    var contract: String?
    var differTime: Long
    var clubScore: Long
    var clubCif: String?
    var clubEScore: Long
    var clubLevel: Int
    var clubRemainScore: Long
    var clubLastUpdate: Date?
}