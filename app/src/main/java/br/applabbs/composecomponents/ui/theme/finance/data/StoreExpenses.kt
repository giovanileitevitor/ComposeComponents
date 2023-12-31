package br.applabbs.composecomponents.ui.theme.finance.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import br.applabbs.composecomponents.ui.theme.finance.domain.Expense

class StoreExpenses(
    private val context: Context
) {

    companion object{
        private val Context.datStore: DataStore<Preferences> by preferencesDataStore("expenses")
        val ANOTATION_KEY = stringPreferencesKey("expense")
    }

    suspend fun getExpenses(): List<Expense>{
        val expenses = mutableListOf<Expense>()

        return expenses
    }

    suspend fun saveExpense(expense: Expense){

    }

}