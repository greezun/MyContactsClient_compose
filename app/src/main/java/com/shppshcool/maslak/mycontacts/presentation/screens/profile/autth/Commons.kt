package com.shppshcool.maslak.mycontacts.presentation.screens.profile.autth


import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import com.shppshcool.maslak.mycontacts.data.model.auth.SpanText
import com.shppshcool.maslak.mycontacts.ui.theme.GrayText2

@Composable
fun SpannedClickableText(
    modifier: Modifier = Modifier,
    fullText: String,
    spans: List<SpanText>,
    style: TextStyle = MaterialTheme.typography.labelSmall,
    defaultColor: Color = GrayText2,
    clickableColor: Color = MaterialTheme.colorScheme.onPrimary
) {
    val annotatedString = buildAnnotatedString {
        var lastIndex = 0
        spans.forEach { span ->
            val start = fullText.indexOf(span.text, lastIndex)
            val end = start + span.text.length
            if (start >= 0) {
                append(fullText.substring(lastIndex, start))
                pushStringAnnotation(tag = "CLICKABLE", annotation = span.text)
                withStyle(style = SpanStyle(color = clickableColor)) {
                    append(span.text)
                }
                pop()
                lastIndex = end
            }
        }
        if (lastIndex < fullText.length) {
            append(fullText.substring(lastIndex))
        }
    }

    val layoutResult = remember { mutableStateOf<TextLayoutResult?>(null) }

    BasicText(
        text = annotatedString,
        style = style.copy(color = defaultColor, textAlign = TextAlign.Center),
        onTextLayout = { layoutResult.value = it },
        modifier = modifier.pointerInput(Unit) {
            detectTapGestures { offset ->
                layoutResult.value?.let { layoutResult ->
                    val position = layoutResult.getOffsetForPosition(offset)
                    annotatedString.getStringAnnotations(
                        tag = "CLICKABLE",
                        start = position,
                        end = position
                    ).firstOrNull()?.let { annotation ->
                        spans.find { it.text == annotation.item }?.onClick?.invoke()
                    }
                }
            }
        }
    )
}