//1
let shift direction n list =
    let length = List.length list
    let n' = n % length // Ensure n is within the proper range
    
    match direction with
    | "left" ->
        let firstPart = List.take (length - n') list
        let secondPart = List.replicate n' 0
        secondPart @ firstPart
    | "right" ->
        let firstPart = List.replicate n' 0
        let secondPart = List.take (length - n') list
        firstPart @ secondPart
    | _ -> failwith "Invalid direction"

// Examples of usage
let result1 = shift "left" 3 [1;2;3;4;5]
let result2 = shift "right" 2 [1;2;3;4;5]
let result3 = shift "left" 6 [1;2;3;4;5]

printfn "%A" result1 // Should print [4; 5; 0; 0; 0]
printfn "%A" result2 // Should print [0; 0; 1; 2; 3]
printfn "%A" result3 // Should print [0; 0; 0; 0; 0]

//2
let rec containsSubstring substring str =
    match substring, str with
    | _, "" -> false
    | "", _ -> true
    | sub, s when s.StartsWith(sub) ->
        true
    | sub, s ->
        containsSubstring substring (s.Substring(1))

let filterSubstrings substring list =
    List.filter (containsSubstring substring) list

// Ejemplo de uso
let result = filterSubstrings "la" ["la casa"; "el perro"; "pintando la cerca"]

printfn "%A" result // Debería imprimir ["la casa"; "pintando la cerca"]

//3
let n_esimo n lista =
    let indices = [0..(List.length lista - 1)] // Lista de índices
    let elementosConIndices = List.zip indices lista // Combinar índices y elementos

    let elementoDeseado =
        List.tryFind (fun (index, _) -> index = n) elementosConIndices

    match elementoDeseado with
    | Some (_, result) -> Some result // Si se encuentra un elemento, devolverlo
    | None -> None // Si no se encuentra o hay duplicados, devolver None

// Ejemplos de uso
let resultado1 = n_esimo 2 [1;2;3;4;5]
let resultado2 = n_esimo 3 [1;2;3;4;5]
let resultado3 = n_esimo 6 [1;2;3;4;5]

printfn "%A" resultado1 // Debería imprimir Some 3
printfn "%A" resultado2 // Debería imprimir Some 4
printfn "%A" resultado3 // Debería imprimir None

