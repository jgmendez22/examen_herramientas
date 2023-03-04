package com.example.suple.repository

import com.example.suple.model.OrderView
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderViewRepository: JpaRepository <OrderView, Long> {

    fun findById(id: Long?):OrderView?
}
