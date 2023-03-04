package com.example.suple.controller

import com.example.suple.model.Order
import com.example.suple.model.OrderView
import com.example.suple.service.OrderService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid


@RestController
@RequestMapping("/order")
class OrderController {

    @Autowired
    lateinit var orderService: OrderService

    @GetMapping
    fun list():List<Order>{
        return orderService.list()
    }

  @GetMapping("/{id}")
  fun listById (@PathVariable("id") id: Long):ResponseEntity<Order>{
    return ResponseEntity(orderService.listById(id), HttpStatus.OK)
  }

  @GetMapping("/with/customer")
  fun listWithCustomer (): ResponseEntity<List<OrderView>> {
    return ResponseEntity(orderService.listWithCustomer(), HttpStatus.OK)
  }

    @PostMapping
    fun save (@RequestBody @Valid order:Order):ResponseEntity<Order>{
        return ResponseEntity(orderService.save(order), HttpStatus.OK)
    }


}
