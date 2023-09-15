module Laberinto

open Containers

// Representación del laberinto con paredes
let laberintoConParedes = [
    (1, [2; 3]);
    (2, [1; 4]);
    (3, [1; 5]);
    (4, [2; 6]);
    (5, [3; 7]);
    (6, [4; 8]);
    (7, [5]);
    (8, [6]);
]

// Función para eliminar las paredes del laberinto y representarlo como un grafo
let crearGrafo laberintoConParedes =
    List.map
        (fun (posicion, vecinos) -> (string posicion, List.map string vecinos))
        laberintoConParedes

// Función para realizar una búsqueda en profundidad (DFS) en el grafo
let rec dfs grafo inicio fin ruta rutas =
    if inicio = fin then
        List.rev (inicio::ruta)::rutas // Llegamos al final, agregamos la ruta a la lista de rutas
    else
        let vecinos = List.assoc inicio grafo
        List.foldBack
            (fun vecino acc ->
                if not (List.contains vecino ruta) then
                    dfs grafo vecino fin (vecino::ruta) acc
                else
                    acc)
            vecinos
            rutas

// Función para encontrar todas las rutas en el laberinto
let encontrarRutas grafo inicio fin =
    dfs grafo inicio fin [inicio] []

// Función para encontrar la ruta más corta entre dos puntos
let encontrarRutaMasCorta grafo inicio fin =
    let rutas = encontrarRutas grafo inicio fin
    match rutas with
    | [] -> None // No hay ruta
    | _ ->
        let rutasOrdenadas = List.sortBy List.length rutas
        Some (List.hd rutasOrdenadas)

// Ejemplo de uso
let grafoLaberinto = crearGrafo laberintoConParedes
let rutaMasCorta = encontrarRutaMasCorta grafoLaberinto "1" "7"

match rutaMasCorta with
| Some ruta -> printfn "Ruta más corta: %A" ruta
| None -> printfn "No hay ruta"
