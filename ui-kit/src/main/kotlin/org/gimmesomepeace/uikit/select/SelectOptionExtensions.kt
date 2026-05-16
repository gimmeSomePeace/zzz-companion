package org.gimmesomepeace.uikit.select

fun <T> SelectOption<T>.toValueOrNull(): T? {
    return when (this) {
        is SelectOption.Item -> value
        SelectOption.All -> null
    }
}

fun <T> SelectOption<T>.matches(selected: T?): Boolean {
    return when (this) {
        is SelectOption.Item -> this.value == selected
        SelectOption.All -> selected == null
    }
}

fun <T> List<SelectOption<T>>.selectedOrAll(selected: T?): SelectOption<T> {
    return this.find { it.matches(selected) } ?: SelectOption.All
}
