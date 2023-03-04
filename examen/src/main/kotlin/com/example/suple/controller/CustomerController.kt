package com.example.suple.controller

import com.example.suple.model.Customer
import com.example.suple.service.CustomerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
@RequestMapping("/customer")
class CustomerController {

    @Autowired
    lateinit var customerService: CustomerService

    @GetMapping
    fun list():List<Customer>{
        return customerService.list()
    }

  @GetMapping("/{id}")
  fun listById (@PathVariable("id") id: Long):ResponseEntity<Customer>{
    return ResponseEntity(customerService.listById(id), HttpStatus.OK)
  }

  @GetMapping("/without-order")
  fun findCsI(): ResponseEntity<List<Customer>> {
    val customers = customerService.findCsI()
    return ResponseEntity.ok(customers)
  }

    @PostMapping
    fun save (@RequestBody @Valid customer:Customer):ResponseEntity<Customer>{
        return ResponseEntity(customerService.save(customer), HttpStatus.OK)
    }
}
