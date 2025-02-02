plugins {
    alias(libs.plugins.runique.android.library.compose)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.evirgenoguz.core.presentation.ui"
}

dependencies {

    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.lifecycle.runtime.compose)
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)

    implementation(projects.core.domain)
    implementation(projects.core.presentation.designsystem)
}