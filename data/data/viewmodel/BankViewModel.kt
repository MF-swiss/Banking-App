package ch.marco.bankingapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import bankingapp.data.Account
import bankingapp.data.BankRepository

class BankViewModel : ViewModel() {

    private val _accounts = MutableLiveData<List<Account>>(BankRepository.accounts)
    val accounts: LiveData<List<Account>> = _accounts

    fun transfer(from: String, to: String, amount: Double) {
        BankRepository.transfer(from, to, amount)
        _accounts.value = BankRepository.accounts
    }
}
