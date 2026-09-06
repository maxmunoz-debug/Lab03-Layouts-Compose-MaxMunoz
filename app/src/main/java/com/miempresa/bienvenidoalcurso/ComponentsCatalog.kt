package com.miempresa.bienvenidoalcurso

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// =========================================================================
// 1. CONTENEDORES (LAYOUTS)
// =========================================================================

// 1. LAZY COLUMN
@Composable
fun EjemploLazyColumn() {
    val itemsList = listOf("Elemento 1", "Elemento 2", "Elemento 3", "Elemento 4", "Elemento 5")
    LazyColumn(
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(itemsList) { item ->
            Card(modifier = Modifier.fillMaxWidth()) {
                Text(text = item, modifier = Modifier.padding(16.dp))
            }
        }
    }
}
@Preview(showBackground = true, name = "1. LazyColumn")
@Composable
fun PreviewLazyColumn() { EjemploLazyColumn() }

// 2. LAZY ROW
@Composable
fun EjemploLazyRow() {
    val itemsList = listOf("Card 1", "Card 2", "Card 3", "Card 4", "Card 5")
    LazyRow(
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(itemsList) { item ->
            Card(modifier = Modifier.size(width = 120.dp, height = 80.dp)) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text(text = item)
                }
            }
        }
    }
}
@Preview(showBackground = true, name = "2. LazyRow")
@Composable
fun PreviewLazyRow() { EjemploLazyRow() }

// 3. GRID (LazyVerticalGrid)
@Composable
fun EjemploGrid() {
    val itemsList = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6")
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxWidth().height(180.dp).padding(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(itemsList.size) { index ->
            Card(modifier = Modifier.height(70.dp)) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text(text = itemsList[index])
                }
            }
        }
    }
}
@Preview(showBackground = true, name = "3. LazyVerticalGrid")
@Composable
fun PreviewGrid() { EjemploGrid() }

// 4. SCAFFOLD
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EjemploScaffold() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("App Scaffold") },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {}) {
                Text("+", style = MaterialTheme.typography.titleLarge)
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier.fillMaxWidth().height(150.dp).padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
            Text("Contenido dentro de Scaffold")
        }
    }
}
@Preview(showBackground = true, name = "4. Scaffold")
@Composable
fun PreviewScaffold() { EjemploScaffold() }

// 5. SURFACE
@Composable
fun EjemploSurface() {
    Surface(
        modifier = Modifier.padding(16.dp),
        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colorScheme.secondaryContainer,
        shadowElevation = 6.dp
    ) {
        Text(
            text = "Surface con elevación y bordes redondeados.",
            modifier = Modifier.padding(20.dp),
            color = MaterialTheme.colorScheme.onSecondaryContainer
        )
    }
}
@Preview(showBackground = true, name = "5. Surface")
@Composable
fun PreviewSurface() { EjemploSurface() }

// 6. CHIP
@Composable
fun EjemploChip() {
    Row(
        modifier = Modifier.padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        AssistChip(onClick = {}, label = { Text("Opción 1") })
        AssistChip(onClick = {}, label = { Text("Opción 2") })
    }
}
@Preview(showBackground = true, name = "6. Chip")
@Composable
fun PreviewChip() { EjemploChip() }

// 7. FLOW ROW
@OptIn(ExperimentalLayoutApi::class)
@Composable
fun EjemploFlowRow() {
    val tags = listOf("Kotlin", "Jetpack Compose", "Android", "Material 3", "UI", "Mobile")
    FlowRow(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        tags.forEach { tag ->
            SuggestionChip(onClick = {}, label = { Text(tag) })
        }
    }
}
@Preview(showBackground = true, name = "7. FlowRow")
@Composable
fun PreviewFlowRow() { EjemploFlowRow() }

// 8. FLOW COLUMN
@OptIn(ExperimentalLayoutApi::class)
@Composable
fun EjemploFlowColumn() {
    val items = listOf("A1", "A2", "B1", "B2", "C1", "C2")
    FlowColumn(
        modifier = Modifier.height(120.dp).padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items.forEach { item ->
            AssistChip(onClick = {}, label = { Text(item) })
        }
    }
}
@Preview(showBackground = true, name = "8. FlowColumn")
@Composable
fun PreviewFlowColumn() { EjemploFlowColumn() }

// =========================================================================
// 2. CONTROLES DE UI
// =========================================================================

// 9. CARD
@Composable
fun EjemploCard() {
    Card(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Título de Card", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Contenido dentro de una tarjeta Material 3.", style = MaterialTheme.typography.bodyMedium)
        }
    }
}
@Preview(showBackground = true, name = "9. Card")
@Composable
fun PreviewCard() { EjemploCard() }

// 10. CHECKBOX - RADIOBUTTON - SWITCH
@Composable
fun EjemploSeleccionables() {
    var checkedBox by remember { mutableStateOf(true) }
    var selectedRadio by remember { mutableStateOf(true) }
    var switched by remember { mutableStateOf(true) }

    Column(modifier = Modifier.padding(16.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = checkedBox, onCheckedChange = { checkedBox = it })
            Text("Checkbox activo")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = selectedRadio, onClick = { selectedRadio = !selectedRadio })
            Text("RadioButton seleccionado")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Switch(checked = switched, onCheckedChange = { switched = it })
            Spacer(modifier = Modifier.width(8.dp))
            Text("Switch")
        }
    }
}
@Preview(showBackground = true, name = "10. Checkbox-Radio-Switch")
@Composable
fun PreviewSeleccionables() { EjemploSeleccionables() }

// 11. PROGRESS BARS
@Composable
fun EjemploProgressBars() {
    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LinearProgressIndicator(progress = { 0.7f }, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(16.dp))
        CircularProgressIndicator(progress = { 0.7f })
    }
}
@Preview(showBackground = true, name = "11. ProgressBars")
@Composable
fun PreviewProgressBars() { EjemploProgressBars() }

// 12. SLIDER Y TEXT FIELD
@Composable
fun EjemploSliderYTextField() {
    var sliderValue by remember { mutableFloatStateOf(50f) }
    var textValue by remember { mutableStateOf("Texto de ejemplo") }

    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = textValue,
            onValueChange = { textValue = it },
            label = { Text("OutlinedTextField") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text("Slider: ${sliderValue.toInt()}%")
        Slider(
            value = sliderValue,
            onValueChange = { sliderValue = it },
            valueRange = 0f..100f
        )
    }
}
@Preview(showBackground = true, name = "12. Slider y TextField")
@Composable
fun PreviewSliderYTextField() { EjemploSliderYTextField() }

// 13. ALERT DIALOG
@Composable
fun EjemploAlertDialog() {
    AlertDialog(
        onDismissRequest = {},
        confirmButton = { TextButton(onClick = {}) { Text("Aceptar") } },
        dismissButton = { TextButton(onClick = {}) { Text("Cancelar") } },
        title = { Text("Título AlertDialog") },
        text = { Text("Este es un diálogo de alerta estándar en Jetpack Compose.") }
    )
}
@Preview(showBackground = true, name = "13. AlertDialog")
@Composable
fun PreviewAlertDialog() { EjemploAlertDialog() }

// 14. NAVIGATION BAR (Bottom Navigation)
@Composable
fun EjemploNavigationBar() {
    var selectedItem by remember { mutableIntStateOf(0) }
    val items = listOf("Inicio", "Buscar", "Perfil")
    val icons = listOf("🏠", "🔍", "👤")

    NavigationBar {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = { Text(icons[index]) },
                label = { Text(item) },
                selected = selectedItem == index,
                onClick = { selectedItem = index }
            )
        }
    }
}
@Preview(showBackground = true, name = "14. NavigationBar")
@Composable
fun PreviewNavigationBar() { EjemploNavigationBar() }

// 15. TAB ROW & DIVIDER
@Composable
fun EjemploTabRow() {
    var selectedTab by remember { mutableIntStateOf(0) }
    val tabs = listOf("Tab 1", "Tab 2", "Tab 3")

    Column(modifier = Modifier.fillMaxWidth()) {
        TabRow(selectedTabIndex = selectedTab) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTab == index,
                    onClick = { selectedTab = index },
                    text = { Text(title) }
                )
            }
        }
        HorizontalDivider(thickness = 2.dp, color = MaterialTheme.colorScheme.outlineVariant)
        Box(modifier = Modifier.fillMaxWidth().height(60.dp), contentAlignment = Alignment.Center) {
            Text("Contenido de ${tabs[selectedTab]}")
        }
    }
}
@Preview(showBackground = true, name = "15. TabRow")
@Composable
fun PreviewTabRow() { EjemploTabRow() }

// 16. SNACKBAR & FAB
@Composable
fun EjemploSnackbarYFAB() {
    Column(modifier = Modifier.padding(16.dp)) {
        Snackbar(
            action = { TextButton(onClick = {}) { Text("Deshacer", color = Color.Yellow) } }
        ) {
            Text("Este es un mensaje Snackbar informativo.")
        }
        Spacer(modifier = Modifier.height(16.dp))
        FloatingActionButton(onClick = {}) {
            Text("+", style = MaterialTheme.typography.titleLarge)
        }
    }
}
@Preview(showBackground = true, name = "16. Snackbar & FAB")
@Composable
fun PreviewSnackbarYFAB() { EjemploSnackbarYFAB() }

// 17. HORIZONTAL PAGER
@Composable
fun EjemploPager() {
    val pagerState = rememberPagerState(pageCount = { 3 })
    Column(modifier = Modifier.fillMaxWidth().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxWidth().height(100.dp)
        ) { page ->
            Card(modifier = Modifier.fillMaxSize()) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text("Página Pager: ${page + 1}", style = MaterialTheme.typography.titleMedium)
                }
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text("Desliza horizontalmente")
    }
}
@Preview(showBackground = true, name = "17. HorizontalPager")
@Composable
fun PreviewPager() { EjemploPager() }