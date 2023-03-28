pluginManagement {
    plugins {
        fun prop(name: String): String = extra[name].toString()

        // @formatter:off
        id("org.jetbrains.kotlin.jvm")           version prop("versions.kotlin")
        id("org.jetbrains.kotlin.kapt")          version prop("versions.kotlin")
        id("org.jetbrains.kotlin.plugin.spring") version prop("versions.kotlin")
        id("org.springframework.boot")           version prop("versions.spring-boot")
        id("io.spring.dependency-management")    version prop("versions.spring-dependency-management")
        // @formatter:on
    }
}

rootProject.name = "kotlin-spring-boot-mongodb-playground"
