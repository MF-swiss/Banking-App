package bankingapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import bankingapp.R
import bankingapp.viewmodel.BankViewModel
import android.content.Intent
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private val viewModel: BankViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        kotlin
        val openTransferButton: Button = findViewById(R.id.openTransferButton)

        openTransferButton.setOnClickListener {
            val intent = Intent(this, TransferActivity::class.java)
            startActivity(intent)
        }

        val accountsText: TextView = findViewById(R.id.accountsText)

        viewModel.accounts.observe(this, Observer { accounts ->
            val text = accounts.joinToString("\n") {
                "${it.name}: ${"%.2f".format(it.balance)} CHF"
            }
            accountsText.text = text
        })
    }
}
