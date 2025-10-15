package com.ldv.apiseries.controller

import com.ldv.apiseries.dto.EpisodeDTO
import com.ldv.apiseries.model.dao.EpisodeDAO
import com.ldv.apiseries.model.entity.Episode
import com.ldv.apiseries.service.EpisodeService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.util.*


@RestController
class EpisodeController(val episodeDAO: EpisodeDAO, val episodeService: EpisodeService) {

    @GetMapping("/episodes", "/episodes/all")
    fun getAllEpisodes(): List<EpisodeDTO> {
        return episodeDAO.findAll().map { episodeService.convertToDTO(it) }
    }

    @GetMapping("/episodes/{id}")
    fun getEpisodeById(@PathVariable id: Long): EpisodeDTO? {
        // Récupérer l'épisode par son id
        val episode = episodeDAO.findById(id)

        // Vérifier si l'épisode est présent ou non
        return if (episode.isPresent) {
            // Convertir en DTO et renvoyer
            episodeService.convertToDTO(episode.get())
        } else {
            // Retourner null si l'épisode n'existe pas
            null
        }
    }
}

