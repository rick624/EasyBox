package com.rick.kotlin

import java.util.*

fun main() {
    val box3 = Box3(23f, 14f, 13f)
    val box5 = Box5(39.5f, 27.5f, 23f)

    val box3SizeSort:FloatArray = box3.sizeSort()
    println("Box3 size: ${box3SizeSort[0]} x ${box3SizeSort[1]} x ${box3SizeSort[2]}")

    val box5SizeSort:FloatArray = box5.sizeSort()
    println("Box5 size: ${box5SizeSort[0]} x ${box5SizeSort[1]} x ${box5SizeSort[2]}")

    val userSizeSort:FloatArray = userBox()
    println("User size: ${userSizeSort[0]} x ${userSizeSort[1]} x ${userSizeSort[2]}")

    if (box3.validate(userSizeSort[0], userSizeSort[1], userSizeSort[2])){
        println("Select Box3.")
    }else if (box5.validate(userSizeSort[0], userSizeSort[1], userSizeSort[2])){
        println("Select Box5.")
    }else{
        println("Not all boxes fit.")
    }
}

class Box3(length: Float, width: Float, height: Float) : BoxKotlin(length, width, height)

class Box5(length:Float, width:Float, height:Float) : BoxKotlin(length, width, height)

open class BoxKotlin(var length:Float, var width:Float, var height:Float) {
    companion object{
        var sizeSort = floatArrayOf()
    }

    open fun sizeSort(): FloatArray {       //排序尺寸，由大至小
        sizeSort = floatArrayOf(length, width, height)
        for (i in 1..2) {
            for (j in 0..1) {
                if (sizeSort[j] < sizeSort[j + 1]) {
                    var temp = sizeSort[j]
                    sizeSort[j] = sizeSort[j + 1]
                    sizeSort[j + 1] = temp
                }
            }
        }
        return sizeSort
    }

    open fun validate(length:Float, width:Float, height:Float) : Boolean {
        sizeSort = sizeSort()
        while (length <= sizeSort[0]) {         //由大至小各別比較尺寸
            return if (width <= sizeSort[1]) {
                if (height <= sizeSort[2]) true else false
            } else false
        }
        return false
    }
}

fun userBox(): FloatArray {
    val scanner = Scanner(System.`in`)
    print("Please enter object's length: ")
    val length = scanner.nextFloat()
    print("Please enter object's width: ")
    val width = scanner.nextFloat()
    print("Please enter object's height: ")
    val height = scanner.nextFloat()
    val userBox = BoxKotlin(length, width, height)
    val userSizeSort = userBox.sizeSort()
    return userSizeSort
}