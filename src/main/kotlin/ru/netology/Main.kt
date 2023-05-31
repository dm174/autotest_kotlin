package ru.netology
fun calculateTransferFee(
    accountType: String = "VK Pay",
    previousTransfers: Double = 0.0,
    transferAmount: Double
): Double {
    val maxDailyTransferAmount = 150000.0 // Максимальная сумма переводов по одной карте в сутки
    val maxMonthlyTransferAmount = 600000.0 // Максимальная сумма переводов по одной карте в месяц
    val maxTransferAmountVKPay = 15000.0 // Максимальная сумма перевода в VK Pay за один раз
    val maxMonthlyTransferAmountVKPay = 40000.0 // Максимальная сумма переводов в VK Pay в месяц

    val totalTransfers = previousTransfers + transferAmount

    when (accountType) {
        "VK Pay" -> {
            if (transferAmount > maxTransferAmountVKPay) {
                return -1.0 // Превышена максимальная сумма перевода в VK Pay за один раз
            }
            if (totalTransfers > maxMonthlyTransferAmountVKPay) {
                return -2.0 // Превышена максимальная сумма переводов в VK Pay в текущем месяце
            }
            return 0.0 // Комиссия 0% для VK Pay
        }
        "Mastercard", "Maestro" -> {
            if (previousTransfers >= 300 && previousTransfers <= 75000) {
                return 0.0 // Комиссия не взымается в рамках акции
            } else {
                return transferAmount * 0.6 / 100 + 20 // 0.6% + 20 рублей комиссия
            }
        }
        "Visa", "Мир" -> {
            val transferFee = transferAmount * 0.75 / 100
            val minTransferFee = 35.0
            return maxOf(transferFee, minTransferFee) // Минимум 35 рублей комиссия для карт Visa и Мир
        }
        else -> return 1.0 // Комиссия 1.0 (100%) для неизвестного типа карты
    }
}

fun main() {
    val accountType = "Visa"
    val previousTransfers = 0.0 // Сумма предыдущих переводов в текущем месяце
    val transferAmount = 15000.0

    val transferFee = calculateTransferFee(accountType, previousTransfers, transferAmount)

    when {
        transferFee == -1.0 -> println("Превышена максимальная сумма перевода в VK Pay за один раз")
        transferFee == -2.0 -> println("Превышена максимальная сумма переводов в VK Pay в текущем месяце")
        else -> println("Сумма комиссии: $transferFee рублей")
    }
}
