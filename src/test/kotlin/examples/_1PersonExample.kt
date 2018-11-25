package ru.yole.jkid.examples.simple

import org.junit.Test
import ru.yole.jkid.deserialization.deserialize
import ru.yole.jkid.serialization.serialize
import kotlin.test.assertEquals

data class Person(val name: String, val age: Int)

class PersonTest {
    @Test fun test() {
        val person = Person("Alice", 29)
        val json = """{"age": 29, "name": "Alice"}"""
        val person2 = deserialize<Person>(json)

        assertEquals(json, serialize(person))
        assertEquals(person, deserialize(json))
        assertEquals(person, person2)
    }
}