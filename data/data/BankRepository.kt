packagebankingapp.data

object BankRepository {

    private val _accounts = mutableListOf(
        Account("Zyro Invest", 12450.20),
        Account("GREENCARD", 3120.50),
        Account("Privat Twint", 450.00)
    )

    val accounts: List<Account>
        get() = _accounts

    fun transfer(from: String, to: String, amount: Double) {
        val fromAcc = _accounts.firstOrNull { it.name == from }
        val toAcc = _accounts.firstOrNull { it.name == to }

        if (fromAcc != null && toAcc != null && amount > 0 && fromAcc.balance >= amount) {
            fromAcc.balance -= amount
            toAcc.balance += amount
        }
    }
}
