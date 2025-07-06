plugins {
    alias(libs.plugins.runique.android.dynamic.feature)
    alias(libs.plugins.kotlin.compose)
}
android {
    namespace = "com.evirgenoguz.analytics.analytics_feature"

}

dependencies {
    implementation(project(":app"))

    api(projects.analytics.presentation)
    implementation(projects.analytics.domain)
    implementation(projects.analytics.data)
    implementation(projects.core.database)

    implementation(libs.androidx.navigation.compose)
}