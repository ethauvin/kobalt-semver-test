import com.beust.kobalt.*
import com.beust.kobalt.plugin.packaging.*
import com.beust.kobalt.plugin.application.*
import com.beust.kobalt.plugin.apt.apt
import com.beust.kobalt.plugin.java.*

val repos = repos()
val processorJar = "net.thauvin.erik:semver:0.9.6-beta"


val p = project {

    name = "kobalt-semver-test"
    group = "com.example"
    artifactId = name
    version = "0.1"

    sourceDirectories {
        path("src/main/java")
    }

    sourceDirectoriesTest {
        path("src/test/java")
    }

    apt {
        outputDir = "/src/generated/java/"
    }

    dependencies {
        apt(processorJar)
        compile(processorJar)
    }

    dependenciesTest {
        compile("org.testng:testng:")

    }

    assemble {
        jar {
        }
    }

    application {
        mainClass = "com.example.Main"
    }

}
