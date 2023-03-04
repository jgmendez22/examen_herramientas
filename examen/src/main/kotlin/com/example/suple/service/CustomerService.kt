package com.example.suple.service

import com.example.suple.model.Customer
import com.example.suple.repository.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class CustomerService {

    @Autowired
    lateinit var customerRepository: CustomerRepository


    fun list():List<Customer>{
        return customerRepository.findAll()
    }

  fun listById (id: Long?): Customer?{
    return customerRepository.findById(id)
  }

  fun findCsI(): List<Customer> {
    return customerRepository.findCsI()
  }


    fun save(customer:Customer):Customer {
      try {
        customer.fullname?.takeIf { it.trim().isNotEmpty() }
          ?: throw Exception("fullname should not be empty")

        return customerRepository.save(customer)
      }
      catch(ex:Exception){
        throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
      }
    }
}
