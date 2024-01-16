package com.softteco.template.ui.feature.smartReply

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.mlkit.nl.smartreply.SmartReply
import com.google.mlkit.nl.smartreply.SmartReplySuggestionResult
import com.google.mlkit.nl.smartreply.TextMessage
import com.softteco.template.ui.components.CustomTopAppBar
import com.softteco.template.ui.theme.Dimens

@Composable
fun SmartReplyScreen(
    onBackClicked: () -> Unit
) {
    val conversation = mutableListOf<TextMessage>()

    var senderTxt by remember {
        mutableStateOf("")
    }
    var toastState by remember {
        mutableStateOf(false)
    }
    if(toastState){
        Toast.makeText(LocalContext.current, " The conversation's language isn't supported", Toast.LENGTH_SHORT).show()
    }
    val smartReplyGenerator = SmartReply.getClient()
    var replyState by remember { mutableStateOf(listOf<String>()) }

        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(Dimens.PaddingExtraLarge),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CustomTopAppBar(
                "Smart Reply",
                showBackIcon = true,
                modifier = Modifier.fillMaxWidth(),
                onBackClicked = onBackClicked
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Generated shot replies",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.secondary,
                    fontSize = 30.sp
                )
                LazyColumn {
                    items(replyState) {
                        ListItem(
                            headlineContent = {
                                Text(text = it)
                            })
                    }
                }
                Spacer(modifier = Modifier.height(Dimens.PaddingExtraLarge))

                Text(
                    text = "Sent messages",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.secondary,
                    fontSize = 30.sp
                )
                TextField(value = senderTxt, onValueChange = { senderTxt = it },
                    label = { Text(text = "Enter sender text") })

                Button(
                    shape = MaterialTheme.shapes.large,

                    modifier = Modifier
                        .padding(vertical = 10.dp),
                    onClick = {
                        conversation.add(
                            TextMessage.createForLocalUser(
                                senderTxt, System.currentTimeMillis()
                            )
                        )
                        replyState = emptyList()
                        smartReplyGenerator.suggestReplies(conversation)
                            .addOnSuccessListener { result ->
                                if (result.getStatus() == SmartReplySuggestionResult.STATUS_NOT_SUPPORTED_LANGUAGE) {
                                toastState = true
                                } else if (result.getStatus() == SmartReplySuggestionResult.STATUS_SUCCESS) {
                                    for (suggestion in result.suggestions) {
                                        val replyText = suggestion.text.replace("\n", "")
                                        replyState = replyState + replyText
                                    }
                                }
                                senderTxt = ""
                            }
                            .addOnFailureListener {
                                // Task failed with an exception
                                // ...
                            }
                    },
                ) {
                    Text(text = "Send")
                    toastState = false
                }

                Spacer(modifier = Modifier.height(Dimens.PaddingExtraLarge))
                Button(shape = MaterialTheme.shapes.large,
                    modifier = Modifier.padding(vertical = 10.dp),
                    onClick = { replyState = emptyList() }) {
                    Text(text = "Clear")
                }
            }
        }
    }


@Preview
@Composable
private fun Preview() {
    SmartReplyScreen(onBackClicked = {})
}