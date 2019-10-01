package com.anttek.slack.api.model

/**
 * Slack's Blockkit
 * https://api.slack.com/reference/messaging/blocks
 */

class ChatMessageRequest(
        var token: String? = null,
        var channel: String? = null,
        var text: String? = null,
        var as_user: Boolean? = null,
        var blocks: List<BaseBlock>? = null, // maximum 50 blocks
        val icon_emoji: String? = null,
        val icon_url: String? = null,
        val link_names: Boolean? = null,
        val parse: String? = null,
        val reply_broadcast: Boolean? = null,
        val thread_ts: String? = null,
        val unfurl_links: Boolean? = null,
        val unfurl_media: Boolean? = null,
        val username: String? = null,
        val mrkdwn: Boolean? = null
)

// object https://api.slack.com/reference/messaging/composition-objects
abstract class TextObject(val type: String ) {
        companion object {
                const val TYPE_PLAIN_TEXT = "plain_text"
                const val TYPE_MARKDOWN = "mrkdwn"
        }
}

class PlainTextObject(val text: String
                      , val emoji: Boolean? = null
                      , val verbatim: Boolean? = null) : TextObject(TYPE_PLAIN_TEXT)

class MrkdwnTextObject(var text: String
                       , val emoji: Boolean? = null
                       , val verbatim: Boolean? = null) : TextObject(TYPE_MARKDOWN)

class ConfirmObject(val title: PlainTextObject,
                    val text: TextObject,
                    val confirm: PlainTextObject,
                    val deny: PlainTextObject)

class OptionObject(val text: PlainTextObject,
                   val value: String,
                   val url: String? = null)

class OptionGroupObject(val label: PlainTextObject,
                        val options: List<OptionObject>)

// elements https://api.slack.com/reference/messaging/block-elements

open class BlockElement(val type: String) {
        companion object {
                const val TYPE_IMAGE = "image"
                const val TYPE_STATIC_SELECT = "static_select"
                const val TYPE_USER_SELECT = "users_select"
                const val TYPE_CONVERSATIONS_SELECT = "conversations_select"
                const val TYPE_CHANNELS_SELECT = "channels_select"
                const val TYPE_OVERFLOW = "overflow"
                const val TYPE_DATE_PICKER = "datepicker"
        }
}

class ImageElement(val image_url: String,
                   val alt_text: String) : BlockElement(TYPE_IMAGE)

class ButtonElement(val text: PlainTextObject,
                    val action_id: String,
                    val value: String? = null,
                    val url: String? = null,
                    val style: String? = null,
                    val confirm: ConfirmObject? = null) : BlockElement("button") {
        companion object {
                const val STYLE_PRIMARY = "primary"
                const val STYLE_DANGER = "danger"
        }
}

class SelectStaticElement(
        val placeholder: PlainTextObject,
        val action_id: String,
        val options: List<OptionObject>? = null,
        val option_groups: List<OptionGroupObject>? = null,
        val initial_option: OptionObject? = null,
        val confirm: ConfirmObject? = null
) : BlockElement(TYPE_STATIC_SELECT)

class SelectUserElement(
        val placeholder: PlainTextObject,
        val action_id: String,
        val initial_user: String? = null,
        val confirm: ConfirmObject? = null
) : BlockElement(TYPE_USER_SELECT)

class SelectConversationsElement(
        val placeholder: PlainTextObject,
        val action_id: String,
        val initial_conversation: String? = null,
        val confirm: ConfirmObject? = null
) : BlockElement(TYPE_CONVERSATIONS_SELECT)

class SelectChannelsElement(
        val placeholder: PlainTextObject,
        val action_id: String,
        val initial_channel: String? = null,
        val confirm: ConfirmObject? = null
) : BlockElement(TYPE_CHANNELS_SELECT)

class OverflowElement(
        val action_id: String,
        /** 2-5 options */
        val options: List<OptionObject>,
        val confirm: ConfirmObject? = null
) : BlockElement(TYPE_OVERFLOW)

class DatePickerElement(
        val action_id: String,
        val placeholder: PlainTextObject? = null,
        /** format YYYY-MM-DD*/
        val initial_date: String? = null,
        val confirm: ConfirmObject? = null
) : BlockElement(TYPE_DATE_PICKER)

// blocks
open class BaseBlock(val type: String
        /** max 255 chars */
                     , val block_id: String? = null
) {
        companion object {
                const val TYPE_SECTION = "section"
                const val TYPE_DIVIDER = "divider"
                const val TYPE_ACTIONS = "actions"
                const val TYPE_CONTEXT = "context"
        }

        fun estimateSize(): Int {
                return 1
        }

}

class SectionBlock(
        /** max 3000 chars */
        val text: TextObject? = null
        , block_id: String? = null
        /** max 10 items, 2000 chars/item */
        , var fields: List<MrkdwnTextObject>? = null
        , val accessory: BlockElement? = null
) : BaseBlock(TYPE_SECTION, block_id)

class DividerBlock(block_id: String? = null) : BaseBlock(TYPE_DIVIDER, block_id)

class ImageBlock(
        /** max 3000 chars */
        val image_url: String
        /** max 2000 chars */
        , val alt_text: String
        /** max 2000 chars */
        , val title: PlainTextObject? = null
        , block_id: String? = null
) : BaseBlock("image", block_id)


class ActionBlock(
        /** max 5 elements */
        val elements: List<BlockElement>
        , block_id: String? = null
) : BaseBlock(TYPE_ACTIONS, block_id)

class ContextBlock(
        /** image elements or text object, max 10 elements */
        val elements: List<Any>
        , block_id: String? = null

) : BaseBlock(TYPE_CONTEXT, block_id)
