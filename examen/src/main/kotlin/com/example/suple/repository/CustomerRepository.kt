package com.example.suple.repository

import com.example.suple.model.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository: JpaRepository <Customer, Long> {

    fun findById(id: Long?):Customer?

  @Query(value = "SELECT c FROM Customer c WHERE NOT EXISTS (SELECT 1 FROM Order i WHERE i.customerId = c.id)")
  fun findCsI(): List<Customer>
}
