package org.zzzcompanion.disks.model


data class Disk (
    val id: Int,
    val name: String,
    val imageUrl: String
) {
    companion object {
        fun placeholder(): Disk {
            return Disk(
                id = -1,
                name = "placeholder",
                imageUrl = "https://media.tenor.com/TwW9AVtpBCYAAAAM/boykiseer-blink.gif"
            )
        }
    }
}