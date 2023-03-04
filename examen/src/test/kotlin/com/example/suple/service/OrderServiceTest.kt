package com.example.suple.service

import com.example.suple.model.Order
import com.example.suple.repository.OrderRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest
import java.text.SimpleDateFormat


@SpringBootTest
class OrderServiceTest {

  @Mock
  lateinit var orderRepository: OrderRepository

  @InjectMocks
  lateinit var orderService: OrderService

  var orderMock = Order().apply {
    id = 1
    date = SimpleDateFormat("yyyy-MM-dd").parse("2023-03-03")
    total = 100.0
    customerId = 2
  }

  @Test
  fun testInvoiceDateFormat() {

    Mockito.`when`(orderRepository.save(orderMock)).thenReturn(orderMock)
    orderService.save(orderMock)
    val invoiceSavedWithCorrectDateFormat = orderRepository.save(orderMock)
    val dateFormat = SimpleDateFormat("yyyy-MM-dd")
    val savedDateWithCorrectFormat = dateFormat.format(invoiceSavedWithCorrectDateFormat.date)
    Assertions.assertNotEquals("correct date format", "yyyy-MM-dd", savedDateWithCorrectFormat)

  }



}
