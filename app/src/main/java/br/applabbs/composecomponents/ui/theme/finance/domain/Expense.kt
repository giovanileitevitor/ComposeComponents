package br.applabbs.composecomponents.ui.theme.finance.domain

data class Expense(
    val value: Float,
    val description: String,
    val data: String
)

fun getFakeExpenses(): List<Expense>{
    val expenses = mutableListOf<Expense>()

    for(i in 1..12){
        expenses.add(
            Expense(
                value = 10f,
                description = "Mercado",
                data = "15/Nov/2023"
            )
        )
    }

    return expenses
}

fun getFakeValues(): List<Float>{
    val values = mutableListOf<Float>()

//    values.add(0.50f)
//    values.add(0.60f)
    values.add(0.10f)
    values.add(0.30f)
    values.add(0.30f)
    values.add(0.10f)
    values.add(0.60f)
    values.add(0.60f)
    values.add(0.10f)
    values.add(0.20f)
    values.add(0.30f)
    values.add(0.40f)

    return values
}

fun getFakeMonths(): List<String>{
    val months = mutableListOf<String>()

//    months.add("Jan")
//    months.add("Fev")
    months.add("Mar")
    months.add("Abr")
    months.add("Mai")
    months.add("Jun")
    months.add("Jul")
    months.add("Ago")
    months.add("Set")
    months.add("Out")
    months.add("Nov")
    months.add("Dez")

    return months
}

