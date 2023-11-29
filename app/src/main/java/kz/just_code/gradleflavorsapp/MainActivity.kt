package kz.just_code.gradleflavorsapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kz.just_code.gradleflavorsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.fields.text = "BUILD_TYPE: ${BuildConfig.BUILD_TYPE}\n" +
                "APPLICATION_ID: ${BuildConfig.APPLICATION_ID}\n" +
                "DEBUG: ${BuildConfig.DEBUG}\n" +
                "VERSION_CODE: ${BuildConfig.VERSION_CODE}\n" +
                "VERSION_NAME: ${BuildConfig.VERSION_NAME}\n\n" +
                "URL: ${BuildConfig.BASE_MAIN_URL}\n" +
                "BUILD_NAME: ${BuildConfig.BUILD_NAME}"
    }

}