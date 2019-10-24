package com.baegoon.protocol.validation.validator

import com.google.protobuf.Descriptors

class RegexValidator : Validator {

    override fun <T> validate(fieldName: String, fieldValue: T, rule: Map.Entry<Descriptors.FieldDescriptor, Any>): Boolean {
        val regex = rule.value.toString().toRegex()

        return regex.matches(fieldValue.toString())
    }
}
