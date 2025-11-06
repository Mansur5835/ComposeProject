// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.kotlin.parcelize) apply false
    id("vkid.manifest.placeholders") version "1.1.0" apply true
}




vkidManifestPlaceholders {
    init(
        clientId = "54292720",
        clientSecret = "DfmOVpC6mv1nCcVpvCFi"
    )

    vkidRedirectHost = "vk.ru"
    vkidRedirectScheme = "vk54292720"
    vkidClientId = "54292720"
    vkidClientSecret = "DfmOVpC6mv1nCcVpvCFi"
}

//vkidManifestPlaceholders {
//    // Qiymatlarni qisqartirilgan usulda qo‘shish. Masalan, vkidRedirectHost “vk.ru” bo‘ladi,
//    // vkidRedirectScheme esa “vk$clientId” ko‘rinishida bo‘ladi.
//    init(
//        clientId = clientId,
//        clientSecret = clientSecret,
//    )
//    // Yoki agar placeholders ishlatmoqchi bo‘lmasangiz, qiymatlarni aniq ko‘rsating.
//    vkidRedirectHost = "vk.ru" // Odatda vk.ru
//    vkidRedirectScheme = "vk1233445" // Format qat’iy — vk{ilova ID}
//    vkidClientId = clientId
//    vkidClientSecret = clientSecret
//}