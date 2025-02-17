@file:OptIn(ExperimentalMaterial3Api::class)

package com.evirgenoguz.run.presentation.run_overview

import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.evirgenoguz.core.presentation.designsystem.AnalyticsIcon
import com.evirgenoguz.core.presentation.designsystem.LogoIcon
import com.evirgenoguz.core.presentation.designsystem.LogoutIcon
import com.evirgenoguz.core.presentation.designsystem.RunIcon
import com.evirgenoguz.core.presentation.designsystem.RuniqueTheme
import com.evirgenoguz.core.presentation.designsystem.components.RuniqueFloatingActionButton
import com.evirgenoguz.core.presentation.designsystem.components.RuniqueScaffold
import com.evirgenoguz.core.presentation.designsystem.components.RuniqueToolbar
import com.evirgenoguz.core.presentation.designsystem.components.util.DropDownItem
import com.evirgenoguz.run.presentation.R
import org.koin.androidx.compose.koinViewModel

@Composable
fun RunOverviewScreenRoot(
    viewModel: RunOverviewViewModel = koinViewModel()
) {
    RunOverViewScreen(
        onAction = viewModel::onAction
    )
}

@Composable
fun RunOverViewScreen(
    onAction: (RunOverviewAction) -> Unit
) {
    val topAppBarState = rememberTopAppBarState()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(
        state = topAppBarState
    )

    RuniqueScaffold(
        topAppBar = {
            RuniqueToolbar(
                showBackButton = false,
                title = stringResource(R.string.runique),
                scrollBehavior = scrollBehavior,
                menuItems = listOf(
                    DropDownItem(
                        icon = AnalyticsIcon,
                        title = stringResource(R.string.analytics)
                    ),
                    DropDownItem(
                        icon = LogoutIcon,
                        title = stringResource(R.string.logout)
                    )
                ),
                onMenuItemClick = {
                    when (it) {
                        0 -> onAction(RunOverviewAction.OnAnalyticsClick)
                        1 -> onAction(RunOverviewAction.OnLogoutClick)
                    }
                },
                startContent = {
                    Icon(
                        imageVector = LogoIcon,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(35.dp)
                    )
                }
            )
        },
        floatingActionButton = {
            RuniqueFloatingActionButton(
                icon = RunIcon,
                onClick = { onAction(RunOverviewAction.OnStartClick) }
            )
        }
    ) { paddingValues ->
        
    }
}

@Preview
@Composable
fun RunOverViewScreenPreview() {
    RuniqueTheme {
        RunOverViewScreen(
            onAction = {}
        )
    }
}
