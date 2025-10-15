package com.ldv.apiseries.service

import com.ldv.apiseries.dto.EpisodeDTO
import com.ldv.apiseries.model.entity.Episode
import org.springframework.stereotype.Service
import java.time.format.DateTimeFormatter
import java.util.*

@Service
class EpisodeService {

    // Méthode pour convertir un Episode en EpisodeDTO
    fun convertToDTO(episode: Episode): EpisodeDTO {
        // Format de la durée
        val dureeFormatee = "${episode.duree} min"

        // Format de la date locale (ex: "12 mai 2021")
        val formatter = DateTimeFormatter.ofPattern("d MMMM yyyy", Locale.FRENCH)
        val dateFormatee = episode.date?.format(formatter)

        return EpisodeDTO(
            num = episode.num,
            titre = episode.titre,
            duree = dureeFormatee,
            date = dateFormatee ?: "Date inconnue"
        )
    }
}

