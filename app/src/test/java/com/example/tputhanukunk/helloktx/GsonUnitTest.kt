package com.example.tputhanukunk.helloktx

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.junit.Test

import org.junit.Assert.*

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
        val actualEmployeeList: List<Employee> = gson.fromJson<List<Employee>>(json, object : TypeToken<List<Employee>>() {}.type)

        //Assert
        assertEquals(expectedEmployeeList, actualEmployeeList)
    }


}
