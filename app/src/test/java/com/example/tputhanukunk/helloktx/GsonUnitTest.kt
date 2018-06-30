package com.example.tputhanukunk.helloktx

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.junit.Test

import org.junit.Assert.*

//GsonExtension.kt file
inline fun <reified T> Gson.fromJson(json: String) = fromJson<T>(json, typeToken<T>())

inline fun <reified T> typeToken() = object : TypeToken<T>() {}.type

class GsonUnitTest {

    data class Employee(val name: String, val age: Int)

    @Test
    fun testGson() {
        //Arrange
        val json = """
            [
            {"name":"Alice", "age":20},
            {"name":"Bob", "age":25}
            ]
        """.trimIndent()

        val expectedEmployeeList = listOf(
                Employee("Alice", 20),
                Employee("Bob", 25)
        )

        val gson = Gson()

        //Act
        val actualEmployeeList: List<Employee> = gson.fromJson(json)

        //Assert
        assertEquals(expectedEmployeeList, actualEmployeeList)
    }


}
