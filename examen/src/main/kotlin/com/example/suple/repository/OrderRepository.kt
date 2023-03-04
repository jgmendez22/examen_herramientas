package com.example.suple.repository

import com.example.suple.model.Order
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderRepository: JpaRepository <Order, Long> {

    fun findById(id: Long?):Order?
}
