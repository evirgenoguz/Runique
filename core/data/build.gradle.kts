plugins {
    alias(libs.plugins.runique.android.library)
}

android {
    namespace = "com.evirgenoguz.core.data"

    defaultConfig {

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

}

dependencies {

    implementation(libs.timber)

    implementation(projects.core.domain)
    implementation(projects.core.database)
}