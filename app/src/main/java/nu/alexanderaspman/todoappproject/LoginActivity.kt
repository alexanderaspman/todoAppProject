
package nu.alexanderaspman.todoappproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.rVLoginInfo

class LoginActivity : AppCompatActivity() {
    private lateinit var todoAdapter: UserViewModal
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        todoAdapter=   UserViewModal(mutableListOf())

        rVLoginInfo.adapter =  todoAdapter
        rVLoginInfo.layoutManager=LinearLayoutManager(this)
        BtnLogin.setOnClickListener {
            if (title.isNotEmpty()) {
                val userEmail = editTextTextEmailAddress.text.toString()
                val userpassword = editTextTextPassword.text.toString()

                val todo = User(userEmail,userpassword)
                todoAdapter.addInfo(todo)
                editTextTextEmailAddress.text.clear()
                editTextTextPassword.text.clear()

            }
        }

    }
}