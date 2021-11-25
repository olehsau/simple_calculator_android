package com.example.calculator

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import kotlin.math.pow
import kotlin.properties.Delegates

public class Variables{
    companion object {
        public lateinit var numbers: ArrayList<Int>
        public lateinit var display: TextView
        public lateinit var display_top: TextView
        public var operation by Delegates.notNull<Char>()
        public var operand1:Double = Double.NaN
        public var operand2:Double = Double.NaN
        public var result:Double = 0.0
        public var on:Boolean=false
        public lateinit var musicMP:MediaPlayer
        public lateinit var music_cats_on_mars:MediaPlayer
        public var pressed1:Int = 0
    }
}

class MainActivity : AppCompatActivity() {

    lateinit var mAdView : AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //ads
        MobileAds.initialize(this) {}
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)
        //initializing variables
        Variables.musicMP = MediaPlayer.create(this, R.raw.music)
        Variables.music_cats_on_mars = MediaPlayer.create(this, R.raw.cats_on_mars)
        Variables.numbers = ArrayList<Int>()
        Variables.operation = 'a'
        Variables.display = findViewById(R.id.textView)
        Variables.display_top = findViewById(R.id.display_top)
    }

    fun arrayToString(arr:ArrayList<Int>): String {
        var result:String = ""
        for(i in arr){
            result = result + i.toString()
        }
        return result
    }

    fun check_12345(){
        if(Variables.numbers[0]==1 && Variables.numbers[1]==2 && Variables.numbers[2]==3 && Variables.numbers[3]==4 && Variables.numbers[4]==5){
            Variables.music_cats_on_mars.start()
        }
    }

    fun two(view: View) {
        if(Variables.numbers.size<=10) {
            Variables.numbers.add(2)
            Variables.display.setText(arrayToString(Variables.numbers))
        }
    }
    fun zero(view: View) {
        if(Variables.numbers.size<=10) {
            Variables.numbers.add(0)
            Variables.display.setText(arrayToString(Variables.numbers))
        }
    }
    fun seven(view: View) {
        if(Variables.numbers.size<=10) {
            Variables.numbers.add(7)
            Variables.display.setText(arrayToString(Variables.numbers))
        }
    }
    fun four(view: View) {
        if(Variables.numbers.size<=10) {
            Variables.numbers.add(4)
            Variables.display.setText(arrayToString(Variables.numbers))
        }
    }
    fun three(view: View) {
        if(Variables.numbers.size<=10) {
            Variables.numbers.add(3)
            Variables.display.setText(arrayToString(Variables.numbers))
        }
    }
    fun one(view: View) {
        if(Variables.numbers.size<=10) {
            Variables.numbers.add(1)
            Variables.display.setText(arrayToString(Variables.numbers))
        }
        //easter egg
        Variables.pressed1++
        if(Variables.pressed1==20){
            Variables.display.setText("Рома крутой")
            Variables.pressed1=0
        }
    }
    fun six(view: View) {
        if(Variables.numbers.size<=10) {
            Variables.numbers.add(6)
            Variables.display.setText(arrayToString(Variables.numbers))
        }
    }
    fun five(view: View) {
        if(Variables.numbers.size<=10) {
            Variables.numbers.add(5)
            Variables.display.setText(arrayToString(Variables.numbers))
        }
        check_12345()
    }
    fun eight(view: View) {
        if(Variables.numbers.size<=10) {
            Variables.numbers.add(8)
            Variables.display.setText(arrayToString(Variables.numbers))
        }
    }
    fun nine(view: View) {
        if(Variables.numbers.size<=10) {
            Variables.numbers.add(9)
            Variables.display.setText(arrayToString(Variables.numbers))
        }
    }
    fun clear(view: View) {
        Variables.numbers.clear()
        Variables.display_top.setText("")
        Variables.display.setText("0")
        Variables.operand1= Double.NaN
        Variables.operand2= Double.NaN
        Variables.operation='a'
    }
    fun del(view: View) {
        if(Variables.numbers.size>=1) {
            Variables.numbers.removeLast()
        }
        Variables.display.setText(arrayToString(Variables.numbers))
    }
    fun plus(view: View) {
        // just converting array "Variables.numbers" to int "operand1"
        if(Variables.numbers.isEmpty()==false) {
            Variables.operand1 = 0.0
            for (i in 0..Variables.numbers.size - 1) {
                Variables.operand1 += (Variables.numbers[Variables.numbers.size - i - 1] * 10.0.pow(
                    i.toDouble()
                )).toInt()
            }
            Variables.numbers.clear()
        }
        Variables.display.setText("")
        //printing operand1 to top display
        if(Variables.operand1.mod(1.0)==0.0){
            Variables.display_top.setText(Variables.operand1.toInt().toString()+"+")
        }
        else{
            Variables.display_top.setText(Variables.operand1.toString()+"+")
        }
        Variables.operation = '+'
    }

    fun minus(view: View) {
        // just converting array "Variables.numbers" to int "operand1"
        if(Variables.numbers.isEmpty()==false) {
            Variables.operand1 = 0.0
            for (i in 0..Variables.numbers.size - 1) {
                Variables.operand1 += (Variables.numbers[Variables.numbers.size - i - 1] * 10.0.pow(
                    i.toDouble()
                )).toInt()
            }
            Variables.numbers.clear()
        }
        Variables.display.setText("")
        //printing operand1 to top display
        if(Variables.operand1.mod(1.0)==0.0){
            Variables.display_top.setText(Variables.operand1.toInt().toString()+"-")
        }
        else{
            Variables.display_top.setText(Variables.operand1.toString()+"-")
        }
        Variables.operation = '-'
    }

    fun mult(view: View) {
        // just converting array "Variables.numbers" to int "operand1"
        if(Variables.numbers.isEmpty()==false) {
            Variables.operand1 = 0.0
            for (i in 0..Variables.numbers.size - 1) {
                Variables.operand1 += (Variables.numbers[Variables.numbers.size - i - 1] * 10.0.pow(
                    i.toDouble()
                )).toInt()
            }
            Variables.numbers.clear()
        }
        Variables.display.setText("")
        //printing operand1 to top display
        if(Variables.operand1.mod(1.0)==0.0){
            Variables.display_top.setText(Variables.operand1.toInt().toString()+"*")
        }
        else{
            Variables.display_top.setText(Variables.operand1.toString()+"*")
        }
        Variables.operation = '*'
    }

    fun divide(view: View) {
        // just converting array "Variables.numbers" to int "operand1"
        if(Variables.numbers.isEmpty()==false) {
            Variables.operand1 = 0.0
            for (i in 0..Variables.numbers.size - 1) {
                Variables.operand1 += (Variables.numbers[Variables.numbers.size - i - 1] * 10.0.pow(
                    i.toDouble()
                )).toInt()
            }
            Variables.numbers.clear()
        }
        Variables.display.setText("")
        //printing operand1 to top display
        if(Variables.operand1.mod(1.0)==0.0){
            Variables.display_top.setText(Variables.operand1.toInt().toString()+"/")
        }
        else{
            Variables.display_top.setText(Variables.operand1.toString()+"/")
        }
        Variables.operation = '/'
    }

    fun equals(view: View) {
        // just converting array "Variables.numbers" to int "operand2"
        Variables.operand2=0.0
        for(i in 0..Variables.numbers.size-1){
            Variables.operand2 += (Variables.numbers[Variables.numbers.size-i-1]*10.0.pow(i.toDouble())).toInt()
        }

        if(Variables.operation=='+'){
            Variables.result = (Variables.operand1+Variables.operand2).toDouble()
        }
        else if(Variables.operation=='-'){
            Variables.result = (Variables.operand1-Variables.operand2).toDouble()
        }
        else if(Variables.operation=='*'){
            Variables.result = (Variables.operand1*Variables.operand2).toDouble()
        }
        else if(Variables.operation=='/'){
            Variables.result = (Variables.operand1/Variables.operand2).toDouble()
        }

        if(Variables.result.mod(1.0)==0.0){
            Variables.display.setText(Variables.result.toInt().toString())
        }
        else{
            Variables.display.setText(Variables.result.toString())
        }
        //easter egg
        if(Variables.operand2==0.0 && Variables.operation=='/') Variables.display_top.setText("ヽ(ಠ_ಠ)ノ ")
        else Variables.display_top.setText("")
        Variables.operand1 = Variables.result
        Variables.numbers.clear()
        Variables.pressed1=0 // just easter egg
    }

    fun switch_pressed(view: View) {
        Variables.on = !Variables.on
        if(Variables.on==true) Variables.musicMP.start()
        else Variables.musicMP.pause()
    }
}