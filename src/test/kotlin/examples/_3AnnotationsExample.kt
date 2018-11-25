package ru.yole.jkid.examples.annotationsTest

import org.junit.Test
import ru.yole.jkid.JsonExclude
import ru.yole.jkid.JsonName
import ru.yole.jkid.deserialization.deserialize
import ru.yole.jkid.examples.jsonSerializerTest.testJsonSerializer
import ru.yole.jkid.serialization.serialize
import kotlin.test.assertEquals

data class Person(
    @JsonName(name = "first_name") val firstName: String,
    @JsonExclude val age: Int? = null
)

class AnnotationsTest {
    @Test fun test() = testJsonSerializer(
            value = Person("Alice"),
            json = """{"first_name": "Alice"}"""
    )

    @Test fun test2() {
        val person = Person("Alice", 29)
        val json = """{"first_name": "Alice"}"""
        // the "age" is excluded when serializing
        assertEquals(json, serialize(person))
        assertEquals(Person("Alice"), deserialize(json))
    }
}