package com.github.arhor.spring.mongodb.playground.config

import org.springframework.aot.hint.RuntimeHints
import org.springframework.aot.hint.RuntimeHintsRegistrar

class ConfigureNativeHints : RuntimeHintsRegistrar {

    override fun registerHints(hint: RuntimeHints, classLoader: ClassLoader?) {
        hint.resources()
            .registerPattern("messages*.properties")
    }
}
