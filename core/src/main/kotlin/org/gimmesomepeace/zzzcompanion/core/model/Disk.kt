package org.zzzcompanion.disks.model


data class Disk (
    val id: String,
    val name: String,
    val imageUrl: String
) {
    companion object {
        fun placeholder(): org.zzzcompanion.disks.model.Disk {
            return _root_ide_package_.org.zzzcompanion.disks.model.Disk(
                id = "-1",
                name = "placeholder",
                imageUrl = "https://media.tenor.com/TwW9AVtpBCYAAAAM/boykiseer-blink.gif"
            )
        }
    }
}