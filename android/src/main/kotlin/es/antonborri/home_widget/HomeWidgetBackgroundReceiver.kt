package es.antonborri.home_widget

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import io.flutter.FlutterInjector

class HomeWidgetBackgroundReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val flutterLoader = FlutterInjector.instance().flutterLoader()
        flutterLoader.startInitialization(context)
        flutterLoader.ensureInitializationComplete(context, null)
        HomeWidgetBackgroundService.enqueueWork(context, intent)
        if (intent.hasExtra("toast")) {
            Toast.makeText(context, intent.getStringExtra("toast"), Toast.LENGTH_SHORT).show();
        }
    }
}