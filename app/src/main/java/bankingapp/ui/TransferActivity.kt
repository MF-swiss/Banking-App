package bankingapp.ui

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import bankingapp.R
import bankingapp.viewmodel.BankViewModel

class TransferActivity : AppCompatActivity() {

    private val viewModel: BankViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transfer)

        val fromEdit = findViewById<EditText>(R.id.fromAccountEdit)
        val toEdit = findViewById<EditText>(R.id.toAccountEdit)
        val amountEdit = findViewById<EditText>(R.id.amountEdit)
        val transferButton = findViewById<Button>(R.id.transferButton)

        transferButton.setOnClickListener {
            val from = fromEdit.text.toString()
            val to = toEdit.text.toString()
            val amount = amountEdit.text.toString().toDoubleOrNull()

            if (from.isBlank() || to.isBlank() || amount == null) {
                Toast.makeText(this, "Bitte alle Felder ausfüllen", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            viewModel.transfer(from, to, amount)

            Toast.makeText(this, "Überweisung erfolgreich", Toast.LENGTH_SHORT).show()

            finish() // zurück zur MainActivity
        }
    }
}
