package br.applabbs.composecomponents.unitTestDemo

import org.junit.After
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test


class SimpleButtonUnitTest {

    companion object{
        @BeforeClass
        @JvmStatic
        fun setupAll(){
            println("Setup unit test")
        }
    }

    @Before
    fun setup(){
        println("Setup this Unit Test")
    }

    @After
    fun teardown(){
        println("Clean all data")
    }

    @Test
    fun testSomething(){

    }

}