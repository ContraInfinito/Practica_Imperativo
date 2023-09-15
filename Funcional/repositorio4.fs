module ShortestPath

open Containers

// Grafo de prueba con pesos en lugar de una lista de adyacencia
let grafoConPesos = [
    ("i", [("a", 3); ("b", 6)]);
    ("a", [("i", 3); ("c", 6); ("d", 5)]);
    ("b", [("i", 6); ("c", 2); ("d", 4)]);
    ("c", [("a", 6); ("b", 2); ("x", 7)]);
    ("d", [("a", 5); ("b", 4); ("f", 8)]);
    ("f", [("d", 8)]);
    ("x", [("c", 7)])
]

// Función para obtener el peso de una arista entre dos nodos
let obtenerPeso nodo1 nodo2 grafo =
    match List.tryFind (fun (nodo, peso) -> nodo = nodo2) (List.assoc nodo1 grafo) with
    | Some (_, peso) -> peso
    | None -> 0 // Peso por defecto si no se encuentra la arista

// Función para generar vecinos con pesos
let vecinosConPesos nodo grafo =
    match List.assoc_opt nodo grafo with
    | Some vecinosConPesos -> vecinosConPesos
    | None -> []

// Función para extender una ruta con peso acumulado
let extenderConPesos (ruta, peso) grafo =
    let nodoActual = List.head ruta in
    let vecinos = vecinosConPesos nodoActual grafo in
    List.choose
        (fun (vecino, pesoArista) ->
            if List.contains vecino ruta then None
            else
                let nuevoPeso = peso + pesoArista in
                Some (vecino::ruta, nuevoPeso))
        vecinos

// Función principal de búsqueda en profundidad con seguimiento de pesos
let dfsConPesos ini fin grafo =
    let rec dfsAux fin ruta grafo =
        if List.isEmpty ruta then []
        elif List.head ruta = fin then
            List.rev ruta
        else
            let rutasExtendidas = extenderConPesos ruta grafo in
            let rutasOrdenadas = List.sortBy (fun (_, peso) -> peso) rutasExtendidas in
            match rutasOrdenadas with
            | [] -> []
            | rutaExtendida :: rest ->
                dfsAux fin rutaExtendida grafo
    dfsAux fin [ini] grafo

// Ejemplo de uso
let resultado = dfsConPesos "i" "x" grafoConPesos

printfn "%A" resultado // Debería imprimir ["i"; "a"; "d"; "f"; "x"]
