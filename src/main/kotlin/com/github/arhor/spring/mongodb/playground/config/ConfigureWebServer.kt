package com.github.arhor.spring.mongodb.playground.config

import com.github.arhor.spring.mongodb.playground.config.props.ApplicationProps
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Configuration
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.method.HandlerTypePredicate.forAnnotation
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(ApplicationProps::class)
class ConfigureWebServer(private val applicationProps: ApplicationProps) : WebMvcConfigurer {

    override fun configurePathMatch(configurer: PathMatchConfigurer) {
        configurer.addPathPrefix(applicationProps.apiPathPrefix, classesAnnotatedWith<RestController>())
    }

    companion object {
        private inline fun <reified T : Annotation> classesAnnotatedWith() = forAnnotation(T::class.java)
    }
}

