package com.eccomerce.Ikhlas_eccomerce.service;

import com.eccomerce.Ikhlas_eccomerce.payload.OrderDTO;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

public interface   OrderService {
    @Transactional
    OrderDTO placeOrder(String emailId, Long addressId, String paymentMethod, String pgName, String pgPaymentId, String pgStatus, String pgResponseMessage);
}
