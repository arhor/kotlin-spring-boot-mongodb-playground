pluginManagement {
    plugins {
        fun prop(name: String): String = extra[name].toString()

        // @formatter:off
        id("io.spring.dependency-management")    version prop("versions.spring-dependency-management")
        id("org.graalvm.buildtools.native")      version prop("versions.native-build-tool")
        id("org.jetbrains.kotlin.jvm")           version prop("versions.kotlin")
        id("org.jetbrains.kotlin.kapt")          version prop("versions.kotlin")
        id("org.jetbrains.kotlin.plugin.spring") version prop("versions.kotlin")
        id("org.springframework.boot")           version prop("versions.spring-boot")
        // @formatter:on
    }
}

rootProject.name = "kotlin-spring-boot-mongodb-playground"
