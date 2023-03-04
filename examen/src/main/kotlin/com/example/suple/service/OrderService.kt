package com.example.suple.service

import com.example.suple.model.Order
import com.example.suple.model.OrderView
import com.example.suple.repository.CustomerRepository
import com.example.suple.repository.OrderRepository
import com.example.suple.repository.OrderViewRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.text.SimpleDateFormat


@Service
class OrderService {

  @Autowired
  lateinit var orderRepository: OrderRepository

  @Autowired
  lateinit var orderViewRepository: OrderViewRepository

  @Autowired
  lateinit var customerRepository: CustomerRepository

  fun list(): List<Order> {
    return orderRepository.findAll()
  }

  fun listById (id: Long?): Order?{
    return orderRepository.findById(id)
  }

  fun listWithCustomer(): List<OrderView> {
    return orderViewRepository.findAll()
  }


  fun save(order: Order): Order {
    try {

      val dateFormat = SimpleDateFormat("yyyy-MM-dd")
      val formattedDate = dateFormat.format(order.date
      )
      order.date = dateFormat.parse(formattedDate)
      return orderRepository.save(order)

      customerRepository.findById(order.customerId)
        ?: throw Exception("Id does not exist")
      return orderRepository.save(order)
    } catch (ex: Exception) {
      throw ResponseStatusException(
        HttpStatus.NOT_FOUND, ex.message, ex
      )
    }
  }

}


