# Deezer API - Backend Java Spring Boot

Este proyecto expone una API REST para manejar playlists y canciones usando datos de Deezer.

## Endpoints

1. **Buscar canciones (API de Deezer)**  
   `GET /search?q={término}`  
   Consulta la API pública de Deezer con un término de búsqueda y retorna los resultados en formato JSON.

2. **Crear una playlist**  
   `POST /`  
   Crea una nueva playlist.  
   Body de ejemplo:  
   ```json
   {
     "name": "Mi Playlist Favorita"
   }
   ```

3. **Obtener todas las playlists**  
   `GET /`  
   Retorna una lista de todas las playlists creadas.

4. **Eliminar una playlist**  
   `DELETE /{id}`  
   Elimina la playlist con el ID específico.

5. **Agregar una canción a una playlist**  
   `POST /{playlistId}/tracks/{trackId}`  
   Agrega una canción a la playlist con el ID dado.  
   Body de ejemplo:  
   ```json
   {
     "title": "Song Title",
     "duration": 200,
     "rank": 12345,
     "preview": "https://preview.mp3",
     "artistName": "Artist",
     "albumTitle": "Album",
     "artistPicture": "https://artist.jpg",
     "albumCover": "https://cover.jpg"
   }
   ```

6. **Eliminar una canción de una playlist**  
   `DELETE /{playlistId}/tracks/{trackId}`  
   Elimina la canción con ID específico de la playlist indicada.

7. **Obtener canciones de una playlist**  
   `GET /{playlistId}/tracks`  
   Retorna la lista de canciones asociadas a una playlist.
