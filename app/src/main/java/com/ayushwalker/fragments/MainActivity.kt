package com.ayushwalker.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()

        // This will help in making the fragments show in the FrameLayout of the activity_main.xml file
        supportFragmentManager.beginTransaction().apply {
            // ths takes the id where to put the fragment and what what fragment is to put.
            replace(R.id.flFragment, firstFragment)
            commit() // This is necessary as without this, no changes will be displayed.
        }

        val btnFragment1 = findViewById<Button>(R.id.btnFragment1)
        val btnFragment2 = findViewById<Button>(R.id.btnFragment2)

        btnFragment1.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, firstFragment)
                addToBackStack(null) // this line of code is necessary if you want to implement the back button feature
                commit()
            }
        }

        btnFragment2.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, secondFragment)
                addToBackStack(null) // this line of code is necessary if you want to implement the back button feature
                commit()
            }
        }
    }
}

/*
STEPS/NOTES :
1. Make <fragment> in the activity_main.xml file. while doing so, it may be possible that your design stop showing up.
2. Add Fragments using right clicking on the directory -> new -> Fragments -> Fragments(Blank)
3. That will generate a whole lot of boiler code, can delete that easily,
    just pass the corresponding layout( which gets build with it,) as the Constructor of the Fragment() class.
    EXAMPLE : class FirstFragment : Fragment(R.layout.fragment_first) { }
4. Now add tools:layout="@layout/fragment_first" to the fragments tag in the activity_main.xml file and you gets your design showing back
5. The fragments which gets attached statically, to attach it dynamically, one need to use FrameLayout
6. On doing the FrameLayout, we need to remove the tools:layout="@layout/fragment_first".
7. Create the firstFragment and SecondFragment instances.
8. Now follow the code as it is.

ONE IMPORTANT THING TO NOTE: When you press back button, after switching 3-4 times between the fragments, by default it will directly exit the app,
    it doesn't go to the prev used fragment as it is not stored in the stack.
    To implement that feature you need to add addToBackStack(null) in the both setOnClickListeners after replace functions is called.
 */