package com.github.pierangeloc.mt

import java.util.UUID

case class SubscriptionId(value: UUID) extends AnyVal
case class TaskId(value: UUID) extends AnyVal
case class UserId(value: String) extends AnyVal
case class PaymentMeanId(value: UUID) extends AnyVal
case class ServiceId(value: UUID) extends AnyVal
case class TransactionId(value: UUID) extends AnyVal

case class Subscription(id: SubscriptionId, taskId: TaskId)
case class Task(id: TaskId, userId: UserId, paymentMeanId: PaymentMeanId, serviceId: ServiceId)
case class TransactionRequest(paymentMeanId: PaymentMeanId, amount: BigDecimal, serviceId: ServiceId)
case class Transaction(id: TransactionId, serviceId: ServiceId, paymentMeanId: PaymentMeanId, userId: UserId)

