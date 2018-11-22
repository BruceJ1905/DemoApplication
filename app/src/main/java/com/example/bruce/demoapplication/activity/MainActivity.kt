package com.example.bruce.demoapplication.activity

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.example.bruce.demoapplication.R
import io.reactivex.Flowable
import io.reactivex.functions.Consumer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)


        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
            Flowable.just("11","hello world").subscribe(System.out::println)

            Flowable.range(1,5)
                    .map { v -> v * v }
//                    .filter {v -> v % 3 == 0}
                    .subscribe(object : Consumer<Int> {
                        override fun accept(t: Int?) {
                            System.out.println(t);
                        }

                    } )

            Flowable.fromCallable<Any> {
                Thread.sleep(1000)
                "Done"
            }.subscribe()

            val i = Intent(this, Ac4::class.java)
            i.putExtra("k1", 1);
            i.putExtra("k2", "v2");
            startActivity(i)

        }

        // Example of a call to a native method
//        sample_text.text = stringFromJNI()


    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {

        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }
}
