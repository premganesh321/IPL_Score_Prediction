package com.example.ipl_score_prediction

import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf

object DataManger {
    var list = mutableListOf(
        "Chennai Super Kings"  //0
        ,"Delhi Daredevils"    //1
        ,"Kings XI Punjab"     //2
        ,"Kolkata Knight Riders"  //3
        ,"Mumbai Indians"   // 4
        ,"Rajasthan Royals"  // 5
        ,"Royal Challengers Bangalore" // 6
        ,"Sunrisers Hyderabad"  // 7
    )

    var firstinings  =  mutableStateOf(list[0])
    var fii = mutableIntStateOf(0)
    var secondinings  =  mutableStateOf(list[1])
    var sii = mutableIntStateOf(1)

    fun removeElement(index : Int){
        list.removeAt(index)
    }
    var currentOver = mutableIntStateOf(0)
    var currentRuns = mutableIntStateOf(0)
    var currentWickets = mutableIntStateOf(0)
    var lastFiveOverRuns = mutableIntStateOf(0)
    var lastFiveOversWickets = mutableIntStateOf(0)




}