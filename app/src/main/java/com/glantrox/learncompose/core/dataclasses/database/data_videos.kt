package com.glantrox.learncompose.core.dataclasses.database

import com.glantrox.learncompose.core.dataclasses.models.VideosModel

class AppDatabase {
    val videos: List<VideosModel> = listOf(
        VideosModel(1,
            "Staying in Starbucks until I see a middle aged white woman",
            "manlikeisaaac",
            "https://yt3.ggpht.com/CwhauMuAeSCAfn0--2BVSSZROHB8glzbxixUTH2clGVP6kxYFFrcYbdLVldzjlVaWkXfSLjDPeI=s88-c-k-c0x00ffffff-no-rj",
            "https://i.ytimg.com/vi/flg0qmiryEM/maxresdefault.jpg",
            315.588,"0:16",
            false,
            "May 5, 2023",
            "My next video will be walking into KFC until I see a N-\n" +
                    "\n",
            "3.540.000"
        ),
        VideosModel(2,
            "I asked ai to make a Joe Biden mcdonalds commercial",
            "Crypto Tea",
            "https://yt3.ggpht.com/5V4SLCXuGfWA2gLOX3XPztOTYXm3fF7OdJ8ZBQ6w9H82dmkqe8uvPwc6jjE0QVkGksKp6fiEUw=s88-c-k-c0x00ffffff-no-rj",
            "https://i.ytimg.com/vi/O2wrBt7QaXM/maxresdefault.jpg",
            447.300,
            "0:30",
            false,
            "May 22, 2023",
            "let me know what commercial you want ai to make next my friends\n" +
                    "\n" +
                    "don't forget to like and sub!\n" +
                    "\n" +
                    "xoxo love u\n" +
                    "alexa\n" +
                    "\n" +
                    "twitter: cryptotea_",
            "2.860"
        ),
        VideosModel(1,
            "Live Streaming tvOne 24 Jam",
            "tvOneNews",
            "https://yt3.ggpht.com/ri6EHwA3ihlmWwrWsPN_rWeHkClwd5xkt7_SQ-cfDrA-UdOdOD7z0gDGgIHLF2Ryo1x00x1U=s88-c-k-c0x00ffffff-no-rj",
            "https://i.ytimg.com/vi/yNKvkPJl-tg/maxresdefault.jpg?v=646726bd",
            1.058,
            "",
            true,
            "Started streaming on Jun 8, 2022",
            "Saksikan program-program unggulan tvOne seperti Kabar Siang, Kabar Petang, Apa Kabar Indonesia Pagi, Apa Kabar Indonesia Malam, serta program talk show tvOne seperti Catatan Demokrasi tvOne, Fakta, Dua Sisi, Damai Indonesiaku dan program-program lainnya secara langsung melalui live streaming di channel tvOnenenews.\n" +
                    "\n" +
                    "#tvOne #tvOnenews #LiveStreaming",
            "10.700.000"
        )
    )
}