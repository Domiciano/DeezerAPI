# Deezer API - Backend Java Spring Boot

Este proyecto expone una API REST que permite:

- Buscar canciones usando la API pública de Deezer.
- Crear y gestionar playlists locales.
- Agregar y eliminar canciones a/de una playlist.
- Consultar canciones dentro de una playlist.

## Endpoints disponibles

### 1. Buscar canciones (API de Deezer)
`GET /search?q={término}`  
Consulta la API pública de Deezer con un término de búsqueda y retorna los resultados en formato JSON.

- Parámetros:  
  - `q` (string): término de búsqueda (nombre de canción, artista, etc.)

- Ejemplo:  
  `/search?q=Imagine+Dragons`

### 2. Crear y gestionar playlists

#### Crear una playlist  
`POST /`  
Crea una nueva playlist.

- Body:  
  ```json
  {
    "name": "Mi Playlist Favorita"
  }
  ```

#### Obtener todas las playlists  
`GET /`  
Retorna una lista de todas las playlists creadas.

#### Eliminar una playlist  
`DELETE /{id}`  
Elimina la playlist con ID específico.

### 3. Manejo de canciones dentro de una playlist

#### Agregar una canción a una playlist  
`POST /{playlistId}/tracks/{trackId}`  
Agrega una canción a la playlist con el ID dado.

- Body:  
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

#### Eliminar una canción de una playlist  
`DELETE /{playlistId}/tracks/{trackId}`  
Elimina la canción con ID específico de la playlist indicada.

#### Obtener canciones de una playlist  
`GET /{playlistId}/tracks`  
Retorna la lista de canciones asociadas a una playlist.
