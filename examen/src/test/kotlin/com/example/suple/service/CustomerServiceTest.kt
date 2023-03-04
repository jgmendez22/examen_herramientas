package com.example.suple.service

import com.example.suple.model.Customer
import com.example.suple.repository.CustomerRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest


@SpringBootTest
class CustomerServiceTest {

  @InjectMocks
  lateinit var customerService: CustomerService

  @Mock
  lateinit var  customerRepository: CustomerRepository

  var customerMock = Customer().apply{
    id=1
    fullname="Jonnathan Mendez"
    email="jgmendez@sudamericano.edu.ec"
  }

  @Test
  fun validationEmailWithAtSign(){
    Mockito.`when`(customerRepository.save(Mockito.any(Customer::class.java))).thenReturn(customerMock)
    customerMock.email?.contains("@")?.let { Assertions.assertTrue(it) }
    val response = customerService.save(customerMock)
    Assertions.assertEquals(response?.id, customerMock.id)
  }
}


