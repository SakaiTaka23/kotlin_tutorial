import kotlin.test.Test

interface ReportElement {
    fun <R> accept(visitor: ReportVisitor<R>): R
}

class FixedPriceContract(val costPerYear: Long): ReportElement {
    override fun <R> accept(visitor: ReportVisitor<R>): R {
        return visitor.visit(this)
    }
}

class TimeAndMaterialsContract(val costPerHour: Long, val hours: Long): ReportElement {
    override fun <R> accept(visitor: ReportVisitor<R>): R {
        return visitor.visit(this)
    }
}

class SupportContract(val costPerMonth: Long): ReportElement {
    override fun <R> accept(visitor: ReportVisitor<R>): R {
        return visitor.visit(this)
    }
}

interface ReportVisitor<out R> {
    fun visit(contract: FixedPriceContract): R
    fun visit(contract: TimeAndMaterialsContract): R
    fun visit(contract: SupportContract): R
}

class MonthlyCostReportVisitor: ReportVisitor<Long>{
    override fun visit(contract: FixedPriceContract): Long {
        return contract.costPerYear / 12
    }

    override fun visit(contract: TimeAndMaterialsContract): Long {
        return contract.costPerHour * contract.hours
    }

    override fun visit(contract: SupportContract): Long {
        return contract.costPerMonth
    }
}

class YearlyReportVisitor: ReportVisitor<Long> {
    override fun visit(contract: FixedPriceContract): Long {
        return contract.costPerYear
    }

    override fun visit(contract: TimeAndMaterialsContract): Long {
        return contract.costPerHour * contract.hours
    }

    override fun visit(contract: SupportContract): Long {
        return contract.costPerMonth * 12
    }
}

class VisitorTest {
    @Test
    fun testVisitor() {
        val projectAlpha = FixedPriceContract(1000)
        val projectBeta = TimeAndMaterialsContract(100, 10)
        val projectGamma = SupportContract(500)

        val monthlyCostReportVisitor = MonthlyCostReportVisitor()
        val yearlyReportVisitor = YearlyReportVisitor()

        val monthlyCostProjectAlpha = projectAlpha.accept(monthlyCostReportVisitor)
        val monthlyCostProjectBeta = projectBeta.accept(monthlyCostReportVisitor)
        val monthlyCostProjectGamma = projectGamma.accept(monthlyCostReportVisitor)

        val yearlyCostProjectAlpha = projectAlpha.accept(yearlyReportVisitor)
        val yearlyCostProjectBeta = projectBeta.accept(yearlyReportVisitor)
        val yearlyCostProjectGamma = projectGamma.accept(yearlyReportVisitor)

        assert(monthlyCostProjectAlpha == 83L)
        assert(monthlyCostProjectBeta == 1000L)
        assert(monthlyCostProjectGamma == 500L)

        assert(yearlyCostProjectAlpha == 1000L)
        assert(yearlyCostProjectBeta == 1000L)
        assert(yearlyCostProjectGamma == 6000L)
    }
}
