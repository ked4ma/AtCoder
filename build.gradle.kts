import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    alias(libs.plugins.kotlin.jvm)
    application
}

group = "com.github.ked4ma.atcoder"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

sourceSets {
    if (hasProperty("contest")) {
        println("src/main/kotlin/com/github/ked4ma/atcoder/${findProperty("contest")}")
        getByName("main").kotlin.setSrcDirs(
            setOf(
                "src/main/kotlin/com/github/ked4ma/atcoder/${findProperty("contest")}",
                "src/main/kotlin/com/github/ked4ma/atcoder/utils/"
            )
        )
    } else if (hasProperty("problems")) {
        getByName("main").kotlin.setSrcDirs(
            setOf(
                "src/main/kotlin/com/github/ked4ma/atcoder/problems",
                "src/main/kotlin/com/github/ked4ma/atcoder/utils/"
            )
        )
    }
}

dependencies {
    testImplementation(libs.junit.jupiter)
    testImplementation(libs.kotlinx.coroutines.core)
    testImplementation(libs.ktor.client.core)
    testImplementation(libs.ktor.client.cio)
    testImplementation(libs.jsoup)
}

tasks.withType<Test> {
    useJUnitPlatform()
    testLogging {
        events(TestLogEvent.FAILED, TestLogEvent.PASSED)
        exceptionFormat = TestExceptionFormat.FULL
        showStandardStreams = true
        showStackTraces = true
        showExceptions = true
    }

    systemProperty("task", System.getProperty("task"))
    systemProperty("branch", System.getProperty("branch"))
}

application {
    mainClass.set(
        project.properties.getOrDefault(
            "mainClass",
            "com.github.ked4ma.atcoder.template.simple.SampleKt"
        ) as String
    )
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
//        vendor.set(JvmVendorSpec.ADOPTIUM)
    }
}

tasks.withType<Jar> {
    // Otherwise you'll get a "No main manifest attribute" error
    manifest {
        attributes["Main-Class"] = project.properties.getOrDefault(
            "mainClass",
            "com.github.ked4ma.atcoder.template.simple.SampleKt"
        )
    }

    // To add all of the dependencies otherwise a "NoClassDefFoundError" error
    from(sourceSets.main.get().output)

    dependsOn(configurations.runtimeClasspath)
    from({
        configurations.runtimeClasspath.get().filter { it.name.endsWith("jar") }.map { zipTree(it) }
    })
}

val run: JavaExec by tasks
run.standardInput = System.`in`

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "17"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "17"
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions.freeCompilerArgs += "-Xopt-in=kotlin.RequiresOptIn"
}
