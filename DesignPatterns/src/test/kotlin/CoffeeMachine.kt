import kotlin.test.Test

interface CoffeeMachine {
    fun makeSmallCoffee()
    fun makeLargeCoffee()
}

class NormalCoffeeMachine: CoffeeMachine {
    override fun makeSmallCoffee() = println("Normal: Making small coffee")
    override fun makeLargeCoffee() = println("Normal: Making large coffee")
}

// Decorator
class EnhancedCoffeeMachine(private val coffeeMachine: CoffeeMachine): CoffeeMachine by coffeeMachine {
    override fun makeLargeCoffee() {
        println("Enhanced: Making large coffee")
        coffeeMachine.makeLargeCoffee()
    }

    fun makeMilkCoffee() {
        println("Enhanced: Making milk coffee")
        coffeeMachine.makeSmallCoffee()
        println("Enhanced: Adding milk")
    }
}

class DecoratorTest {
    @Test
    fun testDecorator() {
        val normalMachine = NormalCoffeeMachine()
        val enhancedMachine = EnhancedCoffeeMachine(normalMachine)

        enhancedMachine.makeSmallCoffee()
        enhancedMachine.makeLargeCoffee()
        enhancedMachine.makeMilkCoffee()
    }
}
