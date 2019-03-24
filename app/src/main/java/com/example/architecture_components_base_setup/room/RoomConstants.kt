package com.example.architecture_components_base_setup.room

//database version counter. Update date when changing for tracking purposes
//last update: 23 March 2018
var DATABASE_VERSION = 1

//database name
const val DATABASE_NAME = "baseDatabase"



//Table names
const val USER_TABLE = "Users"




//Queries
const val QUERY_SELECT_USER = "SELECT * FROM " + USER_TABLE + " WHERE uniqueId == :uniqueId LIMIT 1"