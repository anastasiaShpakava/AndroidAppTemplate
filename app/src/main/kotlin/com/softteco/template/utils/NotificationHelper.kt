package com.softteco.template.utils

import android.content.Context
import android.widget.RemoteViews
import com.google.firebase.messaging.RemoteMessage
import com.google.mlkit.nl.smartreply.SmartReply
import com.google.mlkit.nl.smartreply.SmartReplySuggestionResult
import com.google.mlkit.nl.smartreply.TextMessage
import com.softteco.template.R
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlinx.coroutines.suspendCancellableCoroutine

class NotificationHelper @Inject constructor(private val context: Context) {
    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    private var repliesList = mutableListOf<String>()
    fun createNotificationLayout(message: RemoteMessage.Notification): RemoteViews {
        val notificationLayout =
            RemoteViews(context.packageName, R.layout.notification_content_view)
        notificationLayout.setTextViewText(R.id.notification_title, message.title)
        notificationLayout.setTextViewText(R.id.notification_body, message.body)
        return notificationLayout
    }

    fun createNotificationContentLayout(message: RemoteMessage.Notification): RemoteViews {
        val notificationLayout =
            RemoteViews(context.packageName, R.layout.notification_replies_view)
        coroutineScope.launch {
            notificationLayout.setTextViewText(R.id.choiсe_first_text, repliesList[0])
            notificationLayout.setTextViewText(R.id.choiсe_second_text, repliesList[1])
            notificationLayout.setTextViewText(R.id.choiсe_third_text, repliesList[2])

            notificationLayout.setTextViewText(R.id.notification_title_content, message.title)
            notificationLayout.setTextViewText(R.id.notification_body_content, message.body)
        }
        return notificationLayout
    }

    suspend fun getChoiceList(message: RemoteMessage.Notification): MutableList<String> =
        suspendCancellableCoroutine { continuation ->

            val conversation = mutableListOf<TextMessage>()
            val smartReplyGenerator = SmartReply.getClient()
            conversation.add(
                TextMessage.createForLocalUser(
                    message.body.toString(), System.currentTimeMillis()
                )
            )
            smartReplyGenerator.suggestReplies(conversation).addOnSuccessListener { result ->
                    if (result.status == SmartReplySuggestionResult.STATUS_SUCCESS) {
                        for (suggestion in result.suggestions) {
                            val replyText = suggestion.text.replace("\n", "")
                            repliesList.add(replyText)
                        }
                    }
                    continuation.resume(repliesList)
                }.addOnFailureListener {
                    continuation.resumeWithException(it)
                }
        }
}