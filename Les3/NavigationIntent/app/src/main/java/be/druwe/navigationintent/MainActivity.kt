package be.druwe.navigationintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import be.druwe.navigationintent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main);

        binding.button.setOnClickListener{
//            startInternalActivity()
            startExplicitActivity()
        }

        addMenuProvider(
            object: MenuProvider{
                override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                    menuInflater.inflate(R.menu.menu1, menu)
                }

                override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                    when(menuItem.itemId){
                        R.id.action_settings ->
                            startInternalActivity()
                    }
                    return true
                }

            }
        )
    }

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.menu1, menu)
//        return super.onCreateOptionsMenu(menu)
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when(item.itemId){
//            R.id.action_settings ->
//                startInternalActivity()
//        }
//        return super.onOptionsItemSelected(item)
//    }

    fun startInternalActivity(){
        val intent = Intent(this, DetailActivity::class.java)
        startActivity(intent)
    }

    fun startExplicitActivity(){
        val intent = Intent(Intent.ACTION_SEND)
        intent.type="text/plain"
        intent.putExtra(Intent.EXTRA_EMAIL, "matthias.druwe@odisee.be")
        intent.putExtra(Intent.EXTRA_TEXT, "Dit is een mail");

        if(intent.resolveActivity(packageManager)!= null){
            startActivity(intent)
        }
    }
}