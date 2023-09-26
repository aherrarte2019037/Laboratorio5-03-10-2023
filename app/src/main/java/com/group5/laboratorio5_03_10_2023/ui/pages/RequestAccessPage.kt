package com.group5.laboratorio5_03_10_2023.ui.pages

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.group5.laboratorio5_03_10_2023.io.ApiConfig
import com.group5.laboratorio5_03_10_2023.io.ApiService
import kotlinx.coroutines.launch

@Composable
fun RequestAccessPage(navController: NavController, apiService: ApiService) {
    val scope = rememberCoroutineScope()

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        val context = LocalContext.current

        Button(onClick = {
            scope.launch {
                val response = apiService.requestAccess(
                    clientId = ApiConfig.CLIENT_ID,
                    clientSecret = ApiConfig.CLIENT_SECRET
                )

                if (response.isSuccessful) {
                    response.body()?.let { apiResponse ->
                        Log.v("Request", apiResponse.toString());
                    }
                } else {
                    Toast.makeText(context, "Error, intenta otra vez", Toast.LENGTH_SHORT).show()
                }
            }
        }) {
            Text(text = "Request Access")
        }
    }
}
