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


object example {

  case class CreditCard(number: String, balance: Double)

  sealed trait Item
  object Item {
    case object Jumper extends Item
    case object Shoes extends Item
    case object PS4 extends Item
  }

  val creditCards = List(
    CreditCard("4012000300001003", 20),
    CreditCard("4012000300001003", 300),
    CreditCard("5413330300001006", 500)
  )

  def creditCard(cc: String): Option[CreditCard] = creditCards.find(_.number == cc)

  def stuffToBuy(balance: Double): Option[Item] = if (balance < 250)
      None
    else if (250 < balance && balance < 350)
      Some(Item.Shoes)
    else
      Some(Item.PS4)

  def fidelityPoints(item: Item): Option[Int] = item match {
    case Item.PS4 => Some(30)
    case _ => None
  }

}
