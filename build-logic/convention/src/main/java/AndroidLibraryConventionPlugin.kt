import com.android.build.gradle.LibraryExtension
import com.evirgenoguz.convention.ExtensionType
import com.evirgenoguz.convention.configureBuildTypes
import com.evirgenoguz.convention.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.kotlin

class AndroidLibraryConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        target.run {
            target.run {
                pluginManager.run {
                    apply("com.android.library")
                    apply("org.jetbrains.kotlin.android")
                }
                extensions.configure<LibraryExtension> {
                    configureKotlinAndroid(this)
                    configureBuildTypes(
                        commonExtension = this,
                        extensionType = ExtensionType.LIBRARY
                    )
                    defaultConfig {
                        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                        consumerProguardFiles("consumer-rules.pro")
                    }
                }
                dependencies {
                    "testImplementation"(kotlin("test"))
                }
            }
        }
    }
}