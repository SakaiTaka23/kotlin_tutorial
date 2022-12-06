fun challenge(){
    val alexAccount = Account("Alex")
    alexAccount.deposit(1000)
    alexAccount.withdraw(20)
    val balance = alexAccount.calculateBalance()
    println(balance)
}

class Account(private val accountName: String) {
    private var balance = 0
    private var transactions = mutableListOf<Int>()

    fun deposit(amount: Int) {
        if (amount > 0) {
            transactions.add(amount)
            balance += amount
            println("$amount deposited. Balance is now ${this.balance}")
        } else {
            println("Cannot deposit negative sums")
        }
    }

    fun withdraw(withdrawal: Int){
        if(-withdrawal < 0) {
            transactions.add(-withdrawal)
            this.balance += -withdrawal
            println("$withdrawal withdrawn. Balance is now ${this.balance}")
        } else {
            println("Cannot withdraw negative sums")
        }
    }

    fun calculateBalance(): String {
        this.balance = 0
        for (transaction in transactions) {
            this.balance  += transaction
        }
        return "$accountName your balance is ${this.balance}"
    }
}
