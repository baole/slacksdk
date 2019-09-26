package com.anttek.slack.callback


data class Field(var title: String? = null,
                 var value: String? = null,
                 var short: Boolean = true) {
    fun estimateSize(): Int {
        return 30 + (title?.length ?: 0) + (value?.length ?: 0)
//        if(title == null) 0 else title!!.length +
//                if(value == null) 0 else value!!.length + 30
    }
}

data class ActionOption(var text: String, var value: String)

data class Action(var name: String? = null,
                  var text: String? = null,
                  var type: String? = null,
                  var value: String? = null,
                  val options: List<ActionOption>? = null,
                  val selected_options: List<ActionOption>? = null,
                  val url: String? = null,
                  val style: String? = null
) {
    companion object {
        const val TYPE_BUTTON = "button"
        const val TYPE_SELECT = "select"
    }

    fun estimateSize(): Int {
        return (name?.length ?: 0) + (text?.length ?: 0) + (type?.length ?: 0) + (value?.length ?: 0) + 30
    }
}

//https://api.slack.com/docs/message-attachments
data class Attachment(var fallback: String? = null,
                      var color: String? = null,
                      var pretext: String? = null,
                      var author_name: String? = null,
                      var author_link: String? = null,
                      var author_icon: String? = null,
                      var title: String? = null,
                      var title_link: String? = null,
                      var text: String? = null,
                      var fields: MutableList<Field>? = null,
                      var image_url: String? = null,
                      val image_width: Int? = null,
                      val image_height: Int? = null,
                      val image_bytes: Int? = null,
                      val is_animated: Boolean? = null,
                      var thumb_url: String? = null,
                      var footer: String? = null,
                      var footer_icon: String? = null,
                      var mrkdwn_in: MutableList<String>? = null,
                      var actions: MutableList<Action>? = null,
                      var callback_id: String? = null,
                      var attachment_type: String? = null,
                      var files: List<EventFile>? = null,
                      var ts: String? = null) {
    fun estimateSize(): Int {
        var size = 0;
        size += (fallback?.length ?: 0)
        size += (color?.length ?: 0)
        size += (pretext?.length ?: 0)
        size += (author_name?.length ?: 0)
        size += (author_link?.length ?: 0)
        size += (author_icon?.length ?: 0)
        size += (title?.length ?: 0)
        size += (title_link?.length ?: 0)
        if (text != null) {
            size += (text!!.length * 1.06).toInt()
        }
        size += (image_url?.length ?: 0)
        size += (thumb_url?.length ?: 0)
        size += (footer?.length ?: 0)
        size += (footer_icon?.length ?: 0)
        size += (callback_id?.length ?: 0)
        size += (attachment_type?.length ?: 0)
        fields?.let {
            for (f in fields!!) size += f.estimateSize()
            size += fields!!.size * 12
        }

        actions?.let {
            for (a in actions!!) size += a.estimateSize()
            size += actions!!.size * 12
        }

        return size + 50
    }

    fun addField(item: Field) {
        if (fields == null) fields = mutableListOf()
        fields?.add(item)
    }
}

data class SelectOptionMessage(var label: String = "", var value: String = "")
data class ElementMessage(var type: String = TYPE_TEXT,
                          var label: String? = null,
                          var name: String? = null,
                          var hint: String? = null,
                          var placeholder: String? = null,
                          var value: String? = null,
                          var subtype: String? = null,
                          var max_length: Int = 1600,
                          var optional: Boolean? = false,
                          var options: MutableList<SelectOptionMessage>? = mutableListOf()
) {
    constructor(type: String, label: String?, name: String?, hint: String?, placeholder: String?, value: String?, optional: Boolean = false) :
            this(type, label, name, hint, placeholder, value, null, 1600, optional, null)

    companion object {
        const val TYPE_TEXT = "text"
        const val TYPE_TEXTAREA = "textarea"
        const val TYPE_SELECT = "select"

        const val SUB_TYPE_NUMBER = "number"
    }
}

data class DialogMessage(var callback_id: String? = null,
                         var title: String? = null,
                         var submit_label: String? = null,
                         var elements: MutableList<ElementMessage>? = mutableListOf()
)

