package five.denisbuketa.androidvjestina.navigation

sealed class Screen(val route: String) {
    object Notes : Screen("Notes")
    object SaveNote : Screen("SaveNote")
}