package bankingapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import bankingapp.R
import bankingapp.viewmodel.BankViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: BankViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val accountsText: TextView = findViewById(R.id.accountsText)

        viewModel.accounts.observe(this, Observer { accounts ->
            val text = accounts.joinToString("\n") {
                "${it.name}: ${"%.2f".format(it.balance)} CHF"
            }
            accountsText.text = text
        })
    }
}
